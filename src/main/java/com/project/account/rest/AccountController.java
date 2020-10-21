package com.project.account.rest;

import com.project.account.entity.AccountDetails;
import com.project.account.entity.AccountTransactions;
import com.project.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @ApiOperation(value = "Get All Account Details")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
  })
  @GetMapping("/getAllAccountsDetails")
  public ResponseEntity<List<AccountDetails>> getAllAccountsDetails() {
    return ResponseEntity.ok(accountService.getAllAccountDetails());
  }

  @ApiOperation(value = "Get All Transactions By Account Number")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 404, message = "Invalid Account Number")
  })
  @GetMapping("/getAllTransactionsByAccount/{accountNumber}")
  public ResponseEntity<List<AccountTransactions>> getAllTransactionsByAccount(
      @PathVariable("accountNumber") String accountNumber) {
    return ResponseEntity.ok(accountService.getAllAccountTransactionsByAccount(accountNumber));
  }
}
