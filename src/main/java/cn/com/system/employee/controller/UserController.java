package cn.com.system.employee.controller;

import cn.com.system.employee.res.ResultResponse;
import cn.com.system.employee.service.IUserService;
import cn.com.system.employee.service.impl.UserServiceImpl;
import cn.com.system.employee.utils.Constants;
import cn.com.system.employee.utils.JwtUtil;
import cn.com.system.employee.vo.VoToken;
import cn.com.system.employee.vo.VoUser;
import cn.com.system.employee.vo.VoUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/*-----------------------------------------------传信息url/请求头信息/请求内容

 */

//前端和控制器
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/logout")
    public ResultResponse logout(@RequestHeader("X-Token") String token){
        ResultResponse res=new ResultResponse();
        String tokenValue = JwtUtil.verity(token);
        String username=tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS,"");
        res.setMessage("logout succuss");
        res.setCode(Constants.STATUS_OK);
        System.out.println("返回登陆界面");
        return res;
    }


    @GetMapping("/user/info")
    public ResultResponse info(@RequestParam("token") String token){
        ResultResponse res =new ResultResponse();
        //验证token是否有效
        String tokenValue = JwtUtil.verity(token);//success: zhangshan1
        //若ok返回对应的用户信息 否则返回500；
        if(tokenValue !=null && tokenValue.startsWith(JwtUtil.TOKEN_SUCCESS)){
            String username=tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS,"");
            //VoUser user=this.userService.searchUserByUserName();
            System.out.println("有效");

            VoUserInfo info= new VoUserInfo();
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            info.setIntroducation("测试用户");
            info.setName(username);
            List<String> roles = Arrays.asList("admin");
            info.setRoles(roles);
            //响应
            res.setData(info);
            res.setMessage(Constants.MESSAGE_OK);
            res.setCode(Constants.STATUS_OK);
        }else{
            res.setMessage(Constants.MESSAGE_FAIL);
            res.setCode(Constants.STATUS_FAIL);
            System.out.println("失败");
        }
        System.out.println("返回前端成功");

        return res;
    }

    @PostMapping("/user/login")
    public ResultResponse login(@RequestBody VoUser user){
        ResultResponse res =new ResultResponse();
        //调用UserService完成 username和password验证
        //根据验证结果，组成响应对象返回（ResultResponse）
        try {
            System.out.println(user);
            VoUser u = this.userService.verify(user);
            if(u != null){
                //创建一个taken数据，封装到res对象中
                String token=JwtUtil.sign(user.getUsername(),"-1");
                res.setCode(Constants.STATUS_OK);
                res.setMessage(Constants.MESSAGE_OK);
                res.setData(new VoToken(token));
            }else{
                res.setCode(Constants.STATUS_FAIL);
                res.setMessage(Constants.MESSAGE_FAIL+"用户名密码不匹配");
                res.setData("fail");
            }
        }catch (Exception e){
            res.setCode(Constants.STATUS_FAIL);
            res.setMessage(Constants.MESSAGE_FAIL);
            res.setData("fail");
            e.printStackTrace();
        }

        return res;
    }
}
