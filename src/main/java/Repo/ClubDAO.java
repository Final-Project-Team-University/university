package Repo;
import domain.Club;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubDAO implements IClub{
    private String jdbcURL = "jdbc:postgresql://localhost:5432/university";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "123";

    private static final String INSERT_CLUBS_SQL = "INSERT INTO clubs" + "  (name, description) VALUES " +
            " (?, ?);";

    private static final String SELECT_CLUB_BY_ID = "select id,name,description from clubs where id =?;";
    private static final String SELECT_ALL_CLUBS = "select * from clubs";
    private static final String DELETE_CLUBS_SQL = "delete from clubs where id = ?;";
    private static final String UPDATE_CLUBS_SQL = "update clubs set name = ?, description= ? where id = ?;";

    public ClubDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
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

    public void insert(Club club) throws SQLException {
        //   System.out.println(INSERT_CLUBS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLUBS_SQL)) {
            preparedStatement.setString(1, club.getName());
            preparedStatement.setString(2, club.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Club selectClub(int id) {
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLUB_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            System.out.println(rs);
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                return new Club(id, name,  description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    public List<Club> selectAllClubs() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List <Club> clubs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLUBS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                clubs.add(new Club(id, name, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return clubs;
    }

    public boolean deleteClub(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLUBS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }




    public boolean update(Club club) throws SQLException {
        boolean rowUpdated;
        System.out.println(club);
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CLUBS_SQL);) {
            statement.setString(1, club.getName());
            statement.setString(2, club.getDescription());
            statement.setInt(3, club.getId());

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


    public Club findClubById(int id) {
        try {
            String sql = "SELECT * FROM clubs WHERE id = ?";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Club(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }



}