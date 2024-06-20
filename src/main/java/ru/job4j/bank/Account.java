package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет клиента банка
 * @author Pavel Pshenitsyn
 * @version 1.0
 */
public class Account {
    /**
     * Хранение реквизитов счета осуществляется в пересенной типа String
     */
    private String requisite;
    /**
     * Хранение баланса счета осуществляется в пересенной типа double
     */
    private double balance;

    /**
     * Конструкор для создания счета клиента.
     * @param requisite  реквизиты счета
     * @param balance  баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Гетер.
     * @return Возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сетер.
     * @param requisite  реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Гетер.
     * @return Возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сетер.
     * @param balance  баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}