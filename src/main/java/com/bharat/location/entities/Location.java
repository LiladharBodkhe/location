package com.bharat.location.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="loc")
public class Location {

	@Id
	private int id;
	@NotBlank(message="code is madatory")
	private String code;
	private String name;
	private String type;

	@Override
	public String toString() {
		return "Location [id=" + id + ", Code=" + code + ", name=" + name + ", type=" + type + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}	
