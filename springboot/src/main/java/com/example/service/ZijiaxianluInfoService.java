package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.ZijiaxianluInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.ZijiaxianluInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.ZijiaxianluInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ZijiaxianluInfoService {

    @Resource
    private ZijiaxianluInfoDao zijiaxianluInfoDao;
	
	
	//kuabiaojisuan3

    public ZijiaxianluInfo add(ZijiaxianluInfo zijiaxianluInfo) {
        List<Long> tupianflst = zijiaxianluInfo.getTupianflst();
        if (!CollectionUtil.isEmpty(tupianflst)) {
            zijiaxianluInfo.setTupian(tupianflst.toString());
        }
		
		        //shangxchxuantupxian
        // 唯一校验
        
      // zijiaxianluInfo.setAccount((double) 0);
	  
        zijiaxianluInfoDao.insertSelective(zijiaxianluInfo);
        return zijiaxianluInfo;
    }
	
	public List<Map<String,String>> findByDiqu() {
        return zijiaxianluInfoDao.findByDiqu();
    }

    public void delete(Long id) {
        zijiaxianluInfoDao.deleteByPrimaryKey(id);
    }

    public void update(ZijiaxianluInfo zijiaxianluInfo) {
        List<Long> tupianflst = zijiaxianluInfo.getTupianflst();
        if (!CollectionUtil.isEmpty(tupianflst)) {
            zijiaxianluInfo.setTupian(tupianflst.toString());
        }
		
		        //shangxchxuantupxian
		//youdianzan
        zijiaxianluInfoDao.updateByPrimaryKeySelective(zijiaxianluInfo);
    }

    public ZijiaxianluInfo findById(Long id) {
        return zijiaxianluInfoDao.selectByPrimaryKey(id);
    }
	
    public List<ZijiaxianluInfoVo> findAll() {
        return zijiaxianluInfoDao.findByXiangqingmiaoshu("all");
    }

    public PageInfo<ZijiaxianluInfoVo> findPage(String xiangqingmiaoshu, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<ZijiaxianluInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = zijiaxianluInfoDao.findByXiangqingmiaoshu(xiangqingmiaoshu);}
		
        
        return PageInfo.of(all);
    }
	
	public PageInfo<ZijiaxianluInfoVo> findPageqt(String xiangqingmiaoshu, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<ZijiaxianluInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = zijiaxianluInfoDao.findByXiangqingmiaoshu(xiangqingmiaoshu);
		
	
	
        
        return PageInfo.of(all);
    }

   // public ZijiaxianluInfoVo findByUserName(String name) {
//        return zijiaxianluInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        ZijiaxianluInfo zijiaxianluInfo = zijiaxianluInfoDao.selectByPrimaryKey(id);
        if(zijiaxianluInfo.getStatus().equals("是")){
            zijiaxianluInfo.setStatus("否");
            zijiaxianluInfoDao.updateByPrimaryKey(zijiaxianluInfo);
        }else if(zijiaxianluInfo.getStatus().equals("否")){
            zijiaxianluInfo.setStatus("是");
            zijiaxianluInfoDao.updateByPrimaryKey(zijiaxianluInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
	
	
	
	//xiugaimimazys
	
}
