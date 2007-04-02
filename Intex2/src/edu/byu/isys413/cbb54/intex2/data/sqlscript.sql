--
-- Clear database
--

DROP TABLE "customer";
DROP TABLE "membership";
DROP TABLE "interest";
DROP TABLE "backupservice";
DROP TABLE "memberinterests";
DROP TABLE "transaction";
DROP TABLE "payment";
DROP TABLE "employee";
DROP TABLE "store";
DROP TABLE "transactionline";
DROP TABLE "coupon";
DROP TABLE "revenuesource";
DROP TABLE "backup";
DROP TABLE "serviceRepair";
DROP TABLE "printorder";
DROP TABLE "sale";



create table "customer"
(
    "id" VARCHAR(40) not null primary key,
    "fname" VARCHAR(40),
    "lname" VARCHAR(40),
    "address1" VARCHAR(80),
    "address2" VARCHAR(80),
    "city" VARCHAR(40),
    "state" VARCHAR(40),
    "zip" VARCHAR(10),
    "phone" VARCHAR(15),
    "email" VARCHAR(40)
);

create table "membership"
(
    "id" VARCHAR(40) not null primary key,
    "custID" VARCHAR(40),
    "startDate" VARCHAR(30),
    "endDate" VARCHAR(30),
    "creditCard" VARCHAR(16),
    "ccExpiration" VARCHAR(10),
    "newsletter" SMALLINT,
    "backupSize" VARCHAR(15),
    "backupExpDate" VARCHAR(40)
);

create table "backupservice"
(
    "price" VARCHAR(20) not null primary key
);

create table "interest"
(
    "id" VARCHAR(40) not null primary key,
    "title" VARCHAR(128),
    "description" VARCHAR(256)
);

create table "memberinterests"
(
    "memberID" VARCHAR(40),
    "interestID" VARCHAR(40)
);

create table "transaction"
(
    "id" varchar(40) not null primary key,
    "type" varchar(80),
    "status" varchar(10),
    "custid" varchar(80),
    "empid" varchar(80),
    "storeid" varchar(80),
    "origtx" varchar(40)
);
 
create table "payment"
(
    "id" varchar(40) not null primary key,
    "amount" double,
    "ccnumber" varchar(20),
    "ccexpiration" varchar(10),
    "transactionid" varchar(80),
    "change" double,
    "type" varchar(80)
);
 
create table "employee"
(
    "id" varchar(40) not null primary key,
    "fname" varchar (80),
    "lname" varchar(80),
    "address1" varchar(80),
    "address2" varchar(80),
    "city" varchar(80),
    "state" varchar(80),
    "zip" varchar(80),
    "phone" varchar(15),
    "email" varchar(80),
    "ssnumber" varchar(15),
    "hiredate" varchar(80),
    "salary" double,
    "storeid" varchar(40)
);
 
create table "store"
(
    "id" varchar(40) not null primary key,
    "name" varchar(80),
    "address1" varchar(80),
    "address2" varchar(80),
    "city" varchar(80),
    "state" varchar(80),
    "zip" varchar(80),
    "phone" varchar(15),
    "fax" varchar(15),
    "managerid" varchar(40)
);
 
create table "transactionline"
(
    "id" varchar(40) not null primary key,
    "revenuesourceid" varchar(40),
    "transactionid" varchar(40),
    "rstype" varchar(40)
);
 
create table "coupon"
(
    "id" varchar(40) not null primary key,
    "amount" double
);

create table "revenuesource"
(
    "id" varchar(40) not null primary key,
    "type" varchar(80)
);

create table "backup"
(
    "id" varchar(40) not null primary key,
    "size" double,
    "lengthofbackup" double,
    "price" double
);

create table "serviceRepair"
(
    "id" varchar(40) not null primary key,
    "dateStarted" varchar(30),
    "dateEnded" varchar(30),
    "description" varchar(150),
    "laborHours" varchar(25),
    "employeeID" varchar(30),
    "datePickedUp" varchar(30),
    "price" varchar(30)
);

create table "printorder"
(
    "id" varchar(30) not null primary key,
    "quantity" int,
    "photoSet" varchar(30),
    "price" double
);

create table "printformat"
(
    "id" varchar(30) not null primary key,
    "size" varchar(30),
    "papertype" varchar(30),
    "sourcetype" varchar(30),
    "price" double
);

create table "photoset"
(
    "id" varchar(30) not null primary key,
    "description" varchar(100),
    "numPhotos" int
);

create table "sale"
(
    "id" varchar(40) not null primary key,
    "quantity" int
);

