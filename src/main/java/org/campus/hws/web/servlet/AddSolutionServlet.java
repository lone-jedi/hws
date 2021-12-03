package org.campus.hws.web.servlet;

import org.campus.hws.entity.Solution;
import org.campus.hws.service.SolutionService;
import org.campus.hws.web.util.PageGenerator;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class AddSolutionServlet extends HttpServlet {
    private SolutionService solutionService;

    public AddSolutionServlet(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("add_solution.html", new HashMap<>());
        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Solution solution = getSolutionFromRequest(req);
            solutionService.addSolution(solution);
            resp.sendRedirect("reviews_list.html");
        } catch (Exception e) {
            PageGenerator pageGenerator = PageGenerator.instance();
            String page = pageGenerator.getPage("add_solution.html", new HashMap<>());
            resp.getWriter().write(page);
            resp.getWriter().write("<p></p><p align=\"center\"><strong>Your solution has not been added! Please, enter correct data in the fields</strong></p>");
        }
    }


    private Solution getSolutionFromRequest(HttpServletRequest req) {
        return Solution.builder().
                id(Integer.parseInt(req.getParameter("id")))
                .githubLink(req.getParameter("github_link"))
                .comment(req.getParameter("comment"))
                .taskName(req.getParameter("task_name"))
                .author(req.getParameter("author"))
                .publishDate(LocalDateTime.parse(req.getParameter("publish_date")))
                .build();
    }
}
