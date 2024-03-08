create or replace procedure insert_data(
transactionid number,
transactiondate date,
transactionto varchar2,
transactionamount number,
transactionremarks varchar2,
transaction_info out varchar2
)
as 
begin
insert into transaction_2 values(transactionid,transactiondate,transactionto,transactionamount,transactionremarks);
transaction_info :='transaction inserted';
end;

------Triggers---------
create or replace trigger check_remarks
before insert on transaction_2
for each row
begin
if:new.transactionremarks is null then :new.transactionremarks :='no';
end if;
end;