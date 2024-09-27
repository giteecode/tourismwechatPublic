package com.example.dao;
import com.example.entity.Account;
import com.example.entity.MeirituijianInfo;

import com.example.vo.MeirituijianInfoVo;
import com.example.vo.YonghuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface MeirituijianInfoDao extends Mapper<MeirituijianInfo> {
    List<MeirituijianInfoVo> findByJibie(@Param("jibie") String jibie);
	
	//xiugaimimazy
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from meirituijian_info where jingdianmingcheng = #{jingdianmingcheng}")
    MeirituijianInfo selectByJingdianmingcheng(String jingdianmingcheng);
	
	@Select("SELECT * FROM meirituijian_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	@Select("SELECT xxdiquziduanxxxx,count(id) as hsggs FROM meirituijian_info  group by xxdiquziduanxxxx")
    List<Map<String,String>> findByDiqu();
	
	
	
	@Select("SELECT distinct(jibie) as aa,count(id) as bb FROM meirituijian_info group by jibie order by id")List<Map<String, Object>> meirituijian_tj_jibie();
	
	
    
	
	
	
	//wexixinxzhuaxnyoxng
	
	

}
