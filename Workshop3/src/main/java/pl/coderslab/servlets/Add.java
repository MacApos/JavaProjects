package pl.coderslab.servlets;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/user/add")
public class Add extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User addUser = new User(email, userName, password);
        userDao.create(addUser);

        response.sendRedirect("/user/list");


    }
}