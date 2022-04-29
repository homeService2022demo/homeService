package com.example.data.repository.specification;

import com.example.data.dto.UserDto;
import com.example.data.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fh.kazemi
 **/
public interface UserSpecifications {
    static Specification<User> userFilter(UserDto userDto){
        return (root, query, criteriaBuilder) -> {
            CriteriaQuery<User> resultCriteria = criteriaBuilder.createQuery(User.class);
            List<Predicate> predicates = new ArrayList<>();
            if(!userDto.getName().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("name"),userDto.getName()));
            if(!userDto.getSurname().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("surname"), userDto.getSurname()));
            if(!userDto.getEmail().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("email"),userDto.getEmail()));
            if(!userDto.getUsername().isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("username"),userDto.getUsername()));
            if(userDto.getStatus()!= null)
                predicates.add(criteriaBuilder.equal(root.get("status"), userDto.getStatus()));

            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();
        };
    }
}
