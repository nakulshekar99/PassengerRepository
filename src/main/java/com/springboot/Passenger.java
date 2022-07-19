package com.springboot;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Passenger {
@Id
@GeneratedValue


@Column(name="p_id")
private Integer p_id;
@Column(name="p_name")
private String p_name;
@Column(name="from_place")
private String from_place;
@Column(name="to_place")
private String to_place;
public Passenger() {
	
}
public Passenger(Integer p_id, String p_name, String from_place, String to_place) {
	
	this.p_id = p_id;
	this.p_name = p_name;
	this.from_place = from_place;
	this.to_place = to_place;
}
public Integer getP_id() {
	return p_id;
}
public void setP_id(Integer p_id) {
	this.p_id = p_id;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public String getFrom_place() {
	return from_place;
}
public void setFrom_place(String from_place) {
	this.from_place = from_place;
}
public String getTo_place() {
	return to_place;
}
public void setTo_place(String to_place) {
	this.to_place = to_place;
}
@Override
public String toString() {
	return "Passenger [p_id=" + p_id + ", p_name=" + p_name + ", from_place=" + from_place + ", to_place=" + to_place
			+ "]";
}



	
	
}
