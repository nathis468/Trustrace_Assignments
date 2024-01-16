package com.example.expensetracker.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "expenses")
@Data
@AllArgsConstructor
// @NoArgsConstructor   
public class Expense {
    @Id
    private String id;

    @Field("data_time")
    private LocalDateTime dateAndTime;
    private String description;
    private BigDecimal amount;
    
    public Expense() {
        this.dateAndTime = LocalDateTime.now();
    }
}
