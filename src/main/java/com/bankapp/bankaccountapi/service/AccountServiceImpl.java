package com.bankapp.bankaccountapi.service;

import com.bankapp.bankaccountapi.model.Account;
import com.bankapp.bankaccountapi.model.User;
import com.bankapp.bankaccountapi.repository.AccountRepository;
import com.bankapp.bankaccountapi.repository.UserRepository;
import com.bankapp.bankaccountapi.service.Interface.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        Long userId = account.getUser().getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Associate Account with User
        account.setUser(user);
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account accountDetails) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setAccountNumber(accountDetails.getAccountNumber());
            account.setBalance(accountDetails.getBalance());
            return accountRepository.save(account);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
