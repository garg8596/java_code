package dao;

import pojos.Student;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.fetchConnection;

public class StudentDaoImpl {
    private Connection cn;
    private PreparedStatement pst1, pst2, pst3, pst4, pst5;

    public StudentDaoImpl() throws Exception{
        cn = fetchConnection();
        pst1 = cn.prepareStatement("select * from student where course_id=?");
        pst2 = cn.prepareStatement("insert into student values(default, ?, ?, ?, ?, ?, ?)");
        pst3 = cn.prepareStatement("select * from student where course_id=?");
        pst4 = cn.prepareStatement("delete from student where course_id=?");
        pst5 = cn.prepareCall("update student set marks=? where course_id=?");
    }

    public void cleanUp() throws SQLException{
        if(pst1 !=null)
            pst1.close();
        if(pst2 !=null)
            pst2.close();
        if(pst3 !=null)
            pst3.close();
        if(pst4 !=null)
            pst4.close();
        if(pst5 !=null)
            pst5.close();

        if(cn != null)
            cn.close();
        System.out.println("Student dao cleaned up.....");
    }

    public List<Student> getStudentDetails(int course_id) throws SQLException {
        List<Student> s1 = new ArrayList<>();

        pst1.setInt(1, course_id);
        try(ResultSet rst = pst1.executeQuery()){
            while(rst.next())
                s1.add(new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6), rst.getInt(7)));
        }
        return s1;
    }

    public String addStudent(Student s) throws SQLException{
        pst2.setString(1, s.getName());
        pst2.setString(2, s.getEmail());
        pst2.setString(3, s.getAddress());
        pst2.setDate(4, (java.sql.Date) s.getJoindate());
        pst2.setInt(5, s.getMarks());
        pst2.setInt(6, s.getCourse_id());

        int updateCount = pst2.executeUpdate();
        if(updateCount == 1)
            return "Admission Successful!!!!";
        return "Admission Failed!!!";
    }

    public  List<Student> topperDetail(int course_id) throws SQLException{
        List<Student> s1 = new ArrayList<>();
        pst3.setInt(1, course_id);

        try(ResultSet rst = pst3.executeQuery()){
            while(rst.next())
                s1.add(new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6), rst.getInt(7)));
        }
        return s1;
    }

    public  String cancelAdm(int course_id) throws SQLException{
        pst4.setInt(1, course_id);
        int cancel = pst4.executeUpdate();
        if(cancel == 1)
            return "Admission Cancels!!!";
        return "Operation Fails!!!";
    }

   public String updateStudentMarks(int marks, int course_id) throws SQLException{
        pst5.setInt(1, marks);
        pst5.setInt(2, course_id);

        int updateCount = pst5.executeUpdate();
        if(updateCount==1)
            return "Marks Update Successfully!!!!";
        return "Updating Fails!!!";
    }

}
