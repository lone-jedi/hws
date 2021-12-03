package org.campus.hws.web.servlet;


import org.campus.hws.service.SolutionService;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RemoveSolutionServlet extends HttpServlet {
    private SolutionService solutionService;

    public RemoveSolutionServlet(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        solutionService.removeSolution(id);
        resp.sendRedirect("reviews_list.html");
    }
}
