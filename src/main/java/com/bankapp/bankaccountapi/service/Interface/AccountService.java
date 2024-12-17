package com.bankapp.bankaccountapi.service.Interface;

import com.bankapp.bankaccountapi.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
   // List<Account> getAccountsByUserId(Long userId);
    Account getAccountById(Long id);
    Account createAccount(Account account);
    Account updateAccount(Long id, Account accountDetails);
    void deleteAccount(Long id);
}
