package com.example.entity;

// データベースのデータをプログラムで扱えるようカプセル化し再構築する
// データベース一行ごとにオブジェクトを生成しList型のクラスに格納する

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARIES")
public class Library {
	
	@Id
	@SequenceGenerator(name = "LIBRARY_ID_GENERATOR", sequenceName = "LIBLARY_ID_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIBRARY_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
