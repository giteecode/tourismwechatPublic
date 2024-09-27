package com.example.dao;
import com.example.entity.Account;
import com.example.entity.JiudianxinxiInfo;

import com.example.vo.JiudianxinxiInfoVo;
import com.example.vo.YonghuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JiudianxinxiInfoDao extends Mapper<JiudianxinxiInfo> {
    List<JiudianxinxiInfoVo> findByWeizhi(@Param("weizhi") String weizhi);
	
	//xiugaimimazy
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jiudianxinxi_info where jiudianmingcheng = #{jiudianmingcheng}")
    JiudianxinxiInfo selectByJiudianmingcheng(String jiudianmingcheng);
	
	@Select("SELECT * FROM jiudianxinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	@Select("SELECT xxdiquziduanxxxx,count(id) as hsggs FROM jiudianxinxi_info  group by xxdiquziduanxxxx")
    List<Map<String,String>> findByDiqu();
	
	
	
	
	
	
    
	
	
	
	//wexixinxzhuaxnyoxng
	
	

}
