package com.commonEntity;

import java.util.List;

public class GradeView extends Grade{
	
	private String students;

	public String getStudents() {
		return students;
	}

	public void setStudents(String students) {
		this.students = students;
	}
	
	public GradeView() {
		super();
	}

	public GradeView(String gradeNo, String gradeName, String teacher, List<Student> members, int score) {
		super(gradeNo, gradeName, teacher, members, score);
		// TODO Auto-generated constructor stub
	}


}
