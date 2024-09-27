package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.XingchengxinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.XingchengxinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.XingchengxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class XingchengxinxiInfoService {

    @Resource
    private XingchengxinxiInfoDao xingchengxinxiInfoDao;
	@Resource    private ZhuceyonghuInfoService zhuceyonghuInfoService;    
	
	//kuabiaojisuan3

    public XingchengxinxiInfo add(XingchengxinxiInfo xingchengxinxiInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // xingchengxinxiInfo.setAccount((double) 0);
	  
        xingchengxinxiInfoDao.insertSelective(xingchengxinxiInfo);
        return xingchengxinxiInfo;
    }
	
	public List<Map<String,String>> findByDiqu() {
        return xingchengxinxiInfoDao.findByDiqu();
    }

    public void delete(Long id) {
        xingchengxinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(XingchengxinxiInfo xingchengxinxiInfo) {
        //shangxchxuantupxian
		//youdianzan
        xingchengxinxiInfoDao.updateByPrimaryKeySelective(xingchengxinxiInfo);
    }

    public XingchengxinxiInfo findById(Long id) {
        return xingchengxinxiInfoDao.selectByPrimaryKey(id);
    }
	
    public List<XingchengxinxiInfoVo> findAll() {
        return xingchengxinxiInfoDao.findByXingchengriqi("all");
    }

    public PageInfo<XingchengxinxiInfoVo> findPage(String xingchengriqi, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<XingchengxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = xingchengxinxiInfoDao.findByXingchengriqi(xingchengriqi);}
		if (user.getLevel().equals("注册用户")) {all = xingchengxinxiInfoDao.findByXingchengriqilist2(xingchengriqi,user.getZhanghao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<XingchengxinxiInfoVo> findPageqt(String xingchengriqi, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<XingchengxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = xingchengxinxiInfoDao.findByXingchengriqi(xingchengriqi);
		if (user.getLevel().equals("注册用户")) {all = xingchengxinxiInfoDao.findByXingchengriqilist2(xingchengriqi,user.getZhanghao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public XingchengxinxiInfoVo findByUserName(String name) {
//        return xingchengxinxiInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        XingchengxinxiInfo xingchengxinxiInfo = xingchengxinxiInfoDao.selectByPrimaryKey(id);
        if(xingchengxinxiInfo.getStatus().equals("是")){
            xingchengxinxiInfo.setStatus("否");
            xingchengxinxiInfoDao.updateByPrimaryKey(xingchengxinxiInfo);
        }else if(xingchengxinxiInfo.getStatus().equals("否")){
            xingchengxinxiInfo.setStatus("是");
            xingchengxinxiInfoDao.updateByPrimaryKey(xingchengxinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
	
	public List<XingchengxinxiInfo> getByzhuceyonghuZhanghao(String zhanghao) {    ZhuceyonghuInfo zhuceyonghuInfo = zhuceyonghuInfoService.findByZhanghao(zhanghao);    return xingchengxinxiInfoDao.findByzhanghao(zhuceyonghuInfo);    }    
	
	//xiugaimimazys
	
}
