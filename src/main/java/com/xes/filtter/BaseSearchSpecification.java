package com.xes.filtter;

import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BaseSearchSpecification<T> {
	protected SearchCriteria criteria;
	protected Predicate doPredicateAction(Root<T> root, CriteriaBuilder builder) {

		if (criteria.getValue() == null || criteria.getValue().toString().isEmpty()
				|| criteria.getValue().toString().equals("0")) {
			return null;
		}

		boolean name1 = criteria.getValue().getClass().getName().equals(java.util.Date.class.getName());
		boolean inst2 = criteria.getValue().getClass().isInstance(java.util.Date.class);
		boolean isEqual = (inst2 || name1) ? true : false;
		Path keyPath = myPathObj(root);
		if (criteria.getOperation().equalsIgnoreCase(">")) {
			if (isEqual) {
				return builder.greaterThanOrEqualTo(keyPath, (Date) criteria.getValue());
//				return builder.greaterThanOrEqualTo(root.<Date>get(criteria.getKey()), (Date) criteria.getValue());
			} else
				return builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()),
						criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			if (isEqual) {
				return builder.lessThanOrEqualTo(keyPath, (Date) criteria.getValue());
//				return builder.lessThanOrEqualTo(root.<Date>get(criteria.getKey()), (Date) criteria.getValue());
			} else
				return builder.lessThanOrEqualTo(keyPath, criteria.getValue().toString());
//			return builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(":")) {
			if (keyPath.getJavaType() == String.class) {
				return builder.like(keyPath, "%" + criteria.getValue() + "%");
//				return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
			} else {
				return builder.equal(keyPath, criteria.getValue());
//				return builder.equal(root.get(criteria.getKey()), criteria.getValue());

			}
		}
		return null;
	}
	private Path myPathObj(Root root) {
		Path keyPath = null;
		String[] keysArray = criteria.getKey().split(Pattern.quote("."));
		if(keysArray.length==1) {
			keyPath= root.<Object>get(keysArray[0]);
			return keyPath;
		}
		Join actionJoin = null;
		for (int i = 0; i < keysArray.length; i++) {
			if(i == 0) {
				actionJoin = root.join(keysArray[i]);
			}else if(i < keysArray.length-1) {
				actionJoin = doJoin(actionJoin,keysArray[i]);
			}
			if(i == keysArray.length-1) {
				keyPath= actionJoin.<Object>get(keysArray[i]);
			}
		}
		return keyPath;
	}
	public <Main ,Sub> Join doJoin(Join actionJoin,String joinKey){
		Join<Main, Sub> join = actionJoin.join(joinKey);
		return join;
	}
	

}
