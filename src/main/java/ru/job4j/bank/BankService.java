package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса по
 * переводу денег
 * @author Pavel Pshenitsyn
 * @version 1.0
 */
public class BankService {
    /**
     * имеем базу клиентво банка в колекции HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Длбавляем нового клиента банка
     * @param user клиент банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляем клиента из базы
     * @param passport данные паспорта
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * открываем счет клиента
     * @param passport данные паспорта
     * @param account счет клиента
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск клиента по данным паспорта
     * @param passport данные паспорта
     * @return возвразаем найденного клиента банка(обхект)
     * либо null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск счета по реквизитам счета у данных паспорта
     * @param passport данные паспорта
     * @param requisite реквизиты счета
     * @return возвразаем найденный счет клиента банка
     * либо null если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
                for (Account account : accounts) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
        }
        return null;
    }

    /**
     * Метод осуществляет транзакцию между счетами клиентов банка либо между счетами
     * одного клиента
     * @param sourcePassport данные паспорта отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport данные паспорта получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return возвращет переменную типа boolean об удачном или неудачной транзакции
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account accountDestination = findByRequisite(destinationPassport, destinationRequisite);
        if (accountSource != null && accountDestination != null) {
            double sourceBalance = accountSource.getBalance();
            double destinationBalance = accountDestination.getBalance();
            if (sourceBalance >= amount) {
                accountSource.setBalance(sourceBalance - amount);
                accountDestination.setBalance(destinationBalance + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод позволяет получить список счетов клиента
     * @param user Клиент банка
     * @return возвразаем список счетов клиента
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}