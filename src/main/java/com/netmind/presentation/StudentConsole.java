package com.netmind.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.netmind.business.StudentBlImpl;
import com.netmind.business.contracts.StudentBl;
import com.netmind.common.model.EnumStudent;
import com.netmind.common.model.Student;

public class StudentConsole {

	@SuppressWarnings("static-access")
	public static void selectOperation() {
		Scanner scanner = new Scanner(System.in);
		StudentBl studentBl = new StudentBlImpl();
		EnumStudent enumStudent = null;
		int option;

		do {
			showPrincipalMenu();
			option = Integer.parseInt(scanner.nextLine());
			enumStudent = EnumStudent.fromValue(option);

			switch (enumStudent) {
			case ADD_STUDENT:
				Student student = new Student();
				addNewStudent(student, scanner);
				try {
					studentBl.add(student);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case OLDEST_STUDENT:
				System.out.println("Oldest Age Student:");
				break;

			case MEAN_STUDENT:
				System.out.println("Student age average:");
				break;

			case EXIT:
				System.out.println("Good Bye!!");
				break;

			default:
				break;
			}
		} while (option != enumStudent.EXIT.value());
		scanner.close();
	}

	private static void showPrincipalMenu() {
		System.out.println("Select an option");
		System.out.println("1. Add a new student");
		System.out.println("2. Oldest age student");
		System.out.println("3. Mean age student");
		System.out.println("4. Exit");
	}

	private static void addNewStudent(Student student, Scanner scanner) {
		System.out.println("1. Add a new student");
		System.out.println("Add name: ");
		student.setName(scanner.nextLine());

		System.out.println("Add surname: ");
		student.setSurname(scanner.nextLine());

		System.out.println("Add data of birth (dd-mm-yyyy): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);

		student.setDateOfBirth(dateOfBirth);
	}

}
