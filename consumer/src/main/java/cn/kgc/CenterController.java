package cn.kgc;

import cn.kgc.service.AccountService;
import cn.kgc.service.RecordService;
import cn.kgc.vo.Account;
import cn.kgc.vo.Record;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CenterController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RecordService recordService;
    @PostMapping("page.do")
    public PageInfo<Map<String,Object>> showPage(Integer pageNo, Record record){
        return recordService.showPage(pageNo,record);
    }
    @PostMapping("transfer.do")
    public Map<String, Object> transfer(String currentCardNo,String targetCardNo,Double money){
        return recordService.transfer(currentCardNo,targetCardNo,money);
    }
    @PostMapping("login.do")
    public Map<String,Object> login(Account account){
        return accountService.login(account);
    }
    @PostMapping("login.do")
    public Map<String,Object> update(Account account){
        System.out.println("修改测试");
        return accountService.updatePwd(account);
    }
}
