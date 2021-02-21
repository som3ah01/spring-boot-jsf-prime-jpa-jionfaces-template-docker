package com.xes.filtter;

import org.springframework.data.jpa.domain.Specification;

public interface SearchSpecificationsBuilder<T> {

	Specification<T> build();
	SearchSpecificationsBuilder<T> with(String key, String operation, Object value);
}
