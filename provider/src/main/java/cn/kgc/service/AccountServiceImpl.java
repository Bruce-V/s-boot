package cn.kgc.service;

import cn.kgc.mapper.AccountMapper;
import cn.kgc.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Map<String, Object> updatePwd(Account account) {
        Map<String,Object> map=new HashMap<String, Object>();
        Account cardInfo=accountMapper.findByCardNo(account.getCardno());

            if (!cardInfo.getPassword().equals(account.getPassword())){
                map.put("msg","与旧密码不一直，请重试");
                 return map;
            }else {
                int num=accountMapper.updatePwd(account);
                map.put("msg",map);
                return map;
            }

    }

    @Override
    public Map<String, Object> login(Account account) {
        Map<String,Object> map=new HashMap<String, Object>();
        Account cardInfo=accountMapper.findByCardNo(account.getCardno());
        if (cardInfo!=null){
            if (!cardInfo.getPassword().equals(account.getPassword())){
                map.put("msg","密码错误，请重新输入！");
                return map;
            }
            if (cardInfo.getStatus()==0){
                map.put("msg","当前账号被冻结，无法登录");
                return map;
            }
            map.put("cardNo",account.getCardno());
            map.put("msg","success");
            return map;
        }else {
            map.put("msg","该账号不存在，请重新输入！");
            return map;
        }
    }
}
