package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (users.get(findByPassport(passport)) != null && !users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (getAccounts(findByPassport(passport)) != null) {
            for (Account account : getAccounts(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        if (findByRequisite(sourcePassport, sourceRequisite) != null
                && findByRequisite(destinationPassport, destinationRequisite) != null) {
            double sourceBalance = findByRequisite(sourcePassport, sourceRequisite).getBalance();
            double destinationBalance = findByRequisite(destinationPassport, destinationRequisite).getBalance();
            if (sourceBalance >= amount) {
                findByRequisite(sourcePassport, sourceRequisite).setBalance(sourceBalance - amount);
                findByRequisite(destinationPassport, destinationRequisite).setBalance(destinationBalance + amount);
                result = true;
            }
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}