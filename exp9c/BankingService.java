package service;

import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepository;

@Service
public class BankingService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account from = accountRepository.findById(fromId);
        Account to = accountRepository.findById(toId);

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in account " + fromId);
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.update(from);
        accountRepository.update(to);

        System.out.println("Transfer successful: " + amount + " from " + from.getName() + " to " + to.getName());
    }
}