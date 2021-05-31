package cn.com.system.employee.controller;

import cn.com.system.employee.res.ResultResponse;
import cn.com.system.employee.service.IEmployeeService;
import cn.com.system.employee.service.impl.EmployeeServiceImpl;
import cn.com.system.employee.utils.Constants;
import cn.com.system.employee.vo.VoEmployee;
import cn.com.system.employee.vo.VoPage;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl userService;

    @GetMapping("/employee/list")
    public String queryEmployee(@RequestParam("page") int pageNo,@RequestParam("limit") int limit,@RequestParam("title") String title,@RequestParam("sort") String idS){
        //ResultResponse res=null;
        //System.out.println(limit);

        JSONObject jo2 = new JSONObject();
        JSONObject jo3 = new JSONObject();
        //list<> info = this.userService;
        try{
        List<VoEmployee> info = this.userService.searchEmployees(pageNo,limit,title,idS);

        JSONArray ja2 = JSONArray.fromObject(info);

        jo3.put("total",2);
        jo3.put("items",ja2);

        jo2.put("code",20000);
        jo2.put("data",jo3);
        //res=new ResultResponse(Constants.STATUS_OK,Constants.MESSAGE_OK,jo2);
        System.out.println(jo2.toString());}catch(Exception e){
            jo2.put("code",500);
        }
        //{"code":20000,"data":{"total":2,"items":[{"empAge":21,"empBirthday":"1999-1-1 05:00:00","empId":1,"empName":"张三1","empPassword":"","empSex":"男"},{
        return jo2.toString();
    }
    @PostMapping("/employee/create")
    public String createEmployee(@RequestBody JSONObject emp){
        JSONObject jo = new JSONObject();
        System.out.println("sos0");
        if(this.userService.addEmployees(emp) == 1) {
            jo.put("code", 20000);
            jo.put("data", "success");
        }else{
            jo.put("code", 500);
            jo.put("data", "fail");
        }

        //{"code":20000,"data":"success"}
        return jo.toString();
    }
    @PostMapping("/employee/update")
    public String updateEmployee(@RequestBody JSONObject emp){
        JSONObject jo = new JSONObject();
        System.out.println("sos0");
        if(this.userService.updateEmployees(emp) == 1) {
            jo.put("code", 20000);
            jo.put("data", "success");
        }else{
            jo.put("code", 500);
            jo.put("data", "fail");
        }


        //{"code":20000,"data":"success"}
        return jo.toString();
    }
    @PostMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("empId") int empId) {
        JSONObject jo = new JSONObject();
        if(this.userService.deleteEmployee(empId) == 1) {
            jo.put("code", 20000);
            jo.put("data", "success");
        }else{
            jo.put("code", 500);
            jo.put("data", "fail");
        }
        return jo.toString();
    }



}
