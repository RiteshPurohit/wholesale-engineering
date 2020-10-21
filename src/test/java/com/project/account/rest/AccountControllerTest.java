package com.project.account.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.project.account.entity.AccountDetails;
import com.project.account.entity.AccountTransactions;
import com.project.account.service.AccountService;
import com.project.account.util.AccountUtil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

  @Mock
  private AccountService accountService;

  @InjectMocks
  private AccountController unit;

  @Test
  public void getAllAccountsDetails_shouldReturnListOfAccountDetails_whenDataIsAvaliable() {
    //given
    AccountDetails accountDetails = AccountUtil.getAccountDetails();
    List<AccountDetails> accountDetailsList = new LinkedList<>();
    accountDetailsList.add(accountDetails);
    //when
    when(accountService.getAllAccountDetails()).thenReturn(accountDetailsList);
    ResponseEntity<List<AccountDetails>> responseEntity = unit.getAllAccountsDetails();
    //then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    AccountUtil.verifyAccountResponse(accountDetailsList.get(0), responseEntity.getBody().get(0));
  }

  @Test
  public void getAllAccountsDetails_shouldReturnEmptyList_whenNoDataIsAvaliable() {
    //when
    when(accountService.getAllAccountDetails()).thenReturn(Collections.EMPTY_LIST);
    ResponseEntity<List<AccountDetails>> responseEntity = unit.getAllAccountsDetails();
    //then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody().isEmpty()).isEqualTo(true);
  }

  @Test
  public void getAllTransactionsByAccount_shouldReturnListOfTransactionss_whenAccountNumberIsValid() {
    //given
    AccountTransactions accountTransactions = AccountUtil.getAccountTransactions();
    List<AccountTransactions> accountTransactionsList = new LinkedList<>();
    accountTransactionsList.add(accountTransactions);
    //when
    when(accountService.getAllAccountTransactionsByAccount(AccountUtil.ACCOUNT_NUMBER))
        .thenReturn(accountTransactionsList);
    ResponseEntity<List<AccountTransactions>> responseEntity = unit
        .getAllTransactionsByAccount(AccountUtil.ACCOUNT_NUMBER);
    //then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    AccountUtil.verifyTransactionResponse(accountTransactionsList.get(0), responseEntity.getBody().get(0));
  }

}
