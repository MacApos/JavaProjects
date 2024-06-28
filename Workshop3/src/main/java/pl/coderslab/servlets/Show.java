package pl.coderslab.servlets;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/user/show")
public class Show extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User showUser = userDao.read(id);
        request.setAttribute("showUser", showUser);
        getServletContext().getRequestDispatcher("/user/show.jsp").forward(request, response);
    }
}