package Repo;

import domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

public class StudentRepo implements IStudentRepo{
    private IDBRepo dbrepo = new DBRepo();

    public void add(Student entity) {
        try {
            String sql = "INSERT INTO students(firstname, lastname, email, password, url, number, group, major, year) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getFirstname());
            stmt.setString(2, entity.getLastname());
            stmt.setString(3, entity.getEmail());
            stmt.setString(4, entity.getPassword());
            stmt.setString(5, entity.getUrl());
            stmt.setString(6, entity.getNumber());
            stmt.setString(7, entity.getGroup());
            stmt.setString(8, entity.getMajor());
            stmt.setString(9, entity.getYear());
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Student> query() {
        try {
            String sql = "Select * from students";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public Student findReaderById(int id) {
        try {
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void deleteReaderById(int id) {
        try {
                String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            System.out.println(id);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateReader(Student student) {
        try {
            String sql = "UPDATE students SET firstname = ?, lastname = ?, email = ?, password = ?, url = ?, number = ?, groupz = ?, major = ?, year = ? WHERE id= ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, student.getFirstname());
            stmt.setString(2, student.getLastname());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPassword());
            stmt.setString(5, student.getUrl());
            stmt.setString(6, student.getNumber());
            stmt.setString(7, student.getGroup());
            stmt.setString(8, student.getMajor());
            stmt.setString(9, student.getYear());
            stmt.setInt(10, student.getId());
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Stack<Student> findReaderByName(String data) {
        try {
            String sql = "SELECT * FROM students WHERE firstname = ?, lastname = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, data);
            ResultSet rs = stmt.executeQuery();
            Stack<Student> students = new Stack<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean checkEmail(String email) {
        try {
            String sql = "SELECT * FROM students WHERE email = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean checkEmailExcept(Student student) {
        try {
            String sql = "SELECT * FROM students WHERE email = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, student.getEmail());
            ResultSet rs = stmt.executeQuery();
            Student readerPrevious = findReaderById(student.getId());
            if (rs.next()) {
                if(readerPrevious.getEmail().equals(student.getEmail())){
                    return false;
                }
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public ArrayList<Student> querySE() {
        try {
            String sql = "Select * from students WHERE major = 'SE' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> queryCS() {
        try {
            String sql = "Select * from students WHERE major = 'CS' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> queryBD() {
        try {
            String sql = "Select * from students WHERE major = 'BD' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> queryM() {
        try {
            String sql = "Select * from students WHERE major = 'M' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> queryGroupF() {
        try {
            String sql = "Select * from students WHERE students.groupz like '1904' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> queryGroupS() {
        try {
            String sql = "Select * from students WHERE students.groupz like '1905' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public ArrayList<Student> queryFirst() {
        try {
            String sql = "Select * from students WHERE students.year like '1' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public ArrayList<Student> querySecond() {
        try {
            String sql = "Select * from students WHERE students.year like '2' ";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("url"),
                        rs.getString("number"),
                        rs.getString("groupz"),
                        rs.getString("major"),
                        rs.getString("year")
                );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
