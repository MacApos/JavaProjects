package pl.coderslab.servlets;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/user/edit")
public class Edit extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User editUser = userDao.read(id);

        request.setAttribute("editUser", editUser);
        getServletContext().getRequestDispatcher("/user/edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User editUser = userDao.read(id);

        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        editUser.setEmail(email);
        editUser.setUserName(userName);
        editUser.setPassword(password);

        userDao.update(editUser);
        response.sendRedirect("/user/list");

    }

}