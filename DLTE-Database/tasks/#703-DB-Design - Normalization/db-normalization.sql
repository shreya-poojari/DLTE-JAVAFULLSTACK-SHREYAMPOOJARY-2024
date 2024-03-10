create table MyBank(username varchar(255) not null, upi varchar(255) not null, mobile_number number(10) not null, email varchar(255) not null,wallet_type varchar(255) not null, recharge_date date not null,recharged_provider varchar(255) not null,recharged_to varchar(255) not null,recharged_amount number(10) not null);

create table details_of_user(username varchar(255) not null,upi varchar(255) not null,mobile_number number(10) prim
ary key not null,email varchar(255) not null);

create table wallet_details(wallet_id number(10) primary key not null,wallet_type varchar(255) not null);

create table user_wallet(mobile_number number(10), wallet_id number(10), primary key(mobile_number, wallet_id));

alter table user_wallet add foreign key(mobile_number) references details_of_user(mobile_number);
alter table user_wallet add foreign key(wallet_id) references wallet_details(wallet_id);

create table details_of_recharge(recharge_id number(10) primary key not null,recharged_date date not null,recharged
_provider varchar(255) not null, recharged_to varchar(255) not null, recharged_amount number(10) not null, mobile_number
 number(10) not null);

alter table details_of_recharge add foreign key(mobile_number) references details_of_user(mobile_number);