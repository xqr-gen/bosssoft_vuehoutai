package cn.com.system.employee.service;

import cn.com.system.employee.vo.VoUser;

public interface IUserService {
    /*
    如果验证成功 返回VoUser
    否则返回NULL
     */
    public VoUser verify(VoUser user);
}
