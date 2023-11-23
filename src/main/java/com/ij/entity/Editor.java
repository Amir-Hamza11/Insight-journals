package com.ij.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editor")
@Getter
@Setter
public class Editor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eid;
	private String editor;
	private String epassword;
	public Editor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editor(Long eid, String editor, String epassword) {
		super();
		this.eid = eid;
		this.editor = editor;
		this.epassword = epassword;
	}
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	
	

}
