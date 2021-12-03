package org.campus.hws.web.servlet;

import org.campus.hws.entity.Solution;
import org.campus.hws.service.SolutionService;
import org.campus.hws.web.util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetRandomLinkServlet extends HttpServlet {
    private SolutionService solutionService;

    public GetRandomLinkServlet(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String task = req.getParameter("task_name");
            String randomLink = solutionService.getRandomLink(task);
            List<Solution> solutions = solutionService.findAll();
            PageGenerator pageGenerator = PageGenerator.instance();
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("solutions", solutions);
            String link = "<p></p><div class=\"container\"><strong> Your random link:<a href=\"" + randomLink + "\">" + randomLink + "></a></strong></div>";
            String page = pageGenerator.getPage("reviews_list.html", parameters);
            resp.getWriter().write(page);
            resp.getWriter().write(link);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("<h1>Please select an existing task!</h1>");
        }
    }
}
