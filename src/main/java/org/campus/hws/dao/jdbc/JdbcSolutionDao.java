package org.campus.hws.dao.jdbc;

import org.campus.hws.dao.SolutionDao;
import org.campus.hws.dao.jdbc.mapper.SolutionRowMapper;
import org.campus.hws.entity.Solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSolutionDao implements SolutionDao {
    private static final SolutionRowMapper SOLUTION_ROW_MAPPER = new SolutionRowMapper();
    private static final String FIND_ALL_SQL = "SELECT id, github_link, author, comments, publish_date, task_name FROM Solution;";

    @Override
    public List<Solution> findAll() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Solution> solutions = new ArrayList<>();
            while (resultSet.next()) {
                Solution solution = SOLUTION_ROW_MAPPER.mapRow(resultSet);
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/hws",
                "user", "pswd");
    }
}
