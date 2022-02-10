package com.example.data.dto;

import com.example.data.entity.Customer;
import com.example.data.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CommentDto {
    private final LocalDateTime commentDate;
    private String description;
    private Order order;
    private Customer customer;

    public CommentDto() {
        commentDate = LocalDateTime.now();
    }
}
