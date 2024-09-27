package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "zhuceyonghu_info")
public class ZhuceyonghuInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "zhanghao")	private String zhanghao;	@Column(name = "mima")	private String mima;	@Column(name = "xingming")	private String xingming;	@Column(name = "xingbie")	private String xingbie;	@Column(name = "lianxihaoma")	private String lianxihaoma;	@Column(name = "chengshi")	private String chengshi;	@Column(name = "zhaopian")	private String zhaopian;	@Column(name = "level")	private String level;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	@Transient private List<Long> zhaopianflst;	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Long>  getZhaopianflst() {
        return zhaopianflst;
    }
    public void setZhaopianflst(List<Long> zhaopianflst) {
		this.zhaopianflst = zhaopianflst;
    }

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getZhanghao() {
        return zhanghao;
    }
    public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }	public String getLianxihaoma() {
        return lianxihaoma;
    }
    public void setLianxihaoma(String lianxihaoma) {
		this.lianxihaoma = lianxihaoma;
    }	public String getChengshi() {
        return chengshi;
    }
    public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
    }	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
    }	public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
		this.level = level;
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