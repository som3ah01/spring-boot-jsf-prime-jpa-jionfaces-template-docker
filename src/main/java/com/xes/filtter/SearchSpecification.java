package com.xes.filtter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;


public class SearchSpecification<T> extends BaseSearchSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = 7391035857173878640L;
//	private SearchCriteria criteria;
	
	public SearchSpecification(SearchCriteria criteria) {
		super.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		return doPredicateAction(root, builder);
	}

	
}
