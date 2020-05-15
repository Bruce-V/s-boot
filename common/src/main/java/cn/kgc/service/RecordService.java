package cn.kgc.service;

import cn.kgc.vo.Record;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface RecordService {

    Map<String, Object> transfer(String currentCardNo,String targetCardNo,Double money);

  PageInfo<Map<String,Object>> showPage(Integer pageNo, Record record);
}
