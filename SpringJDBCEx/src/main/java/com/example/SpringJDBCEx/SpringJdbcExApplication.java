package com.example.SpringJDBCEx;

import com.example.SpringJDBCEx.model.Student;
import com.example.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		StudentService service = context.getBean(StudentService.class);
//		Student s1 = context.getBean(Student.class);
//		s1.setRollno(104);
//		s1.setName("vishwa");
//		s1.setMarks(98);
//
//		service.addStudent(s1);
		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
