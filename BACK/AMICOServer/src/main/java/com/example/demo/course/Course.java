package com.example.demo.course;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.skill.Skill;
import com.example.demo.subject.Subject;
import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseID;

	private String name;

	private String internalName;

	private String courseLanguage;

	private String type;

	private Date startDate;

	private Date endDate;

	private String startDateString;

	private String endDateString;

	private int numberOfUsers;

	@Column(length = Short.MAX_VALUE)
	private String courseDescription;

	private String originalName;

	private boolean isCompleted;

	@JsonIgnore
	@ManyToMany(mappedBy="inscribedCourses", fetch = FetchType.LAZY)
	private List<User> inscribedUsers = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<Subject> subjects = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<Skill> skills = new ArrayList<>();

	/* Constructors */
	public Course() {
	}

	public Course(String name, String courseLanguage, Date startDate, Date endDate, String courseDescription,
			String type, String urlImage) {
		super();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.name = name;
		this.internalName = this.name.replaceAll(" ", "-").toLowerCase();
		this.courseLanguage = courseLanguage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseDescription = courseDescription;
		this.type = type.replaceAll(" ", "-").toLowerCase();
		this.originalName = "../img/courses/" + this.internalName + "/" + urlImage;
		this.isCompleted = false;
		this.startDateString = dateFormat.format(this.startDate);
		this.endDateString = dateFormat.format(this.endDate);
	}

	public Course(String name, String courseLanguage, String courseDescription, String type, String urlImage) {
		super();
		this.name = name;
		this.internalName = this.name.replaceAll(" ", "-").toLowerCase();
		this.courseLanguage = courseLanguage;
		this.courseDescription = courseDescription;
		this.type = type.replaceAll(" ", "-").toLowerCase();
		this.originalName = "../img/courses/" + this.internalName + "/" + urlImage;
		this.isCompleted = false;

		this.endDate = Date.valueOf(LocalDate.now());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Random random = new Random();
		LocalDate start = LocalDate.of(2018, Month.MARCH, 1);
		LocalDate end = LocalDate.of(2025, Month.DECEMBER, 31);
		long days = ChronoUnit.DAYS.between(start, end);
		long months = ChronoUnit.MONTHS.between(start, end);
		long years = ChronoUnit.YEARS.between(start, end);
		LocalDate randomDate = start.plusDays(random.nextInt((int) days + 1));
		randomDate = start.plusMonths(random.nextInt((int) months + 1));
		randomDate = start.plusYears(random.nextInt((int) years + 1));
		Date date = Date.valueOf(randomDate);
		this.startDate = date;

		while (this.endDate.compareTo(this.startDate) < 0) {
			random = new Random();
			LocalDate randomDate2 = start.plusDays(random.nextInt((int) days + 1));
			randomDate2 = start.plusMonths(random.nextInt((int) months + 1));
			randomDate2 = start.plusYears(random.nextInt((int) years + 1));
			Date date2 = Date.valueOf(randomDate2);
			this.endDate = date2;
		}

		this.startDateString = dateFormat.format(this.startDate);
		this.endDateString = dateFormat.format(this.endDate);
	}

	/* Methods */

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.internalName = name.replaceAll(" ", "-").toLowerCase();
	}

	public String getCourseLanguage() {
		return courseLanguage;
	}

	public void setCourseLanguage(String courseLanguage) {
		this.courseLanguage = courseLanguage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String urlImage) {
		this.originalName = urlImage;
	}

	public List<User> getInscribedUsers() {
		return inscribedUsers;
	}

	public void setInscribedUsers(List<User> inscribedUsers) {
		this.inscribedUsers = inscribedUsers;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}