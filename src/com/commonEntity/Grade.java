package com.commonEntity;

import java.util.List;

public class Grade {
	
	private String gradeNo;
	
	private String gradeName;
	
	private String teacher;
	
	private List<Student> members;
	
	private int score;

	public Grade(String gradeNo, String gradeName, String teacher, List<Student> members, int score) {
		super();
		this.gradeNo = gradeNo;
		this.gradeName = gradeName;
		this.teacher = teacher;
		this.members = members;
		this.score = score;
	}

	public Grade() {}

	public String getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public List<Student> getMembers() {
		return members;
	}

	public void setMembers(List<Student> members) {
		this.members = members;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
