package Servlet;

import Repo.NewsDAO;
import domain.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private NewsDAO newsDAO;

    public void init() {
        newsDAO = new NewsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertNews(request, response);
                    break;
                case "/delete":
                    deleteNews(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateNews(request, response);
                    break;
                default:
                    listNews(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<News> listNews = newsDAO.selectAllNews();
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("news-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("news-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        News existingNews = newsDAO.selectNews(id);
        System.out.println(existingNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("news-form.jsp");
        request.setAttribute("news", existingNews);
        dispatcher.forward(request, response);

    }

    private void insertNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        News news= new News(title, content);
        newsDAO.insertNews(news);
        response.sendRedirect("list");
    }

    private void updateNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        News news = new News(id, title, content);
        newsDAO.updateNews(news);
        response.sendRedirect("list");
    }

    private void deleteNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        newsDAO.deleteNews(id);
        response.sendRedirect("list");

    }
}
