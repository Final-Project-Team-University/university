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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StudentAddDeleteServlet")
public class StudentAddDeleteServlet extends HttpServlet {
    IStudentRepo studentRepo = new StudentRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String url = request.getParameter("url");
        String number = request.getParameter("number");
        String group = request.getParameter("group");
        String major = request.getParameter("major");
        String year = request.getParameter("year");
        Student student = new Student(firstname, lastname, email, password, url, number, group, major, year);

        System.out.println(student);

        if(firstname!=null && lastname!=null && email!=null && password!=null && url!=null && number!=null && group!=null && major!=null && year!=null && !studentRepo.checkEmail(email)) {
            studentRepo.add(student);
            out.println("New Student is added!");
        }
        else{
            out.println("This email is already exists!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);

        studentRepo.deleteReaderById(id);
        printWriter.println("Student has been deleted");

        request.getRequestDispatcher("StudentsList.jsp");
    }
}
