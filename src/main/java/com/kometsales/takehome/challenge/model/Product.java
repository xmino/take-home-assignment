package com.kometsales.takehome.challenge.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Table(name = "tblproductpt")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "fresh_cut_value")
    private Double freshCutValue;

    /**
     * This method calculates the product code based on the following rules:
     * 1. The product code is the first letter of each word in the product name.
     * 2. If the word has only one letter, the code will be the letter.
     * 3. If the word has two letters, the code will be the two letters.
     * 4. If the word has more than two letters, the code will be the first letter, the number of distinct letters between the first and last letter, and the last letter.
     * 5. Special characters after the number of distinct letters.
     * 6. Any word code separated by a '-'.
     * @return product code
     */
    public String getCode() {
        String[] words = name.split(" ");
        return Arrays.stream(words).sequential()
              .map(this::calculateWordCode)
              .collect(Collectors.joining("-"));
    }

    private String calculateWordCode(String word) {
        int size = word.length();
        if(size <= 2) {
            return  size == 1 ? word : word.substring(0,1) + 0 + word.substring(1);
        }
        String wordBetween =  word.substring(1, size - 1);
        Long totalChars = wordBetween.chars().distinct().count();
        String specialChars = wordBetween.replaceAll("[a-zA-Z0-9]", "");
        return word.substring(0,1) +
                totalChars +
                specialChars +
                word.substring(size-1);
    }
}
