package com.project.account.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.project.account.entity.AccountDetails;
import com.project.account.entity.AccountTransactions;
import java.time.ZonedDateTime;

public class AccountUtil {

  public static String ACCOUNT_NUMBER = "125431";

  public static AccountDetails getAccountDetails() {
    return AccountDetails.builder()
        .accountNumber(ACCOUNT_NUMBER)
        .accountName("name123")
        .balanceDate(ZonedDateTime.now())
        .currency("cur")
        .accountType("Savings")
        .openingAvailableBalance(123.2)
        .build();
  }

  public static void verifyAccountResponse(AccountDetails actual,
      AccountDetails expected) {
    assertThat(actual.getAccountNumber()).isEqualTo(expected.getAccountNumber());
    assertThat(actual.getAccountName()).isEqualTo(expected.getAccountName());
    assertThat(actual.getBalanceDate()).isEqualTo(expected.getBalanceDate());
    assertThat(actual.getCurrency()).isEqualTo(expected.getCurrency());
    assertThat(actual.getAccountType()).isEqualTo(expected.getAccountType());
    assertThat(actual.getOpeningAvailableBalance()).isEqualTo(expected.getOpeningAvailableBalance());
  }

  public static void verifyTransactionResponse(AccountTransactions actual,
      AccountTransactions expected) {
    assertThat(actual.getTransactionId()).isEqualTo(expected.getTransactionId());
    assertThat(actual.getCreditAmount()).isEqualTo(expected.getCreditAmount());
    assertThat(actual.getTransactionType()).isEqualTo(expected.getTransactionType());
    assertThat(actual.getAccountNumber()).isEqualTo(expected.getAccountNumber());
    assertThat(actual.getAccountName()).isEqualTo(expected.getAccountName());
    assertThat(actual.getCurrency()).isEqualTo(expected.getCurrency());
  }

  public static AccountTransactions getAccountTransactions() {
    return AccountTransactions.builder()
        .accountNumber(AccountUtil.ACCOUNT_NUMBER)
        .accountName("name123")
        .currency("cur")
        .creditAmount(100.21)
        .transactionId("123")
        .transactionType("Credit")
        .valueDate("Jan 12, 2012")
        .build();
  }
}
