package com.xes.filtter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

public class SearchSpecificationsBuilderImpl<T>  implements SearchSpecificationsBuilder<T>  {
	 private final List<SearchCriteria> params;
	 
	    public SearchSpecificationsBuilderImpl() {
	        params = new ArrayList<SearchCriteria>();
	    }
	 
	    public SearchSpecificationsBuilderImpl<T>  with(String key, String operation, Object value) {
	        params.add(new SearchCriteria(key, operation, value));
	        return this;
	    }
	 
	    public Specification<T> build() {
	        if (params.size() == 0) {
	            return null;
	        }
	 
	        List<Specification<T>> specs = new ArrayList<Specification<T>>();
	        for (SearchCriteria filerKeyVal : params) {
	            specs.add(new SearchSpecification<T>(filerKeyVal));
	        }
	 
	        Specification<T> result = specs.get(0);
	        for (int i = 1; i < specs.size(); i++) {
	            result = Specification.where(result).and(specs.get(i));
	        }
	        return result;
	    }

}
