package Servlet;

import Repo.ClubDAO;
import domain.Club;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ClubServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private ClubDAO clubDAO;

    public void init() {
        clubDAO = new ClubDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertClub(request, response);
                    break;
                case "/delete":
                    deleteClub(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateClub(request, response);
                    break;
                case "/list":
                    listClub(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listClub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Club> listClub = clubDAO.selectAllClubs();
        request.setAttribute("listClub", listClub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Club existingClub = clubDAO.selectClub(id);
        System.out.println(existingClub);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("club", existingClub);
        dispatcher.forward(request, response);

    }

    private void insertClub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Club newClub = new Club(name, description);
        clubDAO.insertClub(newClub);
        response.sendRedirect("list");
    }

    private void updateClub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Club club = new Club(id, name, description);
        clubDAO.updateClub(club);
        response.sendRedirect("list");
    }

    private void deleteClub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clubDAO.deleteClub(id);
        response.sendRedirect("list");

    }

}
