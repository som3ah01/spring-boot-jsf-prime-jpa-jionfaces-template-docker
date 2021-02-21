package com.xes.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Getter;
import java.io.Serializable;

@Named(value = "layoutBean")
@SessionScoped
@Getter
public class LayoutBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String contentURL;
	
	private String headerURL ="/template/header.xhtml";
	private String centerMainURL="/pages/view/center_main.xhtml";
	private String templateExampleURL="/pages/view/template_example.xhtml";
	private String templateExampleAddURL="/pages/view/template_example_add.xhtml";
	
	
	@PostConstruct
	public void initLoad() {
		contentURL = centerMainURL;
	}
	
}
