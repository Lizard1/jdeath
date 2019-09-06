package model;

import java.util.Objects;

/**
 * Класс-модель представляющий аккаунт пользователя
 * @autor Сергей Зверев
 * @version 1.1
 */
public class Account {
    /**Поля такие как: Id - аккаунта, сумма на счете, Id - пользователя*/
    private int id;
    private int accountNumber;
    private int userId;

    /**Геттеры и сеттеры.*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**Конструктор по умолчанию.*/
    public Account() {
    }

    /**Конструктор со всеми параметрами.*/
    public Account(int id, int accountNumber, int userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.userId = userId;
    }

    /**Переопределение метода equals().*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                accountNumber == account.accountNumber &&
                userId == account.userId;
    }

    /**Переопределение метода hashCode().*/
    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, userId);
    }
}
