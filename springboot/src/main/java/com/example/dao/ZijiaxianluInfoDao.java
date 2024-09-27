package com.example.dao;
import com.example.entity.Account;
import com.example.entity.ZijiaxianluInfo;

import com.example.vo.ZijiaxianluInfoVo;
import com.example.vo.YonghuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ZijiaxianluInfoDao extends Mapper<ZijiaxianluInfo> {
    List<ZijiaxianluInfoVo> findByXiangqingmiaoshu(@Param("xiangqingmiaoshu") String xiangqingmiaoshu);
	
	//xiugaimimazy
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from zijiaxianlu_info where xianlumingcheng = #{xianlumingcheng}")
    ZijiaxianluInfo selectByXianlumingcheng(String xianlumingcheng);
	
	@Select("SELECT * FROM zijiaxianlu_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	@Select("SELECT xxdiquziduanxxxx,count(id) as hsggs FROM zijiaxianlu_info  group by xxdiquziduanxxxx")
    List<Map<String,String>> findByDiqu();
	
	
	
	
	
	
    
	
	
	
	//wexixinxzhuaxnyoxng
	
	

}
