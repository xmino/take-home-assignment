drop table if exists "tblproductpt";
drop table if exists "tblcompanypt";
drop table if exists "tblboxtypept";
drop table if exists "tblinventorypt";
drop table if exists "tblcustomerpt";

CREATE TABLE tblproductpt  (
    id  INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
    name  VARCHAR  (80),
    fresh_cut_value  DECIMAL  (5,2)  NOT  NULL  DEFAULT  0
);

CREATE  TABLE  tblcompanypt  (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name  VARCHAR(80)
) ;

CREATE  TABLE  tblboxtypept  (
    id  INTEGER NOT  NULL PRIMARY KEY AUTOINCREMENT,
    code  VARCHAR  (80),
    width  DECIMAL  (10,5)  NOT  NULL  DEFAULT  0,
    height  DECIMAL  (10,5)  NOT  NULL  DEFAULT  0,
    length  DECIMAL  (10,5)  NOT  NULL  DEFAULT  0
);

CREATE  TABLE  tblinventorypt  (
    id  INTEGER  NOT  NULL PRIMARY KEY AUTOINCREMENT,
    box_type_id  INTEGER  NOT  NULL,
    product_id  INTEGER NOT  NULL,
    company_id  INTEGER NOT  NULL,
    cubes_per_carrier  DECIMAL  (19,5)  NOT  NULL  DEFAULT  0,
    pack  INTEGER NOT  NULL,
    base_price  DECIMAL(10,5)  NOT  NULL  DEFAULT  0,
    CONSTRAINT  FK_INVENTORY_PRODUCT  FOREIGN  KEY  (product_id)  REFERENCES  tblproductpt  (id)  ON  DELETE  CASCADE  ON  UPDATE  NO  ACTION,
    CONSTRAINT  FK_INVENTORY_BOXTYPE  FOREIGN  KEY  (box_type_id)  REFERENCES  tblboxtypept  (id)  ON  DELETE  CASCADE  ON  UPDATE  NO  ACTION,
    CONSTRAINT  FK_INVENTORY_COMPANY  FOREIGN  KEY  (company_id)  REFERENCES  tblcompanypt  (id)  ON  DELETE  CASCADE  ON  UPDATE  NO  ACTION
);

CREATE  TABLE  tblcustomerpt  (
    id  INTEGER NOT  NULL PRIMARY KEY AUTOINCREMENT,
    name  VARCHAR(80),
    markdown  DECIMAL(5,2)  NOT  NULL  DEFAULT  0
);