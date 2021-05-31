package cn.com.system.employee.service;


import cn.com.system.employee.vo.VoPage;

public interface IEmployeeService {

    public VoPage searchEmployees(int pageNo,int limit,String idS);
}
