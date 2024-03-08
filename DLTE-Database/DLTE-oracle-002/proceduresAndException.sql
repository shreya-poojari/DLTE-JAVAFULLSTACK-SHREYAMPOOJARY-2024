create or replace procedure insert_transaction(
tid number,
tdate date,
tto varchar2,
tamount number,
tremark varchar2,
infos_op out varchar2
)
as
begin
insert into transaction_2(transactionid,transactionamount,transactiondate,transactionto,transactionremarks)
values(tid,tamount,tdate,tto,tremark);
infos_op :='done';
exception
when OTHERS then
infos_op:='not done' || SQLERRM;
end;

variable infos_op varchar2;
execute insert_transaction(TRANSACTION_SEQUENCE.nextval,'5-feb-2024','Divya',199,'food',:infos_op);
print infos_op;

//delete
create or replace procedure delete_transaction(transaction_id number,transaction_info out varchar2)
as 
begin
delete from transaction_2 where transactionid=transaction_id;
transaction_info :='no match';
exception
when no_data_found then
transaction_info :='no match';
when others then
transaction_info :='errror due to' || SQLERRM;
end;

variable infos_err VARCHAR2(255);
execute delete_transaction(1,:infos_err);
print infos_err;


//filter
create or replace procedure filter_transaction(tto out varchar2,infos_err out varchar2)
as
BEGIN
select transactionto into tto from transaction_2 where transactionremarks='education';
infos_err:='filtered';
exception
when no_data_found then
infos_err:='no data found';
when others then
infos_err:='error due to' || SQLERRM;
end;

variable tname varchar;
variable terror varchar2;
execute filter_transaction(:tname,:terror);
print tname;
print terror;
