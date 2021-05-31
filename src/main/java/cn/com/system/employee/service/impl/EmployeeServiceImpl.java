package cn.com.system.employee.service.impl;


import cn.com.system.employee.vo.VoEmployee;
import cn.com.system.employee.vo.VoPage;
import cn.com.system.employee.vo.VoUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl {
    private List<VoEmployee> employees =new ArrayList<>();
    private int n=11;
    {
        VoEmployee employee;
        for(int i=1;i<n;i++){
            //2001-11-30 05:32:00
            employee=new VoEmployee(""+i,"张三"+i,"","男",""+20,"1999-1-1");
            employees.add(i-1,employee);

        }

    }

    public List<VoEmployee> searchEmployees(int pageNo,int limit,String title,String idS){
        List<VoEmployee> employees2 =new ArrayList<>();
        /*List<VoEmployee> info=new ArrayList();
        System.out.println("sos1");
        for(int i=-5+pageNo*limit; i<i+limit ; i++) {
            int j=0;
            info.add(0+j, employees.get(i));
            j++;
            System.out.println("sos");
        }
        System.out.println("sos2");
        return info;*/
        if(title.equals("0") == true || title.isEmpty()){
            return employees;
        }else{
            int k=0;
            for(int i=0;i<employees.size();i++){
                if(employees.get(i).getEmpName().equals(title)) {
                    employees2.add(employees.get(i));
                    return employees2;
                }
            }
            employees2=null;
            return employees2;
        }

    }


    public int addEmployees(JSONObject emp){
        VoEmployee employee;
        try {
            employee = new VoEmployee(emp.getString("empId"), emp.getString("empName"), "", emp.getString("empSex"), emp.getString("empAge"), emp.getString("empBirthday"));
           // System.out.println(employee.getEmpAge());
        }catch(Exception e){
            System.out.println("失败1");
            return 0;
        }
        try{

        employees.add(employee);

        return 1;
        }catch(Exception e){
            System.out.println("失败2");
            return 0;
        }
    }
    public int updateEmployees(JSONObject emp){
        VoEmployee employee;
        try {
            employee = new VoEmployee(emp.getString("empId"), emp.getString("empName"), "", emp.getString("empSex"), emp.getString("empAge"), emp.getString("empBirthday"));
            // System.out.println(employee.getEmpAge());
        }catch(Exception e){
            System.out.println("失败1");
            return 0;
        }
        try{
            int t=Integer.parseInt(emp.getString("empId"));
            for(int i=0;i<employees.size();i++){
                if(Integer.parseInt(employees.get(i).getEmpId()) == t) {
                    employees.set(i,employee);
                    break;
                }
            }

            return 1;
        }catch(Exception e){
            System.out.println("失败2");
            return 0;
        }
    }
    public int deleteEmployee(int empId){
        try{
        for(int i=0;i<employees.size();i++){
            if(Integer.parseInt(employees.get(i).getEmpId()) == empId) {
                employees.remove(i);

                break;
            }
        }
        return 1;}catch (Exception e){
            return 0;
        }

    }
}
