package dao;

import pojos.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDao {
    //1
    List<Student> getStudentDetail(int course_id) throws SQLException;

    //2
    String addStudent(Student s) throws SQLException;

    //3
    List<Student> topperDetail(int course_id) throws SQLException;

    //5
    String updateStudentMarks(int course_id, int marks) throws SQLException;

    //4
    String cancelAdm(int course_id) throws SQLException;


}
