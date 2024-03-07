create or replace procedure insert_data(
transactionid number,
transactiondate date,
transactionto varchar2,
transactionamount number,
transactionremark varchar2,
transaction_info out varchar2
)
as
begin
insert into transaction_2 VALUES(transactionid,transactiondate,transactionto,transactionamount,transactionremark);
transaction_info :='Transaction inserted';
end;

----triggers----
Create or replace trigger check_remarks
before insert on transaction_2
for each row
begin
if:new.transaction_remarks is null then :new.transaction_remarks:='no';
end if;
end;