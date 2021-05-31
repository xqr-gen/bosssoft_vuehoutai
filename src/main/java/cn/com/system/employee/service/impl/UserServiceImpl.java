package cn.com.system.employee.service.impl;


import cn.com.system.employee.vo.VoUser;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl {
    private Map<String , VoUser> users =new HashMap<>();
    {
        VoUser user =null;
        for(int i=1;i<10;i++){
            user=new VoUser("zhangsan"+i, "password"+i);
            users.put(user.getUsername(),user);
        }
    }
    public VoUser verify(VoUser user){
        VoUser u=null;
        u=this.users.get(user.getUsername());

        if(u!=null){
            if(!u.getPassword().equals(user.getPassword())){
                u=null;
            }else{System.out.println("密码正确");}
        }
        return u;
    }
}
