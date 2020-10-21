CREATE TABLE ACCOUNT_DETAILS (
  account_number varchar(50) PRIMARY KEY,
  account_name varchar(100) not null,
  account_type varchar(10) not null,
  balance_date timestamp not null,
  currency varchar(3) not null,
  opening_available_balance float not null
);

CREATE TABLE ACCOUNT_TRANSACTIONS_DETAILS (
  transaction_id varchar(50) PRIMARY KEY,
  account_number varchar(50) not null,
  account_name varchar(100) not null,
  value_date varchar(30) not null,
  currency varchar(3) not null,
  debit_amount float,
  credit_amount float,
  transaction_type varchar(6) not null,
  transaction_narrative varchar(20)
);