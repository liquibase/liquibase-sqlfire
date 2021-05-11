# Liquibase SqlFire Plugin [![Build and Test Extension](https://github.com/liquibase/liquibase-sqlfire/actions/workflows/build.yml/badge.svg)](https://github.com/liquibase/liquibase-sqlfire/actions/workflows/build.yml)
This adds support for the Pivotal's SqlFire database to Liquibase

SqlFire is an in-memory distributed SQL database. In the category of NewSQL databases, SQLFire delivers dynamic scalability and high performance for data-intensive modern applications. 

SqlFire provides it's sql interface by using a port of Apache Derby.


### How to Use

Add the compiled jar to the Liquibase distribution's "lib" folder.

SqlFire reports its Database Product Name as "Apache Derby". The Priority for SqlFireDatabase has been set to **PRIORITY_DATABASE** and should be picked up before the DerbyDatabse implementation.


### Supported Refactoring/Changes
With SqlFire there are two layers where a Liquibase refactor may not be supported. As SqlFire uses Apache Derby as it's sql interface a method may not supported at the Apache Derby. It is also possible that the underlying SqlFire Database may not support certain features.  

Generally the SqlFire features is a subset of those support by Apache Derby.  

N=Not supported
Y=Supported
?=Untried

Liquibase Refactoring|Derby|SqlFire|Description
:--------------------|:---:|:-----:|:----------
ADD AUTO INCREMENT			|N|N|Not supported by Derby
ADD COLUMN					|Y|Y| 
ADD DEFAULT VALUE			|Y|N|Column Modification not supported by SqlFire 
ADD FOREIGN KEY CONSTRAINT	|Y|?| 
ADD LOOKUP TABLE			|Y|Y| 
ADD NOT NULL CONSTRAINT		|Y|N|Column Modification not supported by SqlFire
ADD PRIMARY KEY				|Y|Y| 
ADD UNIQUE CONSTRAINT		|Y|Y| 
ALTER SEQUENCE				|N|N|Sequence not supported by Derby 
CREATE INDEX				|N|N|Sequence not supported by Derby 
CREATE PROCEDURE			|Y|Y| 
CREATE SEQUENCE				|N|N|Sequence not supported by Derby 
CREATE TABLE				|Y|Y| 
CREATE VIEW					|Y|Y| 
CUSTOM CHANGE				|Y|Y| 
DELETE						|Y|Y| 
DROP ALL FOREIGN KEY CONSTRAINTS	|Y|?| 
DROP COLUMN					|Y|Y| 
DROP DEFAULT VALUE			|Y|N|Column Modification not supported by SqlFire 
DROP FOREIGN KEY CONSTRAINT			|Y|?| 
DROP INDEX					|Y|Y| 
DROP NOT NULL CONSTRAINT	|Y|N|Column Modification not supported by SqlFire 
DROP PRIMARY KEY			|Y|Y| 
DROP SEQUENCE				|Y|Y| 
DROP TABLE					|Y|Y| 
DROP UNIQUE CONSTRAINT		|Y|Y| 
DROP VIEW					|Y|Y| 
EMPTY						|Y|Y| 
EXECUTE COMMAND				|Y|?| 
INSERT						|Y|Y| 
LOAD DATA					|Y|?| 
LOAD UPDATE DATA			|Y|?| 
MERGE COLUMNS				|Y|N|Column Modification not supported by SqlFire
MODIFY DATA TYPE			|Y|N|Column Modification not supported by SqlFire
RENAME COLUMN				|Y|N|RENAME statement not yet implemented by SqlFire.
RENAME TABLE				|Y|N|RENAME statement not yet implemented by SqlFire. 
RENAME VIEW					|N|N|RENAME statement not yet implemented by SqlFire.
SQL							|Y|?| 
SQL FILE					|Y|?| 
STOP						|Y|Y| 
TAG DATABASE				|Y|Y| 
UPDATE						|Y|Y| 






