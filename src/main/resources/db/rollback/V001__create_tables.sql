drop table if exists "tblproductpt";
drop table if exists "tblcompanypt";
drop table if exists "tblboxtypept";
drop table if exists "tblinventorypt";
drop table if exists "tblcustomerpt";

DELETE FROM schema_version WHERE version = '001';