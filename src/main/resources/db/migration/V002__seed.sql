
INSERT  INTO  tblproductpt  (  id, name, fresh_cut_value  )
    VALUES  (  1  ,  "Red Roses 23cm"  ,  10  )  ,
            (  2  ,  "IL Hydrangea Blue"  ,  15  )  ,
            (  3  ,  "Black Gira%%sol 17Inch"  ,  45  )  ,
            (  4  ,  "&White pom 3Inch"  ,  12  )  ,
            (  5  ,  "Achillea$ Blue 23cm"  ,  57  )  ;
INSERT  INTO  tblcompanypt  (  id, name  )
    VALUES  (  1  ,  "BellaFlowers"  )  ,
            (  2  ,  "SuperFlowers"  )  ,
            (  3  ,  "BeautiFlowers"  )  ,
            (  4  ,  "TheFlowers"  )  ,
            (  5  ,  "CandyFlowers"  )  ;
INSERT  INTO  tblboxtypept  (  id,  code, width, height,  length  )
    VALUES  (  1  ,  "1111"  ,  12.1  ,  12.8  ,  11.2  )  ,
            (  2  ,  "2222"  ,  11.6  ,  16.2  ,  12.7  )  ,
            (  3  ,  "3333"  ,  15.2  ,  18.9  ,  17.4  )  ,
            (  4  ,  "4444"  ,  13.9  ,  15.5  ,  10.8  )  ,
            (  5  ,  "5555"  ,  14.4  ,  12.7  ,  15.5  )  ;
INSERT  INTO  tblinventorypt  (  id, box_type_id, product_id,  company_id,  cubes_per_carrier, pack, base_price  )
    VALUES  (  1  ,  1  ,  4  ,  3  ,  16.3  ,  1  ,  1.1  )  ,
            (  2  ,  2  ,  1  ,  2  ,  13.6  ,  1  ,  1.7  )  ,
            (  3  ,  3  ,  5  ,  5  ,  11.6  ,  1  ,  1.4  )  ,
            (  4  ,  4  ,  2  ,  1  ,  15.2  ,  1  ,  1.3  )  ,
            (  5  ,  5  ,  3  ,  4  ,  12.3  ,  1  ,  1.2  )  ;
INSERT  INTO  tblcustomerpt  (  id, name, markdown  )
    VALUES  (  1  ,  "Luis"  ,  5  )  ,
            (  2  ,  "Daniel"  ,  2  )  ,
            (  3  ,  "William"  ,  3  )  ,
            (  4  ,  "Johan"  ,  1  )  ,
            (  5  ,  "Jessica"  ,  4  )  ;


