package pojos;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private String address;
    private int marks;
    private Date joindate;
    private int course_id;


    public Student(String name, String email, String address, int marks, Date joindate, int course_id) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.marks = marks;
        this.joindate = joindate;
        this.course_id = course_id;
    }

    public Student(int id, String name, String email, String address, int marks, Date joindate, int course_id) {
        super();
        this.name = name;
        this.email = email;
        this.address = address;
        this.marks = marks;
        this.joindate = joindate;
        this.course_id = course_id;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", marks=" + marks +
                ", joindate=" + joindate +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getMarks() {
        return marks;
    }

    public Date getJoindate() {
        return joindate;
    }

    public int getCourse_id(){
        return course_id;
    }
}
