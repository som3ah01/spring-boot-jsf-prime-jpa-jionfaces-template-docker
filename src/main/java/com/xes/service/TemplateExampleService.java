package com.xes.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xes.entity.TemplateExampleEntity;
import com.xes.filtter.SearchSpecificationsBuilder;
import com.xes.filtter.SearchSpecificationsBuilderImpl;
import com.xes.repo.TemplateExampleRepo;

@Service
public class TemplateExampleService implements PrimeJpaSpacificationServiceLazyDataModel<TemplateExampleEntity> , Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TemplateExampleRepo repo;

	@Override
	public Page<TemplateExampleEntity> findAllByMapFillterPageing(Map<String, FilterMeta> filters, Pageable pageable) {
		SearchSpecificationsBuilder<TemplateExampleEntity> myBuilder = new SearchSpecificationsBuilderImpl<>();
		filters.forEach((key, val) -> { myBuilder.with(key, ":", val);});
		return repo.findAll(myBuilder.build(), pageable);
	}
	public void save(TemplateExampleEntity entity) {
		repo.save(entity);
	}
	public void saveAll(List<TemplateExampleEntity> entityList) {
		repo.saveAll(entityList);
	}

}
