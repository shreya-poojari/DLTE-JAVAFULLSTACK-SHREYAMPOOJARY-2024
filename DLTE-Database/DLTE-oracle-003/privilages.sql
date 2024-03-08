create user divya identified by Divya;
grant select on transaction_2 to divya;
connect divya/Divya;
select * from transaction_2;

create user ramya identified by Ramya;
grant delete on transaction_2 to ramya;
connect ramya/Ramya;
delete from transaction_2 transactionremarks='emergency';

create user Bhavya identified by bavvya;
grant select on transaction_2 to Bhavya;
connect Bhavya/bhavya;
select * from transaction_2;


create user Sushma identified by sushma;
grant insert on transaction_2 to Sushma;
connect Sushma/sushma;
insert into transaction_2 values(6,'25May2024','shrey',1000, 'studies');

create user Kavya identified by kavya;
grant update on transaction_2 to kavya;
connect Kavya/kavya;
update transaction set transaction_to='Ram' where transaction_id=4;