package com.example.service.mapper.impl;

import com.example.data.dto.OrderDto;
import com.example.data.entity.Order;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @author fh.kazemi
 **/

@Data
@Service
public class OrderMapper implements GenericMapper<Order, OrderDto> {

    private final WorkMapper workMapper;
    private final OfferMapper offerMapper;

    @Override
    public OrderDto convertToDto(Order order) {
        return OrderDto.builder()
                .creationDate(order.getCreationDate())
                .orderstatus(order.getOrderstatus())
                .orderPaymentStatus(order.getOrderPaymentStatus())
                .paymentType(order.getPaymentType())
                .work(workMapper.convertToDto(order.getWork()))
                .offers(order.getOffers()
                        .stream().map(offerMapper::convertToDto)
                        .collect(Collectors.toCollection(HashSet::new)))
                .description(order.getDescription())
                .build();
    }

    @Override
    public Order convertToEntity(OrderDto orderDto) {
        return Order.builder()
                .creationDate(orderDto.getCreationDate())
                .orderstatus(orderDto.getOrderstatus())
                .orderPaymentStatus(orderDto.getOrderPaymentStatus())
                .paymentType(orderDto.getPaymentType())
                .work(workMapper.convertToEntity(orderDto.getWork()))
                .offers(orderDto.getOffers()
                        .stream().map(offerMapper::convertToEntity)
                        .collect(Collectors.toCollection(HashSet::new)))
                .description(orderDto.getDescription())
                .build();
    }
}
