package ru.kpfu.itis.group11408.etovladislav.jb.task2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Group {

	private List<String> students;

	public Group() {
		students = new LinkedList<>();
	}

	public void addStudent(String name) {
		students.add(name);
	}

	public int countStudents() {
		return students.size();
	}

	public static void main(String[] args) {

	}
	
	public List<String> getStudents(){
		return students;
	}
	
	public void sortStudents(){
		Collections.sort(students);
	}
}
