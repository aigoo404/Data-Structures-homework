package week9.Task1;

import java.util.*;

public class Faculty {
	String name;
	String address;
	List<Course> courses;

	public Faculty(String name, String address) {
		this.name = name;
		this.address = address;
		this.courses = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public int getCourseCount() {
		return this.courses.size();
	}

	public String toString() {
		return "Faculty[name: " + name + ", address: " + address + ", courses: " + courses + "]";
	}

	public Course getMaxPracticalCourse() {
		Course maxCourse = null;
		int maxCount = 0;
		for (Course course : courses) {
			if (course.getType().equals("Practice")) {
				int count = course.getStudentCount();
				if (count > maxCount) {
					maxCount = count;
					maxCourse = course;
				}
			}
		}
		return maxCourse;
	}

	public Map<Integer, List<Student>> groupStudentByYear() {
		Map<Integer, List<Student>> map = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				int year = student.getYear();
				if (!map.containsKey(year)) {
					map.put(year, new ArrayList<>());
				}
				map.get(year).add(student);
			}
		}
		return map;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> set = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				int remainder = c2.getStudentCount() - c1.getStudentCount();
				if (remainder != 0) {
					return remainder;
				} else {
					return c1.getId().compareTo(c2.getId());
				}
			}
		});
		for (Course course : courses) {
			if (course.getType().equals(type)) {
				set.add(course);
			}
		}
		return set;
	}
}
