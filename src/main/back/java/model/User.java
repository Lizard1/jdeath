package model;

import java.util.Objects;

/**
 * Класс-модель представляющий самого пользователя
 * @autor Сергей Зверев
 * @version 1.1
 */
public class User {
    /**Поля такие как: Id - пользователя, имя, фамилия*/
    private int id;
    private String name;
    private String surname;

    /**Геттеры и сеттеры.*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**Конструктор по умолчанию.*/
    public User() {
    }

    /**Конструктор со всеми параметрами.*/
    public User(int id, String name, String sername) {
        this.id = id;
        this.name = name;
        this.surname = sername;
    }

    /**Переопределение метода equals().*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                surname.equals(user.surname);
    }

    /**Переопределение метода hashCode().*/
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

}
