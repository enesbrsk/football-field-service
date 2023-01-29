package com.example.footballfield.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public  class SearchSpecification <T> {

    public Specification<T> search(String value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("areaName"), "%" + value + "%");
    }

    public Specification<T> searchByUser(String  userId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userId"), userId);
    }
}
