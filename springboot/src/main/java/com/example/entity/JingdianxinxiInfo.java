package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jingdianxinxi_info")
public class JingdianxinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "jingdianmingcheng")	private String jingdianmingcheng;	@Column(name = "jibie")	private String jibie;	@Column(name = "danjiwangji")	private String danjiwangji;	@Column(name = "yingyeshijian")	private String yingyeshijian;	@Column(name = "piaojia")	private String piaojia;	@Column(name = "weizhi")	private String weizhi;	@Column(name = "tupian")	private String tupian;	@Column(name = "jianjie")	private String jianjie;	@Column(name = "dianzan_d")	private String dianzan_d;	@Column(name = "dianzan_c")	private String dianzan_c;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	@Transient private List<Long> tupianflst;	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Long>  getTupianflst() {
        return tupianflst;
    }
    public void setTupianflst(List<Long> tupianflst) {
		this.tupianflst = tupianflst;
    }

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }
    public void setJingdianmingcheng(String jingdianmingcheng) {
		this.jingdianmingcheng = jingdianmingcheng;
    }	public String getJibie() {
        return jibie;
    }
    public void setJibie(String jibie) {
		this.jibie = jibie;
    }	public String getDanjiwangji() {
        return danjiwangji;
    }
    public void setDanjiwangji(String danjiwangji) {
		this.danjiwangji = danjiwangji;
    }	public String getYingyeshijian() {
        return yingyeshijian;
    }
    public void setYingyeshijian(String yingyeshijian) {
		this.yingyeshijian = yingyeshijian;
    }	public String getPiaojia() {
        return piaojia;
    }
    public void setPiaojia(String piaojia) {
		this.piaojia = piaojia;
    }	public String getWeizhi() {
        return weizhi;
    }
    public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
		this.tupian = tupian;
    }	public String getJianjie() {
        return jianjie;
    }
    public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
    }	public String getDianzan_d() {
        return dianzan_d;
    }
    public void setDianzan_d(String dianzan_d) {
		this.dianzan_d = dianzan_d;
    }	public String getDianzan_c() {
        return dianzan_c;
    }
    public void setDianzan_c(String dianzan_c) {
		this.dianzan_c = dianzan_c;
    }	

	public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}

}