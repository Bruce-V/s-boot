package cn.kgc.service;

import cn.kgc.vo.Account;

import java.util.Map;

public interface AccountService {
    Map<String,Object> updatePwd(Account account);

    Map<String,Object>  login(Account account);


}
