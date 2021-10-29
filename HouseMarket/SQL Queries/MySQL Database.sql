use rk_HouseMarket;


###############User table#################
create table HouseMarketUser(name varchar(100), mobile varchar(10), email varchar(100) primary key, password blob);

insert into HouseMarketUser(name,mobile,email,password) values('Rohit Ramtirthe','9146725145','rohit.myrg@gmail.com',AES_ENCRYPT('Rohit@1998','rgrd98'));

SELECT name,aes_decrypt(password,'rgrd98') as password 
FROM rk_housemarket.housemarketuser 
where email='rohit.myrg@gmail.com';

SELECT name,email,AES_DECRYPT(password,'rgrd98') 
FROM housemarketuser 
where email='rohit.myrg@gmail.com';


############################################

create table property_details(pdid MEDIUMINT primary key NOT NULL auto_increment,
							apartment_type varchar(255),
							BHK_type varchar(255),
							floor INT,
							total_floor INT,
							property_age varchar(255),
							facing varchar(255),
							property_size varchar(255));
							
alter table property_details add fk_user_emailid varchar(100);
alter table property_details add constraint fk_user_emailid  FOREIGN KEY (fk_user_emailid) REFERENCES housemarketuser(email);
update property_details set fk_user_emailid = 'rohit.myrg@gmail.com' where pdid=1;							
							
insert into property_details values(NULL,'Apartment','1BHK',2,3,'1-3','East','500 sq. ft.','rohit.myrg@gmail.com');

select * from property_details;

	//get the latest auto increment id:
SELECT last_insert_id() FROM rk_housemarket.property_details;

*********************************************************************
							
create table locality_details(state varchar(255),
							  district varchar(255),
							  locality TEXT,
							  area varchar(255),
							  ld_pdid MEDIUMINT NOT NULL,
							  FOREIGN KEY (ld_pdid) REFERENCES property_details(pdid));
							  
insert into locality_details values('Maharashtra','Pune','Bishnoi mandir, Thite wasti, Kharadi','Nagar Road',1);

SELECT * FROM locality_details;							 

**********************************************************************
				
create table rental_details(look_for varchar(255),
							rent INT,
							deposit INT,
							monthly_maintainance varchar(255),
							prefered_tenants varchar(255),
							furnishing varchar(255),
							parking varchar(255),
							available_from date,
							description TEXT,
							rd_pdid MEDIUMINT NOT NULL,
							FOREIGN KEY (rd_pdid) REFERENCES property_details(pdid));
							
insert into rental_details values('Only rent',3000,5000,'Maintainance-inlcuded','Bachelore','Semi-furnished','Bike','2021-10-23','Argent require',1);

SELECT * FROM rental_details;

********************************************************************							
							
create table additional_details(bathroom INT,
								Balcony INT,
								water_supply varchar(255),
								gym varchar(255),
								non_veg varchar(255),
								gated_security varchar(255),
								other_facility TEXT,
								ad_pdid MEDIUMINT NOT NULL,
								FOREIGN KEY (ad_pdid) REFERENCES property_details(pdid));
								
insert into additional_details values(2,1,'Corporation','No','No','Yes','lift, Hot Water',1);

SELECT * FROM additional_details;

*********************************************************************
											  
create table gallery(photo BLOB,
					g_pdid MEDIUMINT NOT NULL,
					FOREIGN KEY (g_pdid) REFERENCES property_details(pdid));
					
***********************************************************************
							  
create table schedule(starttime TIME,
					  endtime TIME,
					  weekday varchar(255),
					  s_pdid MEDIUMINT NOT NULL,
					  FOREIGN KEY (s_pdid) REFERENCES property_details(pdid));
					  
insert into schedule values('14:44','20:44','Weekend',1);
							  
SELECT * FROM schedule;							  
							  
							  
							  
							  
							  