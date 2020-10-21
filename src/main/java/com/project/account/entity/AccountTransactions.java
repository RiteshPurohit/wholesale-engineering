package com.project.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT_TRANSACTIONS_DETAILS")
public class AccountTransactions {

  @Id
  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "account_name")
  private String accountName;

  @Column(name = "value_date")
  private String valueDate;

  @Column
  private String currency;

  @Column(name = "debit_amount")
  private Double debitAmount;

  @Column(name = "credit_amount")
  private Double creditAmount;

  @Column(name = "transaction_type")
  private String transactionType;

  @Column(name = "transaction_narrative")
  private String transactionNarrative;
}
