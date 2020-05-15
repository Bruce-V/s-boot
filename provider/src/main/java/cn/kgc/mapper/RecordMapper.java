package cn.kgc.mapper;

import cn.kgc.vo.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    @Insert("insert into record(balance,cardno,expense,income,transactionType,transactiondata) values(#{balance},#{cardno},#{expense},#{income},#{transactionType},now())")
    Integer addRecord(Record record);

   @Select("select * from record where cardno=#{cardno} and transactiondata between #{startTime} and #{endTime} order by transactiondata desc")
    List<Map<String,Object>> showData(Record record);
}
