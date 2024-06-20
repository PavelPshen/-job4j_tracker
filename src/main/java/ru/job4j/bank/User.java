package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка
 * @author Pavel Pshenitsyn
 * @version 1.0
 */
public class User {
    /**
     * Хранение данных паспорта клиента осуществляется в пересенной типа String
     */
    private String passport;

    /**
     * Хранение логина клиента осуществляется в пересенной типа String
     */private String username;

    /**
     * Конструктор
     * @param passport данные паспорта
     * @param username логин
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Гетер.
     * @return Вохвращает данные паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сетер
     * @param passport данные паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Гетер.
     * @return Вохвращает логин клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сетер
     * @param username данные паспорта
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}