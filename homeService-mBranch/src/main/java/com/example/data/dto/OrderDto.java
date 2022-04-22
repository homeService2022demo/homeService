package com.example.data.dto;

import com.example.data.entity.Customer;
import com.example.data.entity.SubService;
import com.example.data.enums.OrderPaymentStatus;
import com.example.data.enums.OrderStatus;
import com.example.data.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private String orderTackingCode;
    private Date creationDate;
    private OrderStatus orderstatus;
    private SubService subService;
    private OrderPaymentStatus orderPaymentStatus;
    private PaymentType paymentType;
    private WorkDto work;
    private Set<OfferDto> offerDtos;
    private String description;
}
