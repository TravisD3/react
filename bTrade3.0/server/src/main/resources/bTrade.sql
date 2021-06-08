-- 1. create database btrade;
-- 2. Start bTradeServer (Tables will be created automatically).

-- If Account or another table is not created, ask another student to generate DDL for the table using MySQL Workbench.
-- Then execute the DDL to create the table manually.

use btrade;

-- Create an Admin account with '111111' as password
insert into users (id,email,name,password,username) values (1, 'admin@bht.com', 'Admin Wang', '$2a$10$w8d5k66R0//7fFgOVc7SyuFkkCd0fVJ5GfGVRlm9U8QZOoCeE0Asq', 'admin');
insert into users (id,email,name,password,username) values (2, 'test@bht.com', 'John Smith', '$2a$10$w8d5k66R0//7fFgOVc7SyuFkkCd0fVJ5GfGVRlm9U8QZOoCeE0Asq', 'tester');
insert into account (ACCT_ID, ACCT_NUM,ACCT_TYPE,AVAIL_BALANCE,BALANCE,SUB_TYPE,UID_NO) values (1, 101, 'Equity', 10000, 10000, 'Trading', 1);
insert into account (ACCT_ID, ACCT_NUM,ACCT_TYPE,AVAIL_BALANCE,BALANCE,SUB_TYPE,UID_NO) values (2, 102, 'Equity', 5000, 3000, 'Option', 1);
insert into account (ACCT_ID, ACCT_NUM,ACCT_TYPE,AVAIL_BALANCE,BALANCE,SUB_TYPE,UID_NO) values (3, 103, 'Roth IRA', 15000, 1500, 'IRA', 1);
insert into portfolio (portfolioID, ACCTNUM,DAYSGAIN,LAST, MARKETVALUE, PERCENTGAIN, QUANTITY, SYMBOL, TOTALGAIN) values (1, 101, 5000, 1000.00, 9000.00, 12, 100, 'GOOG', 300);
insert into portfolio (portfolioID, ACCTNUM,DAYSGAIN,LAST, MARKETVALUE, PERCENTGAIN, QUANTITY, SYMBOL, TOTALGAIN) values (2, 102, 6000, 3000.00, 8000.00, 10, 150, 'APPL', 500);
insert into transaction (transaction_id, ACCT_NUM, BUY_SELL, CRET_DTM, PRICE, QUANTITY, STATUS, SYMBOL, TOTAL, TRADE_DATE) values (1, 101, 'B', '2017-11-27', 1071.5, 100, 'O', 'GOOG', 107150, '2017-11-27');
insert into profile (UID_NO,ACTIVE,ADDRESS1,ADDRESS2,CITY,COUNTRY,EMAIL,FIRST_NAME,LAST_NAME,PHONE,STATE,ZIP) VALUES (1, 'Y', '123 Main St.', 'Suite 301', 'Princeton', 'USA', 'a@b.com', 'John', 'Doe', '609-777-8888', 'NJ', '08536');
insert into order_status(status_id, status) VALUES
            (0, 'Open'),
            (1, 'Saved'),
            (2, 'Executed'),
            (3, 'Cancelled'),
            (4, 'Expired'),
            (5, 'Rejected');

insert into acct_type values (1, '401K', '401K Account');
insert into acct_type values (2, 'IRA', 'IRA Account');
insert into acct_type values (3, 'Equity', 'Equity Trading');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PM');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

insert into order_type values (1, 'Good for Day');
insert into order_type values (2, 'Good for 60 Days');
insert into order_type values (3, 'Good Till Cancelled');

insert into user_roles values(1, 3);
insert into user_roles values(2, 1);

select
	transactio0_.TRANSACTION_ID as TRANSACT1_3_,
	transactio0_.ACCT_NUM as ACCT2_3_,
	transactio0_.BUY_SELL as BUY3_3_,
	transactio0_.CRET_DTM as CRET4_3_,
	transactio0_.PRICE as PRICE3_,
	transactio0_.QUANTITY as QUANTITY3_,
	transactio0_.STATUS as STATUS3_,
	transactio0_.SYMBOL as SYMBOL3_,
	transactio0_.TOTAL as TOTAL3_,
	transactio0_.TRADE_DATE as TRADE10_3_
	from transaction transactio0_ where ACCT_NUM=101;

select
    user0_.userId as userId7_,
    user0_.password as password7_,
    user0_.uid_no as uid3_7_,
    user0_.userName as userName7_ 
    from user user0_ 
    where user0_.userName='admin';