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

@Named(value = "templateExampleAddBean")
@ViewScoped
public class TemplateExampleAddBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	List<TemplateExampleEntity> templateExampleList = new ArrayList<>();
	@Autowired
	private TemplateExampleService templateExampleService;



	public void save() {
		templateExampleService.saveAll(templateExampleList);
	}
	public void addNew() {
		templateExampleList.add(new TemplateExampleEntity());
	}
}
