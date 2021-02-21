package com.xes.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.xes.service.PrimeJpaSpacificationServiceLazyDataModel;

public class PrimeBeanSpcificationsBuilderLazyDataModel<T> extends LazyDataModel<T> implements Serializable {

//	@Autowired
	private PrimeJpaSpacificationServiceLazyDataModel<T> jpaSpacificationServiceLazyDataModel;

	private static final long serialVersionUID = 1L;

	public PrimeBeanSpcificationsBuilderLazyDataModel(PrimeJpaSpacificationServiceLazyDataModel<T> jpaSpacificationServiceLazyDataModel) {
		this.jpaSpacificationServiceLazyDataModel = jpaSpacificationServiceLazyDataModel;
	}

	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, FilterMeta> filterBy) {

		int start = first / pageSize;
		PageRequest pageRequest;
		if (sortField != null) {
			Direction direction = (SortOrder.ASCENDING.equals(SortOrder.valueOf(sortOrder.name()))) ? Direction.ASC
					: Direction.DESC;
			Sort sort = Sort.by(direction, sortField);
			pageRequest = PageRequest.of(start, pageSize, sort);
		} else {
			pageRequest = PageRequest.of(start, pageSize);
		}

		Page<T> userPages = jpaSpacificationServiceLazyDataModel.findAllByMapFillterPageing(filterBy, pageRequest);
		List<T> filteredList = userPages.getContent();
		this.setRowCount((int) userPages.getTotalElements());
		return (List<T>) filteredList;
	}



}
