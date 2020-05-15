package cn.kgc.service;

import cn.kgc.mapper.AccountMapper;
import cn.kgc.mapper.RecordMapper;
import cn.kgc.vo.Account;
import cn.kgc.vo.Record;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
@Service
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Map<String, Object> transfer(String currentCardNo, String targetCardNo, Double money) {
        Map<String,Object> map=new HashMap<String, Object>();
        Account targetAccount=new Account();
        if (targetAccount!=null){
            if (targetAccount.getStatus()==0){
                map.put("msg","对方账号被冻结，无法转账！");
                return map;
            }
        }else {
            map.put("msg","目标账号不存在，无法转账！");
            return map;
        }
        Account currentAccount=new Account();
        if (currentAccount.getBalance()<money){
            map.put("msg","余额不足，转账失败！");
            return map;
        }
        //当前账号
        currentAccount.setBalance(currentAccount.getBalance()-money);
        accountMapper.updateBalance(currentAccount);
        Record currentRecord =new Record();
        currentRecord.setBalance(currentAccount.getBalance());
        currentRecord.setCardno(currentCardNo);
        currentRecord.setExpense(money);
        currentRecord.setIncome(0.0);
        currentRecord.setTransactiontype("转出");
        recordMapper.addRecord(currentRecord);

        //目标账号
        targetAccount.setBalance(targetAccount.getBalance()+money);
        accountMapper.updateBalance(targetAccount);
        Record targetRcord=new Record();
        targetRcord.setBalance(targetAccount.getBalance());
        targetRcord .setExpense(0.0);
        targetRcord.setIncome(money);
        targetRcord.setTransactiontype("转入");
        recordMapper.addRecord(targetRcord);
        map.put("msg","success!");
        return map;
    }

    @Override
    public PageInfo<Map<String, Object>> showPage(Integer pageNm, Record record) {
        return null;
    }
}
