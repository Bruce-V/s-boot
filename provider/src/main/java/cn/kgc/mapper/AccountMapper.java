package cn.kgc.mapper;

import cn.kgc.vo.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    @Update("update account set password=#{password} where cardno=#{cardno}")
   Integer updatePwd(Account account);

    @Update("update account set balance=#{balance} where cardno=#{cardno}")
   Integer updateBalance(Account account);

    @Select("select * from account where cardno=#{cardno}")
   Account findByCardNo(String cardno);


}
