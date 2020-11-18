package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String number = request.getParameter("number");//вытаскиваю данные с jsp
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();//начало сессии

        boolean flag = false;
        try {

            Class.forName("com.mysql.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_register?serverTimezone=Europe/Moscow","root","1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()){
                //условие для формы
                if( email!=null && password!=null && email.equals(resultSet.getString(4)) && password.equals(resultSet.getString(5)))
                {
                    session.setAttribute("email", email);

                    Cookie cookie = new Cookie("email", email);
                    response.addCookie(cookie);
                    cookie.setMaxAge(1600);

                    flag = true;


                    response.sendRedirect("success.jsp");//отпр в шоп

                }else if(email.equals("admin@mail.ru") && password.equals("admin")){//условие админа
                    session.setAttribute("admin", email);
                    response.sendRedirect("adminpage.jsp");

                }
            }
            if(flag == false)
            {
                out.print("<script> alert('invalid username or password'); window.location.href = \"login.jsp\"; </script>");
            }

        }catch (Exception e){
            out.print(e);
        }

    }

}
