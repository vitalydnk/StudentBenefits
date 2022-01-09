package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.Street;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDao {
    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jc_student",
               "postgres", "pass");
        return con;
    }
    public List<Street> findStreets(String pattern) throws Exception {
        List<Street> result = new LinkedList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT street_code, UPPER(street_name) " +
                "FROM jc_street WHERE UPPER(street_name) like UPPER('%" + pattern + "%')";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Street str = new Street(rs.getLong("street_code"),
                    rs.getString("street_name"));
            result.add(str);
        }
        return result;
    }
}
