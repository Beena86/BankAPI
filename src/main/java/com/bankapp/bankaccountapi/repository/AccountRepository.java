package com.bankapp.bankaccountapi.repository;

import com.bankapp.bankaccountapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
