package com.vishwa.SpringDataJPAEx;

import com.vishwa.SpringDataJPAEx.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

//		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
//		Student s3 = context.getBean(Student.class);
//
//		s1.setRollno(101);
//		s1.setName("Navin");
//		s1.setMarks(75);
//
		s2.setRollno(102);
		s2.setName("Kiran");
		s2.setMarks(90);
//
//		s3.setRollno(103);
//		s3.setName("Harsh");
//		s3.setMarks(90);
//
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
		repo.delete(s2);
		System.out.println(repo.findById(102));
//		Optional<Student> op = repo.findById(103);
//		System.out.println(op.orElse(new Student()));
//		System.out.println(repo.findByName("Navin"));
//		System.out.println(repo.findByMarksGreaterThan(70));
	}

}
