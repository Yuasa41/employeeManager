/*
既存テーブル削除
*/
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS slaves CASCADE;

 
/*
ここからテーブル作成
*/
CREATE TABLE users(
 id int not null,
 password varchar(100) not null,
 authlevel int not null,
 primary key(id));

CREATE TABLE slaves(
slavenum int not null,
slavename varchar(100) not null,
slavedept int not null,
primary key(slavenum));

/*
ここからデータ初期化
*/
INSERT INTO users VALUES (2355501,'password',0),(2355502,'paseri',0),(2355503,'pasta',0),(2355504,'kanrisya',1);


INSERT INTO slaves VALUES (2355501,'湯浅温尊',10),(2355502,'鈴木優斗',20),(2355503,'川住亮',30),(2355504,'森岡龍輝',40);