import service.impl.AccountImpl;
import service.impl.UserImpl;
import model.Account;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс обеспечивабщий тестируемость бизнес-логики.
 * @autor Сергей Зверев
 * @version 1.1
 */

public class Testing {

    List<User> users = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();
    UserImpl userDao;
    AccountImpl accountDao;

    /**Метод, задающий предустановки, которые будут выполнены при начале теста.*/
    @Before
    public void setUp(){
        accountDao = new AccountImpl();
        userDao = new UserImpl();
        users.add(new User(1, "FirstName", "FirstSurname"));
        users.add(new User(2, "SecondName", "SecondSurname"));
        users.add(new User(3, "ThirdName", "ThirdSurname"));
        accounts.add(new Account(1, 2332, 1));
        accounts.add(new Account(2, 1572, 2));
        accounts.add(new Account(3, 8563, 3));
    }

    /**Метод, выполняющий очистку тестовых данных после завершения теста.*/
    @After
    public void tearDown()  {
        users.clear();
        accounts.clear();
        System.out.println("Test has finished.");
    }

    /**Метод проверяющий корректность взятия объекта класса User,
     * по его Id.
     */
    @Test
    public void getUserByIdTest()  {
        User anyUserById = userDao.findAll().stream().findAny().get();
        User foundUser = userDao.findAll().stream().filter(user -> user.getId() == anyUserById.getId()).findFirst().get();
        Assert.assertTrue(anyUserById.getId() == foundUser.getId());
        Assert.assertTrue(foundUser.equals(anyUserById));
    }

    /**Тест, проверяющий корректность взятия объекта класса Account,
     * по его Id
     */
    @Test
    public void getAccountByIdTest()  {
        Account anyAccountById = accountDao.findAll().stream().findAny().get();
        Account foundAccount = accountDao.findAll().stream().filter(account -> account.getId() == anyAccountById.getId()).findFirst().get();
        Assert.assertTrue(anyAccountById.getId() == foundAccount.getId());
        Assert.assertTrue(foundAccount.equals(anyAccountById));
    }

}
