package com.project.account.repository;

import com.project.account.entity.AccountTransactions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, String> {

  @Query(value = "select * from ACCOUNT_TRANSACTIONS_DETAILS where account_number = :account_number", nativeQuery = true)
  public List<AccountTransactions> findAllByAccountNumber(@Param("account_number") String account_number);
}
