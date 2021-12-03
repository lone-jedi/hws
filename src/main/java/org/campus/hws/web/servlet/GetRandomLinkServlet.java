package org.campus.hws.web.servlet;

import org.campus.hws.service.SolutionService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetRandomLinkServlet extends HttpServlet {
    private SolutionService solutionService;

    public GetRandomLinkServlet(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String task = req.getParameter("task_name");
            String randomLink = solutionService.getRandomLink(task);
            resp.sendRedirect(randomLink);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("<h1>Please select an existing task!</h1>");
        }
    }
}
