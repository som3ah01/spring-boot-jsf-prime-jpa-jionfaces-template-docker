package com.xes.config;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;


@Component
public class DefaultHttpConfiguration extends HttpConfigurationProvider  {
	
	@Override
	public Configuration getConfiguration(ServletContext t) {
		return ConfigurationBuilder.begin()
			.addRule()
			.when(Direction.isInbound().and(Path.matches("/")))
			.perform(Redirect.temporary("/xes-app/index.xes"));
	}
	

	@Override
	public int priority() {
		return 10;
	}

}
