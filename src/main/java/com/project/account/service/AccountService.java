package com.project.account.service;

import com.project.account.entity.AccountDetails;
import com.project.account.entity.AccountTransactions;
import java.util.List;

public interface AccountService {

  public List<AccountDetails> getAllAccountDetails();

  public List<AccountTransactions> getAllAccountTransactionsByAccount(String accountNumber);
}
