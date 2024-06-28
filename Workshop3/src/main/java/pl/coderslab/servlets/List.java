package pl.coderslab.servlets;

import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(value = "/user/list")
public class List extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        request.setAttribute("users", userDao.findAll());
        getServletContext().getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

}