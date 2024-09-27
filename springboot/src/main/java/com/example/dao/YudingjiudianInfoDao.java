package com.example.dao;
import com.example.entity.Account;
import com.example.entity.YudingjiudianInfo;
import com.example.entity.ZhuceyonghuInfo;
import com.example.vo.YudingjiudianInfoVo;
import com.example.vo.YonghuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface YudingjiudianInfoDao extends Mapper<YudingjiudianInfo> {
    List<YudingjiudianInfoVo> findByJiudianleixing(@Param("jiudianleixing") String jiudianleixing);
	List<YudingjiudianInfoVo> findByJiudianleixinglist2(@Param("jiudianleixing") String jiudianleixing,@Param("zhanghao") String zhanghao);        
	//xiugaimimazy
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from yudingjiudian_info where jiudianmingcheng = #{jiudianmingcheng}")
    YudingjiudianInfo selectByJiudianmingcheng(String jiudianmingcheng);
	
	@Select("SELECT * FROM yudingjiudian_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	@Select("SELECT xxdiquziduanxxxx,count(id) as hsggs FROM yudingjiudian_info  group by xxdiquziduanxxxx")
    List<Map<String,String>> findByDiqu();
	
	
	
	@Select("SELECT distinct(jiudianleixing) as aa,count(id) as bb FROM yudingjiudian_info group by jiudianleixing order by id")List<Map<String, Object>> yudingjiudian_tj_jiudianleixing();
	
	
    
	
	
	
	//wexixinxzhuaxnyoxng
	
	@Select("select * from yudingjiudian_info where zhanghao = #{zhanghao}")    List<YudingjiudianInfo> findByzhanghao(ZhuceyonghuInfo zhuceyonghuInfo);    

}
