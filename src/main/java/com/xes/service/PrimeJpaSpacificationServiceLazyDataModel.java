package com.xes.service;

import java.io.Serializable;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrimeJpaSpacificationServiceLazyDataModel<T> extends Serializable {

	Page<T> findAllByMapFillterPageing(Map<String, FilterMeta> filters, Pageable pageable) ;
}
