package Repo;

import domain.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/university";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "123";

    private static final String INSERT_NEWS_SQL = "INSERT INTO news" + "  (title, content) VALUES " +
            " (?, ?);";

    private static final String SELECT_NEWS_BY_ID = "select id,title, content from news where id =?";
    private static final String SELECT_ALL_NEWS = "select * from news;";
    private static final String DELETE_NEWS_SQL = "delete from news where id = ?;";
    private static final String UPDATE_NEWS_SQL = "update news set title=?,  content= ? where id = ?;";

    public NewsDAO() {}

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

    public void insertNews(News news) throws SQLException {
        // System.out.println(INSERT_NEWS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWS_SQL)) {
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public News selectNews(int id) {
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEWS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                return new News(id, title, content);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    public List< News > selectAllNews() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List <News> news = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NEWS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                news.add(new News(id, title, content));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return news;
    }

    public boolean deleteNews(int id) throws SQLException {
        boolean rowDeleted;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_NEWS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateNews(News news) throws SQLException {
        boolean rowUpdated;
        System.out.println(news);
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_NEWS_SQL);) {
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setInt(3, news.getId());

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
