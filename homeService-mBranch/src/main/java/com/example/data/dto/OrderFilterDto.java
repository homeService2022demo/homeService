package com.example.data.dto;

import com.example.data.enums.OrderPaymentStatus;
import com.example.data.enums.OrderStatus;
import com.example.data.enums.PaymentType;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author fh.kazemi
 **/
@Data
@ToString
public class OrderFilterDto {
    private String orderTackingCode;
    private Date creationDate;
    private String subServiceName;
    private OrderStatus orderStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishedDate;
    private OrderPaymentStatus orderPaymentStatus;
    private PaymentType paymentType;
}
