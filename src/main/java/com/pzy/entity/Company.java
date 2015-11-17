package com.pzy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_company")
public class Company {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	@Column(columnDefinition="TEXT") 
	private String context;
	/**收费标准*/
	@Column(columnDefinition="TEXT") 
	private String sfbz;
	private String email;
	private String addr;
	private String site;
	private String tel;
	
	private Double pricestar;
	private Double priceadd;
	public String getSfbz() {
		return sfbz;
	}
	public void setSfbz(String sfbz) {
		this.sfbz = sfbz;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Double getPricestar() {
		return pricestar;
	}
	public void setPricestar(Double pricestar) {
		this.pricestar = pricestar;
	}
	public Double getPriceadd() {
		return priceadd;
	}
	public void setPriceadd(Double priceadd) {
		this.priceadd = priceadd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
