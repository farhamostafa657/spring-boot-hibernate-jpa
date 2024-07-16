package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
			//createStudent(studentDao);
			createMultipleStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deletAllStudent(studentDao);
		};
	}

	private void deletAllStudent(StudentDao studentDao) {
		System.out.println("Deleting all student");
		int numRowsDeleted=studentDao.deleteAll();
		System.out.println("Deleted Rows Count "+numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=1;
		studentDao.Delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		//retrieva student based on the id:primary key
		int studentId=5;
		System.out.println("Getting student with id :"+studentId);
		Student myStudent=studentDao.findByID(studentId);
		//chang firdt name to abdalla
		System.out.println("Updating student");
		myStudent.setFirstName("Abdalla");
		//update the student
		studentDao.update(myStudent);
		//display the updated student
		System.out.println("udate student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		//get a list of student
		List<Student>theStudents=studentDao.findByLastName("mostafa");
		//display list of student
		for(Student theStudent:theStudents){
			System.out.println(theStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of students
		List<Student> students=studentDao.findAll();

		//display list of student
		for(Student theStudent:students){
			System.out.println(theStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		System.out.println("creating new student object");
		Student tempStudent=new Student("abdo","mostafa","abdo@gmail.com");

		//save the student
		System.out.println("saving the student");
		studentDao.save(tempStudent);
		//display id of saved student
		int theid=tempStudent.getId();
		System.out.println("saved student : Generated id: "+theid);
		//retreve the student based on the id: primary key
		System.out.println("Retrieving the srudent with id "+theid);
		Student thestudent=studentDao.findByID(theid);
		//display student
		System.out.println("found the student"+thestudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		//create multiple student
		System.out.println("create 3 student object");
		Student tempstudent1=new Student("joan","Dao","joan@dao.com");
		Student tempstudent2=new Student("farha","mostafa","farha@dao.com");
		Student tempstudent3=new Student("fatma","mostafa","fatma@dao.com");
		//save the student object
		System.out.println("Save the student");
		studentDao.save(tempstudent1);
		studentDao.save(tempstudent2);
		studentDao.save(tempstudent3);

	}

	private void createStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("creating new student object");
		Student tempstudent=new Student("paul","Dao","paui@dao.com");
		//save the student object
		System.out.println("saving the student");
		studentDao.save(tempstudent);

		//display id of the saved student
		System.out.println("saved student . generated id"+tempstudent.getId());
	}
}















