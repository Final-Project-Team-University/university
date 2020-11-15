package Repo;

import domain.Student;

import java.util.ArrayList;
import java.util.Stack;

public interface IStudentRepo {
    void add(Student entity);
    ArrayList<Student> query();
    ArrayList<Student> querySE();
    ArrayList<Student> queryCS();
    ArrayList<Student> queryBD();
    ArrayList<Student> queryM();
    ArrayList<Student> queryGroupF();
    ArrayList<Student> queryGroupS();
    ArrayList<Student> queryFirst();
    ArrayList<Student> querySecond();
    Student findReaderById(int id);
    Stack<Student> findReaderByName(String data);
    boolean checkEmail(String email);
    void deleteReaderById(int id);
    void updateReader(Student student);
    boolean checkEmailExcept(Student student);
}
