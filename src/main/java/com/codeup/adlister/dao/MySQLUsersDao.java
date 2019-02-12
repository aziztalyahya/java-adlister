package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLUsersDao implements Users {


    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public Long insert(User user) {
        try {
              PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO users(username, email, password) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? LIMIT 1"
            );
             stmt.setString(1, username);
             return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding by username.", e);
        }
    }

    public User findByEmail(String email) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? LIMIT 1"
            );
            stmt.setString(1, email);

            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding by email.", e);
        }
    }


    public User showUser(ResultSet rs){
        User user = new User();

        try {
            user.setId(rs.getLong(1));
            user.setUsername(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setPassword(rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }


    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
}
