package com.project.account.service;

import com.project.account.entity.AccountDetails;
import com.project.account.entity.AccountTransactions;
import com.project.account.exception.ResourceNotFoundException;
import com.project.account.repository.AccountRepository;
import com.project.account.repository.AccountTransactionsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;
  private final AccountTransactionsRepository accountTransactionsRepository;

  @Override
  public List<AccountDetails> getAllAccountDetails() {
    return accountRepository.findAll();
  }

  @Override
  public List<AccountTransactions> getAllAccountTransactionsByAccount(String accountNumber) {
    accountRepository.findById(accountNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Account Number " + accountNumber));

    return accountTransactionsRepository.findAllByAccountNumber(accountNumber);
  }
}
