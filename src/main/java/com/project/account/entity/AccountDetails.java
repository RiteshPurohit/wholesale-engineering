package com.project.account.entity;

import java.time.ZonedDateTime;
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
@Table(name = "ACCOUNT_DETAILS")
public class AccountDetails {

  @Id
  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "account_name")
  private String accountName;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "balance_date")
  private ZonedDateTime balanceDate;

  @Column
  private String currency;

  @Column(name = "opening_available_balance")
  private Double openingAvailableBalance;
}
