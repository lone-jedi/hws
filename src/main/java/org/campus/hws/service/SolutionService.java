package org.campus.hws.service;

import org.campus.hws.dao.SolutionDao;
import org.campus.hws.entity.Solution;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class SolutionService {
    private SolutionDao solutionDao;

    public SolutionService(SolutionDao solutionDao) {
        this.solutionDao = solutionDao;
    }

    public List<Solution> findAll() {
        List<Solution> solutions = solutionDao.findAll();
        System.out.println("Obtain solutions: " + solutions.size());
        return solutions;
    }

    public void add(Solution solution) {
        LocalDateTime now = LocalDateTime.now();
        solution.setPublishDate(now);
        solutionDao.add(solution);
        System.out.println("Solution added");
    }

    public List<Solution> findByTask(String taskName) {
        List<Solution> solutions = solutionDao.findByTask(taskName);
        System.out.println(String.format("Obtain solutions by task '%s': %d",
                taskName, solutions.size()));
        return solutions;
    }
}
