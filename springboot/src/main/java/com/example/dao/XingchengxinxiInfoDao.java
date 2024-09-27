package com.example.dao;
import com.example.entity.Account;
import com.example.entity.XingchengxinxiInfo;
import com.example.entity.ZhuceyonghuInfo;
import com.example.vo.XingchengxinxiInfoVo;
import com.example.vo.YonghuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface XingchengxinxiInfoDao extends Mapper<XingchengxinxiInfo> {
    List<XingchengxinxiInfoVo> findByXingchengriqi(@Param("xingchengriqi") String xingchengriqi);
	List<XingchengxinxiInfoVo> findByXingchengriqilist2(@Param("xingchengriqi") String xingchengriqi,@Param("zhanghao") String zhanghao);        
	//xiugaimimazy
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from xingchengxinxi_info where chufadi = #{chufadi}")
    XingchengxinxiInfo selectByChufadi(String chufadi);
	
	@Select("SELECT * FROM xingchengxinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	@Select("SELECT xxdiquziduanxxxx,count(id) as hsggs FROM xingchengxinxi_info  group by xxdiquziduanxxxx")
    List<Map<String,String>> findByDiqu();
	
	
	
	
	
	
    
	
	
	
	//wexixinxzhuaxnyoxng
	
	@Select("select * from xingchengxinxi_info where zhanghao = #{zhanghao}")    List<XingchengxinxiInfo> findByzhanghao(ZhuceyonghuInfo zhuceyonghuInfo);    

}
