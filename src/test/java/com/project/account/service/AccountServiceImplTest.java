package com.project.account.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

import com.project.account.entity.AccountDetails;
import com.project.account.entity.AccountTransactions;
import com.project.account.exception.ResourceNotFoundException;
import com.project.account.repository.AccountRepository;
import com.project.account.repository.AccountTransactionsRepository;
import com.project.account.util.AccountUtil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

  private final String RANDOM_ACCOUNT_NUMBER = "1234";

  @Mock
  private AccountRepository accountRepository;

  @Mock
  private AccountTransactionsRepository accountTransactionsRepository;

  @InjectMocks
  private AccountServiceImpl unit;

  @Test
  public void getAllAccountDetails_shouldReturnListOfAccounts_whenDataIsAvaliable(){
    //given
    AccountDetails accountDetails = AccountUtil.getAccountDetails();
    List<AccountDetails> accountDetailsList = new LinkedList<>();
    accountDetailsList.add(accountDetails);
    //when
    when(accountRepository.findAll()).thenReturn(accountDetailsList);
    List<AccountDetails> actual = unit.getAllAccountDetails();
    //then
    AccountUtil.verifyAccountResponse(accountDetailsList.get(0), actual.get(0));
  }

  @Test
  public void getAllAccountDetails_shouldReturnEmptyList_whenNoDataIsAvaliable(){
    //when
    when(accountRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
    List<AccountDetails> actual = unit.getAllAccountDetails();
    //then
    assertThat(actual.isEmpty()).isEqualTo(true);
  }

  @Test
  public void getAllTransactionsByAccount_shouldReturnListOfTransactions_whenAccountNumberIsValid(){
    //given
    AccountDetails accountDetails = AccountUtil.getAccountDetails();
    List<AccountDetails> accountDetailsList = new LinkedList<>();
    accountDetailsList.add(accountDetails);
    //when
    when(accountRepository.findAll()).thenReturn(accountDetailsList);
    List<AccountDetails> actual = unit.getAllAccountDetails();
    //then
    AccountUtil.verifyAccountResponse(accountDetailsList.get(0), actual.get(0));
  }

  @Test
  public void getAllTransactionsByAccount_shouldThrowException_whenAccountNumberIsInvalid(){
    //when
    when(accountRepository.findById(RANDOM_ACCOUNT_NUMBER))
        .thenThrow(new ResourceNotFoundException("Invalid Account Number " +RANDOM_ACCOUNT_NUMBER));

    Throwable throwable = catchThrowable(() -> unit.getAllAccountTransactionsByAccount(RANDOM_ACCOUNT_NUMBER));
    //then
    assertThat(throwable).isInstanceOf(ResourceNotFoundException.class);
    assertThat(throwable.getMessage()).isEqualTo("Invalid Account Number " +RANDOM_ACCOUNT_NUMBER);
  }

  @Test
  public void getAllTransactionsByAccount_shouldReturnEmptyList_whenAccountNumberIsValid_butNoTransactionsArePresent(){
    //when
    when(accountRepository.findById(AccountUtil.ACCOUNT_NUMBER))
        .thenReturn(Optional.of(AccountUtil.getAccountDetails()));
    when(accountTransactionsRepository.findAllByAccountNumber(AccountUtil.ACCOUNT_NUMBER))
        .thenReturn(Collections.EMPTY_LIST);
    //then
    List<AccountTransactions> accountTransactions = unit
        .getAllAccountTransactionsByAccount(AccountUtil.ACCOUNT_NUMBER);
    assertThat(accountTransactions.isEmpty()).isEqualTo(true);
  }

}
