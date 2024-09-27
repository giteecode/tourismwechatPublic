package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jiudianxinxi_info")
public class JiudianxinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "jiudianmingcheng")	private String jiudianmingcheng;	@Column(name = "jiudianleixing")	private String jiudianleixing;	@Column(name = "weizhi")	private String weizhi;	@Column(name = "dianhua")	private String dianhua;	@Column(name = "jiage")	private String jiage;	@Column(name = "jianjie")	private String jianjie;	@Column(name = "tupian")	private String tupian;	
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

	
	public String getJiudianmingcheng() {
        return jiudianmingcheng;
    }
    public void setJiudianmingcheng(String jiudianmingcheng) {
		this.jiudianmingcheng = jiudianmingcheng;
    }	public String getJiudianleixing() {
        return jiudianleixing;
    }
    public void setJiudianleixing(String jiudianleixing) {
		this.jiudianleixing = jiudianleixing;
    }	public String getWeizhi() {
        return weizhi;
    }
    public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
    }	public String getDianhua() {
        return dianhua;
    }
    public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
		this.jiage = jiage;
    }	public String getJianjie() {
        return jianjie;
    }
    public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
		this.tupian = tupian;
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