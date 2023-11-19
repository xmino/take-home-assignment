# take-home-assignment
Backend Take-Home Test Xavier Mino

Objetivo  : Desarrollar una aplicación en Spring Boot  (preferiblemente) que implemente  las fórmulas especificadas y realice la transformación de datos de acuerdo con las  reglas proporcionadas. 
En esta aplicación se debe realizar lo siguiente:  


1.   Implementar una API que reciba como parámetro el id de una compañía y  calcule el final freight según la fórmula especificada (ver sección de recursos) y  retorne los ítems del inventario asociados a la compañía.  
2.   Implementar una API que reciba como parámetro el customerId, calcule el precio  (price) según la fórmula especificada (ver sección de recursos) y retorne la lista  de productos correspondientes de cualquier compañía (company) con su  respectivo precio.
3.   Implementar una API que tome como parámetro de entrada el id de una  compañía devuelva una lista con el nombre del producto (productName) tal cual  como está en base de datos y el código del producto (ProductCode) calculado  de la siguiente manera:

      - El primer carácter será la primera letra de la palabra.
      - Concatenar el número de caracteres distintos entre el primero y el último.
      - Seguido por la última letra de la palabra inicial.
      - Los espacios en blanco reemplazarlos por guión medio  "-"
      - Si hay caracteres especiales los debe poner después del número de  caracteres
        ```      
         Ejemplos  ●   Roses  ->  R3s  Ejemplo con nombres de productos:  ●   Red Roses 23cm  ->R1d-R3s-22m  ●   IL Hydrangea Blue  ->   I0L-H7a-B2e  ●   Black Gira%sol 17Inch ->B3k-G6%l-14h  ●   &White pom 3Inch ->&4e-p1m-33h 


## Project Setup

Create JAVA_HOME and install Gradle in the local environment
```
./gradlew build
```

Run the app:
```
./gradlew bootRun
```

Run the PMD:
```
./gradlew pmdMain
```
​
Run the tests:
```
./gradlew test
```
