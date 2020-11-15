package Repo;

import domain.Events;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventsDAO {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/university";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "123";

    private static final String INSERT_EVENTS_SQL = "INSERT INTO events" + "  (name, description, date) VALUES " +
            " (?,?, ?);";

    private static final String SELECT_EVENTS_BY_ID = "select id,name, description, date from events where id =?";
    private static final String SELECT_ALL_EVENTS = "select * from events";
    private static final String DELETE_EVENTS_SQL = "delete from events where id = ?;";
    private static final String UPDATE_EVENTS_SQL = "update events set name=?,  description= ?, date=? where id = ?;";

    public EventsDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEvent(Events events) throws SQLException {
        System.out.println(INSERT_EVENTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENTS_SQL)) {
            preparedStatement.setString(1, events.getName());
            preparedStatement.setString(2, events.getDescription());
            preparedStatement.setString(3, events.getDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Events selectEvents(int id) {
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EVENTS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String date = rs.getString("date");
                return new Events(id, name, description, date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    public List< Events > selectAllEvents() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List <Events> events = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EVENTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String date = rs.getString("date");
                events.add(new Events(id, name, description, date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return events;
    }

    public boolean deleteEvents(int id) throws SQLException {
        boolean rowDeleted;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EVENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateEvents(Events events) throws SQLException {
        boolean rowUpdated;
        System.out.println(events);
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EVENTS_SQL);) {
            statement.setString(1, events.getName());
            statement.setString(2, events.getDescription());
            statement.setString(3, events.getDate());
            statement.setInt(4, events.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

