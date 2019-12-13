package tester;

import dao.StudentDaoImpl;
import pojos.Student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLayeredApplication {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);){
            StudentDaoImpl dao = new StudentDaoImpl();
            boolean flag = true;
            while(flag){
                System.out.println("1.Display Details");
                System.out.println("2.Admission");
                System.out.println("3.Topper Details");
                System.out.println("4.Cancel Admission");
                System.out.println("5.Update Marks");
                System.out.println("10. Exit");

                switch (sc.nextInt()){
                    case 1: System.out.println("Enter course_id of student to get details");
                        List<Student> s1 = dao.getStudentDetails(sc.nextInt());
                        System.out.println("Student details");
                        System.out.println(s1);
                        break;
                    case 2: System.out.println("Enter Student name, email, address, dob, marks, course_id");
                        dao.addStudent(new Student(sc.next(), sc.next(), sc.next(), sc.nextInt(),  Date.valueOf(sc.next()), sc.nextInt()));
                        break;
                    case 3: System.out.println("Enter course_id");
                        List<Student> s2 = dao.topperDetail(sc.nextInt());
                        System.out.println("Topper Details");
                        System.out.println(s2);
                        break;
                    case 4: System.out.println("Enter course_id to cancel admission");
                        dao.cancelAdm(sc.nextInt());
                        break;
                    case 5: System.out.println("Enter student marks and course_id to update!!!");
                        dao.updateStudentMarks(sc.nextInt(), sc.nextInt());
                        break;
                    case 10: flag = false;
                            dao.cleanUp();
                            break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
