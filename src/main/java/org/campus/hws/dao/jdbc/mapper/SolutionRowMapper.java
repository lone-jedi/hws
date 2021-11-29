package org.campus.hws.dao.jdbc.mapper;

import org.campus.hws.entity.Solution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SolutionRowMapper {
    public Solution mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String githubLink = resultSet.getString("github_link");
        String author = resultSet.getString("author");
        String comments = resultSet.getString("comments");
        String taskName = resultSet.getString("task_name");
        Timestamp publishDateTimeStamp = resultSet.getTimestamp("publish_date");


        Solution solution = Solution.builder().
                id(id)
                .githubLink(githubLink)
                .comment(comments)
                .taskName(taskName)
                .author(author)
                .publishDate(publishDateTimeStamp.toLocalDateTime())
                .build();

        return solution;
    }
}
