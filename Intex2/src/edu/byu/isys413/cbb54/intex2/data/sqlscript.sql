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



create table "customer"
(
    "id" VARCHAR(30) not null primary key,
    "fname" VARCHAR(40),
    "lname" VARCHAR(40),
    "address1" VARCHAR(80),
    "address2" VARCHAR(80),
    "city" VARCHAR(40),
    "state" VARCHAR(40),
    "zip" VARCHAR(10),
    "phone" VARCHAR(15)
);

create table "membership"
(
    "id" VARCHAR(30) not null primary key,
    "custID" VARCHAR(30),
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
    "id" VARCHAR(30) not null primary key,
    "title" VARCHAR(128),
    "description" VARCHAR(256)
);

create table "memberinterests"
(
    "memberID" VARCHAR(30),
    "interestID" VARCHAR(30)
);

create table "transaction"
(
    "id" varchar(30) not null primary key,
    "type" varchar(80),
    "status" varchar(10),
    "custid" varchar(80),
    "empid" varchar(80),
    "storeid" varchar(80),
    "origtx" varchar(30)
);
 
create table "payment"
(
    "id" varchar(30) not null primary key,
    "amount" double,
    "ccnumber" varchar(20),
    "ccexpiration" varchar(10),
    "transactionid" varchar(80),
    "change" double,
    "type" varchar(80)
);
 
create table "employee"
(
    "id" varchar(30) not null primary key,
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
    "storeid" varchar(30)
);
 
create table "store"
(
    "id" varchar(30) not null primary key,
    "name" varchar(80),
    "address1" varchar(80),
    "address2" varchar(80),
    "city" varchar(80),
    "state" varchar(80),
    "zip" varchar(80),
    "phone" varchar(15),
    "fax" varchar(15),
    "managerid" varchar(30)
);
 
create table "transactionline"
(
    "id" varchar(30) not null primary key,
    "revenuesourceid" varchar(30),
    "transactionid" varchar(30)
);
 
create table "coupon"
(
    "id" varchar(30) not null primary key,
    "amount" double
);

create table "revenuesource"
(
    "id" varchar(30) not null primary key,
    "type" varchar(80)
);

create table "backup"
(
    "id" varchar(30) not null primary key,
    "size" varchar(20),
    "lengthofbackup" varchar(35),
    "price" varchar(10)
);

create table "serviceRepair"
(
    "id" varchar(30) not null primary key,
    "dateStarted" varchar(30),
    "dateEnded" varchar(30),
    "description" varchar(150),
    "laborHours" varchar(25),
    "employeeID" varchar(30),
    "datePickedUp" varchar(30),
    "price" varchar(30)
);

INSERT INTO "customer" VALUES ('00000109123b9144eb018b64001000', 'Cameron', 'Burgon', '851 Wymount Terrace', '', 'Provo', 'Utah', '84602', '8013786198');
INSERT INTO "customer" VALUES ('00000109123b925d16688bc2001000', 'Jamie', 'Burgon', '851 Wymount Terrace', '', 'Provo', 'Utah', '84604', '8013786189');
INSERT INTO "customer" VALUES ('00000109123b8e75a1ce5a33001000', 'John', 'Doe', '123 Somewhere', '', 'Nowhere', 'Nevada', '87839', '3418394854');
INSERT INTO "customer" VALUES ('00000109123b8e75a1ce5a34001000', 'Jane', 'Doe', '123 Somewhere', '', 'Nowhere', 'Nevada', '87839', '3418394854');

INSERT INTO "interest" VALUES ('0000011105caf55500f1fec0a80204', 'B&W Photography','The art of black and white photography');
INSERT INTO "interest" VALUES ('0000011105caf55f007a64c0a80204','HDR Photography','HDR Photography');

INSERT INTO "backupservice" VALUES ('.85');

INSERT INTO "membership" VALUES('0000011105d7df2e0022fdc0a80204','00000109123b925d16688bc2001000','1-jul-2006','1-jul-2007','1234567890123456','06/07',1, '5', '123123124125123123');
INSERT INTO "membership" VALUES('0000011105d7df38006f3ec0a80204','00000109123b8e75a1ce5a33001000','1-jul-2006','never','9934567890123456','06/07',1, '2.5', '1231231231231241231241');

INSERT INTO "memberinterests" VALUES('00000109123b925d16688bc2001000','0000011105caf55500f1fec0a80204');

INSERT INTO "transactionline" VALUES('00000111728454ec00e60e0a500442','000001117284553c0014ad0a500442','000001117284553c0014af0a500442');

INSERT INTO "transaction" VALUES('000001117284553c0014af0a500442','','complete','00000109123b9144eb018b64001000','000001117284553c0014b10a500442','000001117284553c0014b20a500442','');

INSERT INTO "payment" VALUES('000001117284553c0014b00a500442',14.50,'1234-5678-9012-3456','06/07','000001117284553c0014af0a500442',0.0,'Credit Card');

INSERT INTO "employee" VALUES('000001117284553c0014b10a500442','Ray','Thompson','123 East BYU','','Provo','Utah','84604','801-555-5555','thompson@thompson.com','123-45-6789','12/05',123.45,'000001117284553c0014b20a500442');
INSERT INTO "employee" VALUES('000001117284553c0014b30a500442','Steve','Manager','123 East BYU','','Provo','Utah','84604','801-555-5555','thompson@thompson.com','123-45-6789','12/05',123.45,'000001117284553c0014b20a500442');

INSERT INTO "store" VALUES('000001117284553c0014b20a500442','Provo Center','123 Center Street','Suite 1','Provo','Utah','84604','108-333-3333','801-333-3334','000001117284553c0014b30a500442');

INSERT INTO "coupon" VALUES('000001117284553c0014b40a500442',2.00);

INSERT INTO "revenuesource" VALUES('000001117284553c0014b50a500442','Sale');

INSERT INTO "backup" VALUES('1234', '1', '100', '.89');

INSERT INTO "serviceRepair" VALUES('1234', '123145124314', '124125123123', 'What a mess it was fixing that guys widget -- a nightmare', '10', '2342352342354234', '12412512312312', '151.21'); 