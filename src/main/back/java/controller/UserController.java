package controller;

import service.impl.AccountImpl;
import service.impl.UserImpl;
import model.Account;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Класс-контроллер, обрабатывающий запросы относительно класса User.
 * @autor Сергей Зверев
 * @version 1.1
 */

@WebServlet("/UserServlet")
public class UserController extends HttpServlet {

    /**Метод, обрабатывающий Get-запросы, относительно класса User.*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserImpl userDao = new UserImpl();
        AccountImpl accountDao = new AccountImpl();
        String str = request.getParameter("nameStrParam");
        String str2 = request.getParameter("idUser");
        if (str.equals("richest-user")) {
            List<Account> accounts = accountDao.findAll();
            accounts.sort((o1, o2) -> o1.getAccountNumber() - o2.getAccountNumber());
            Account richest = accounts.get(accounts.size() - 1);
            User user = userDao.findById(richest.getUserId());
            PrintWriter out = response.getWriter();
            out.println(user.getName());
            out.println(user.getSurname());
            out.println(user.getId());
        } else if (str2 !=null) {
            UserImpl userd = new UserImpl();
            List<User> usersForOne = userd.findAll();
            int idUs = Integer.valueOf(str2);
            User userbyid = usersForOne.stream().filter(x -> x.getId() == idUs).findFirst().get();
            PrintWriter out = response.getWriter();
            out.println(userbyid.getId());
            out.println(userbyid.getName());
            out.println(userbyid.getSurname());
        } else {
            List<User> users = userDao.findAll();
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/WEB-INF/indexServlet.jsp").forward(request, response);
        }
    }

    /**
     * TODO: Реализовать обработку POST-запросов относительно класса User.
     * На данный момент этот метод представляет собой заглушку.
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //doGet(request, response);
    }

}
