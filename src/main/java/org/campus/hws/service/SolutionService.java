package org.campus.hws.service;

import lombok.extern.slf4j.Slf4j;
import org.campus.hws.dao.SolutionDao;
import org.campus.hws.entity.Solution;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
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

    public List<Solution> findByTaskName(String taskName) {
        List<Solution> solutions = solutionDao.findByTaskName(taskName);
        log.info("Obtain solutions by task '{}': {}", taskName, solutions.size());
        return solutions;
    }
}
