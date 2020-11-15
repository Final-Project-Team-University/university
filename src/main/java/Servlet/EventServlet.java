package Servlet;

import Repo.EventsDAO;
import domain.Events;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class EventServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private EventsDAO eventsDAO;

    public void init() {
        eventsDAO = new EventsDAO();
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
                    insertEvent(request, response);
                    break;
                case "/delete":
                    deleteEvents(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEvents(request, response);
                    break;
                default:
                    listEvents(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEvents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Events> listEvents = eventsDAO.selectAllEvents();
        request.setAttribute("listEvents", listEvents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("events-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("events-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Events existingEvents = eventsDAO.selectEvents(id);
        System.out.println(existingEvents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("events-form.jsp");
        request.setAttribute("events", existingEvents);
        dispatcher.forward(request, response);

    }

    private void insertEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        Events events= new Events(name, description, date);
        eventsDAO.insertEvent(events);
        response.sendRedirect("list");
    }

    private void updateEvents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("title");
        String description = request.getParameter("content");
        String date = request.getParameter("date");

        Events events = new Events(id, name, description, date);
        eventsDAO.updateEvents(events);
        response.sendRedirect("list");
    }

    private void deleteEvents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        eventsDAO.deleteEvents(id);
        response.sendRedirect("list");

    }
}
