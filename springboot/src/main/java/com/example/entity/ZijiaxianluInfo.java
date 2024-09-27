package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "zijiaxianlu_info")
public class ZijiaxianluInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "xianlumingcheng")	private String xianlumingcheng;	@Column(name = "chufadi")	private String chufadi;	@Column(name = "mudedi")	private String mudedi;	@Column(name = "quanchengjuli")	private String quanchengjuli;	@Column(name = "xiangqingmiaoshu")	private String xiangqingmiaoshu;	@Column(name = "tupian")	private String tupian;	
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

	
	public String getXianlumingcheng() {
        return xianlumingcheng;
    }
    public void setXianlumingcheng(String xianlumingcheng) {
		this.xianlumingcheng = xianlumingcheng;
    }	public String getChufadi() {
        return chufadi;
    }
    public void setChufadi(String chufadi) {
		this.chufadi = chufadi;
    }	public String getMudedi() {
        return mudedi;
    }
    public void setMudedi(String mudedi) {
		this.mudedi = mudedi;
    }	public String getQuanchengjuli() {
        return quanchengjuli;
    }
    public void setQuanchengjuli(String quanchengjuli) {
		this.quanchengjuli = quanchengjuli;
    }	public String getXiangqingmiaoshu() {
        return xiangqingmiaoshu;
    }
    public void setXiangqingmiaoshu(String xiangqingmiaoshu) {
		this.xiangqingmiaoshu = xiangqingmiaoshu;
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