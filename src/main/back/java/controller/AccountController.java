package controller;

import service.impl.AccountImpl;
import model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Класс-контроллер, обрабатывающий запросы относительно класса Account.
 * @autor Сергей Зверев
 * @version 1.1
 */


@WebServlet("/AccountServlet")
public class AccountController extends HttpServlet {

    /**Метод, обрабатывающий Get-запросы, относительно класса Account.*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountImpl accountDao = new AccountImpl();
        String str = request.getParameter("nameStrAcParam");
        String str2 = request.getParameter("idAccount");
        if (str.equals("sum-accounts")) {
            List<Account> accounts = accountDao.findAll();
            int accountSum = accounts.stream().mapToInt(x -> x.getAccountNumber()).sum();
            PrintWriter out = response.getWriter();
            out.println("Accounts sum :" + accountSum);
        } else if (str2 != null) {
            AccountImpl accdao = new AccountImpl();
            List<Account> accountsForOne = accdao.findAll();
            int idAc = Integer.valueOf(str2);
            Account accbyid = accountsForOne.stream().filter(x -> x.getId() == idAc).findFirst().get();
            PrintWriter out = response.getWriter();
            out.println(accbyid.getId());
            out.println(accbyid.getAccountNumber());
            out.println(accbyid.getUserId());
        } else {
            List<Account> accounts = accountDao.findAll();
            request.setAttribute("accounts", accounts);
            getServletContext().getRequestDispatcher("/WEB-INF/indexServletAccount.jsp").forward(request, response);
        }
    }

    /**
     * TODO: Реализовать обработку POST-запросов относительно класса Account.
     * На данный момент этот метод представляет собой заглушку.
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //doGet(request, response);
    }
}
