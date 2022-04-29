package com.example.data.repository.specification;

import com.example.data.dto.ExpertFilterDto;
import com.example.data.entity.Expert;
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
public interface ExpertSpecifications {
    static Specification<Expert> expertFilter(ExpertFilterDto expertFilterDto) {
        return (root, query, criteriaBuilder) -> {
            CriteriaQuery<Expert> resultCriteria = criteriaBuilder.createQuery(Expert.class);
            List<Predicate> predicates = new ArrayList<>();
            if (expertFilterDto.getSubServiceName() != null) {
                Join<Expert, SubService> subServices = root.join("subServices");
                predicates.add(criteriaBuilder.equal(subServices.get("name"), expertFilterDto.getSubServiceName()));
            }
            if (!expertFilterDto.getName().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("name"), expertFilterDto.getName()));
            if (!expertFilterDto.getSurname().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("surname"), expertFilterDto.getSurname()));
            if (!expertFilterDto.getEmail().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("email"), expertFilterDto.getEmail()));
            if (expertFilterDto.getScore() != 0)
                predicates.add(criteriaBuilder.equal(root.get("score"), expertFilterDto.getScore()));

            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();
        };
    }
}
