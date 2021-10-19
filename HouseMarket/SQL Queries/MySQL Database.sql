use rk_HouseMarket;


###############User table#################3
create table HouseMarketUser(name varchar(100), mobile varchar(10), email varchar(100) primary key, password blob);

insert into HouseMarketUser(name,mobile,email,password) values('Rohit Ramtirthe','9146725145','rohit.myrg@gmail.com',AES_ENCRYPT('Rohit@1998','rgrd98'));

SELECT name,aes_decrypt(password,'rgrd98') as password 
FROM rk_housemarket.housemarketuser 
where email='rohit.myrg@gmail.com';

SELECT name,email,AES_DECRYPT(password,'rgrd98') 
FROM housemarketuser 
where email='rohit.myrg@gmail.com';