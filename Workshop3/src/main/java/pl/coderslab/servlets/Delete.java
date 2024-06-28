package pl.coderslab.servlets;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/user/delete")
public class Delete extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User deleteUser = userDao.read(id);

        request.setAttribute("deleteUser", deleteUser);
        getServletContext().getRequestDispatcher("/user/delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.delete(id);
        response.sendRedirect("/user/list");
    }
}