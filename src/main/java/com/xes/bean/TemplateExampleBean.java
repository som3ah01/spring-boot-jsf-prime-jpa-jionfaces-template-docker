package com.xes.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.xes.entity.TemplateExampleEntity;
import com.xes.service.TemplateExampleService;

import lombok.Getter;
import lombok.Setter;

@Named(value = "templateExampleBean")
@ViewScoped
public class TemplateExampleBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private PrimeBeanSpcificationsBuilderLazyDataModel<TemplateExampleEntity> templateExampleLazyDataModel;
	@Autowired
	private TemplateExampleService templateExampleService;

	@PostConstruct
	private void initLoads() {
		templateExampleLazyDataModel = new PrimeBeanSpcificationsBuilderLazyDataModel<>(templateExampleService);
	}

	public void onRowEdit(RowEditEvent event) {
		templateExampleService.save((TemplateExampleEntity) event.getObject());
	}
}
