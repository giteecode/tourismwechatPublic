package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.YudingjiudianInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.YudingjiudianInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.YudingjiudianInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class YudingjiudianInfoService {

    @Resource
    private YudingjiudianInfoDao yudingjiudianInfoDao;
	@Resource    private ZhuceyonghuInfoService zhuceyonghuInfoService;    
	
	//kuabiaojisuan3

    public YudingjiudianInfo add(YudingjiudianInfo yudingjiudianInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // yudingjiudianInfo.setAccount((double) 0);
	  
        yudingjiudianInfoDao.insertSelective(yudingjiudianInfo);
        return yudingjiudianInfo;
    }
	
	public List<Map<String,String>> findByDiqu() {
        return yudingjiudianInfoDao.findByDiqu();
    }

    public void delete(Long id) {
        yudingjiudianInfoDao.deleteByPrimaryKey(id);
    }

    public void update(YudingjiudianInfo yudingjiudianInfo) {
        //shangxchxuantupxian
		//youdianzan
        yudingjiudianInfoDao.updateByPrimaryKeySelective(yudingjiudianInfo);
    }

    public YudingjiudianInfo findById(Long id) {
        return yudingjiudianInfoDao.selectByPrimaryKey(id);
    }
	
    public List<YudingjiudianInfoVo> findAll() {
        return yudingjiudianInfoDao.findByJiudianleixing("all");
    }

    public PageInfo<YudingjiudianInfoVo> findPage(String jiudianleixing, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<YudingjiudianInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = yudingjiudianInfoDao.findByJiudianleixing(jiudianleixing);}
		if (user.getLevel().equals("注册用户")) {all = yudingjiudianInfoDao.findByJiudianleixinglist2(jiudianleixing,user.getZhanghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<YudingjiudianInfoVo> findPageqt(String jiudianleixing, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<YudingjiudianInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = yudingjiudianInfoDao.findByJiudianleixing(jiudianleixing);
		if (user.getLevel().equals("注册用户")) {all = yudingjiudianInfoDao.findByJiudianleixinglist2(jiudianleixing,user.getZhanghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public YudingjiudianInfoVo findByUserName(String name) {
//        return yudingjiudianInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        YudingjiudianInfo yudingjiudianInfo = yudingjiudianInfoDao.selectByPrimaryKey(id);
        if(yudingjiudianInfo.getStatus().equals("是")){
            yudingjiudianInfo.setStatus("否");
            yudingjiudianInfoDao.updateByPrimaryKey(yudingjiudianInfo);
        }else if(yudingjiudianInfo.getStatus().equals("否")){
            yudingjiudianInfo.setStatus("是");
            yudingjiudianInfoDao.updateByPrimaryKey(yudingjiudianInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
	
	public List<YudingjiudianInfo> getByzhuceyonghuZhanghao(String zhanghao) {    ZhuceyonghuInfo zhuceyonghuInfo = zhuceyonghuInfoService.findByZhanghao(zhanghao);    return yudingjiudianInfoDao.findByzhanghao(zhuceyonghuInfo);    }    
	
	//xiugaimimazys
	
}
