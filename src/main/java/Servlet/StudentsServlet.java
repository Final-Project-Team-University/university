package Servlet;

import Repo.IStudentRepo;
import Repo.StudentRepo;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentsServlet")
public class StudentsServlet extends HttpServlet {
    IStudentRepo studentRepo = new StudentRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("student_id"));
        Student student = studentRepo.findReaderById(id);
        System.out.println(student);
        request.setAttribute("student",student);
        request.getRequestDispatcher("StudentsInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = studentRepo.query();
        request.setAttribute("students",students);

        ArrayList<Student> studentsSE = studentRepo.querySE();
        request.setAttribute("studentsSE",studentsSE);

        ArrayList<Student> studentsCS = studentRepo.queryCS();
        request.setAttribute("studentsCS",studentsCS);

        ArrayList<Student> studentsBD = studentRepo.queryBD();
        request.setAttribute("studentsBD",studentsBD);

        ArrayList<Student> studentsM = studentRepo.queryM();
        request.setAttribute("studentsM",studentsM);

        ArrayList<Student> studentsGroupF = studentRepo.queryGroupF();
        request.setAttribute("studentsGroupF",studentsGroupF);

        ArrayList<Student> studentsGroupS = studentRepo.queryGroupS();
        request.setAttribute("studentsGroupS",studentsGroupS);

        ArrayList<Student> studentsFirst = studentRepo.queryFirst();
        request.setAttribute("studentsFirst",studentsFirst);

        ArrayList<Student> studentsSecond = studentRepo.querySecond();
        request.setAttribute("studentsSecond",studentsSecond);


        request.getRequestDispatcher("StudentsList.jsp").forward(request,response);



    }
}
