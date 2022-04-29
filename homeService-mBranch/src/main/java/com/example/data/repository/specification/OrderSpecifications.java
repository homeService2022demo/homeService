package com.example.data.repository.specification;

import com.example.data.dto.OrderFilterDto;
import com.example.data.entity.Order;
import com.example.data.entity.SubService;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fh.kazemi
 **/
public interface OrderSpecifications {
    static Specification<Order> orderFilter(OrderFilterDto orderFilterDto) {
        return (root, query, criteriaBuilder) -> {
            CriteriaQuery<Order> resultCriteria = criteriaBuilder.createQuery(Order.class);
            List<Predicate> predicates = new ArrayList<>();
            if (!orderFilterDto.getOrderTackingCode().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("orderTackingCode"), orderFilterDto.getOrderTackingCode()));
            if (orderFilterDto.getCreationDate() != null)
                predicates.add(criteriaBuilder.equal(root.get("creationDate"), orderFilterDto.getCreationDate()));
            if (orderFilterDto.getOrderStatus() != null)
                predicates.add(criteriaBuilder.equal(root.get("orderStatus"), orderFilterDto.getOrderStatus()));
            if (!orderFilterDto.getSubServiceName().isEmpty()) {
                Join<Order, SubService> subService = root.join("subService");
                predicates.add(criteriaBuilder.equal(subService.get("name"), orderFilterDto.getSubServiceName()));
            }
            if (orderFilterDto.getStartDate() != null)
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), orderFilterDto.getStartDate()));
            if (orderFilterDto.getFinishedDate() != null)
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("finishedDate"), orderFilterDto.getFinishedDate()));
            if (orderFilterDto.getOrderPaymentStatus() != null)
                predicates.add(criteriaBuilder.equal(root.get("orderPaymentStatus"), orderFilterDto.getOrderPaymentStatus()));
            if (orderFilterDto.getPaymentType() != null)
                predicates.add(criteriaBuilder.equal(root.get("paymentType"), orderFilterDto.getPaymentType()));

            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();
        };
    }
}
