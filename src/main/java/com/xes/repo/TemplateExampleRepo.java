package com.xes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.xes.entity.TemplateExampleEntity;

@Repository
public interface TemplateExampleRepo extends JpaRepository<TemplateExampleEntity, Integer>,JpaSpecificationExecutor<TemplateExampleEntity> {

}
