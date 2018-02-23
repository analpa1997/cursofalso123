package com.example.demo.studyItem_package;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.subject_package.Subject;

@Entity
@Table(name = "StudyItems")
public class StudyItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studyItemID;

	private String type;

	private String name;
	
	private String fileName;
	
	@ManyToOne
	private Subject subject;
	
	private int module;
	
	private String internalName;
	
	private String originalName;
	
	private String extension;
	
	private String icon;

	/* Constructors */
	public StudyItem () {}
	
	
	public StudyItem(String type, String name, int module, String filename, String originalName) {
		setIcon(type);
		if (!type.isEmpty()) {
			type = "-" + type;
		}
		this.type = "file" + type;
		this.name = name;
		this.module = module;
		this.fileName = filename;
		this.originalName = originalName;
	}
	
	public StudyItem(String type, String name, int module, String originalName) {
		this(type, name, module, "", originalName);
	}
	
	

	/* Methods */

	public long getStudyItemID() {
		return studyItemID;
	}

	public void setStudyItemID(long studyItemID) {
		this.studyItemID = studyItemID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (!type.isEmpty()) {
			type = "-" + type;
		}
		this.type = "file" + type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getModule() {
		return module;
	}

	public void setModule(int module) {
		this.module = module;
	}

	public String getInternalName() {
		return internalName;
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getOriginalName() {
		return originalName;
	}



	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}



	public String getExtension() {
		return extension;
	}



	public void setExtension(String extension) {
		this.extension = extension;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	} 
	

	

}