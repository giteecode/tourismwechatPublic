package com.example.dao;
import com.example.entity.Account;
import com.example.entity.JingdianxinxiInfo;

import com.example.vo.JingdianxinxiInfoVo;
import com.example.vo.YonghuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JingdianxinxiInfoDao extends Mapper<JingdianxinxiInfo> {
    List<JingdianxinxiInfoVo> findByJibie(@Param("jibie") String jibie);
	
	//xiugaimimazy
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jingdianxinxi_info where jingdianmingcheng = #{jingdianmingcheng}")
    JingdianxinxiInfo selectByJingdianmingcheng(String jingdianmingcheng);
	
	@Select("SELECT * FROM jingdianxinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	@Select("SELECT xxdiquziduanxxxx,count(id) as hsggs FROM jingdianxinxi_info  group by xxdiquziduanxxxx")
    List<Map<String,String>> findByDiqu();
	
	
	
	@Select("SELECT distinct(jibie) as aa,count(id) as bb FROM jingdianxinxi_info group by jibie order by id")List<Map<String, Object>> jingdianxinxi_tj_jibie();
	
	
    
	
	
	
	//wexixinxzhuaxnyoxng
	
	

}
