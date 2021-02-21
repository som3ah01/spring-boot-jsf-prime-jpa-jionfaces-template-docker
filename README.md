# spring-boot-jsf-prime-jpa-jionfaces
Spring Boot JoinFaces Starter with PrimeFaces and JPA Custom Danamic Spacifications  
 > This is quick Template Example Where could be base for your project as quick start

# Entry points
http://localhost:8081/xes-app/  
http://localhost:8081/xes-app/index.xes  

# Based on Join-Faces Spring Boot Starter
 - JSF  
 - PrimeFaces 8
 - PrimeThemes
 - Spring Data ( JPA - Spacifications )
 - DB -> ( H2 in Memory DB as default / MySql )
 - JDK 11
 - Spring boot 2.5.*
 - JoinFaces 2.4.*

# Project Structure
All (pages - images - css - javascript - index:file ) should be under;
src\main\resources\META-INF\resources\
 - index:file
 - css
 - images
 - pages
 - Template

# What benifits from this packge fillter
 > This is consest of two parts to limit Changes in the middel layers.  
 > PrimeFaces Lazy Loading Data With JPA Custom Specifications.  
 > When you need changes in Front End trying to limit most of changes in the front end in HTML And Enities in the most botton Layer.  
 > Else you need some times implement your business logic.

# How to use or
 ###  com.xes.filtter
  > Here All specifications classes implemented
 ### com.xes.bean
 > Any Bean you need it get benifits of PrimeLazyModol With JPA Spicifications.  
 > You have to inect PrimeBeanSpcificationsBuilderLazyDataModel.  
 > As TemplateExampleEntity example of any entity of your choose that will be used in the Front End XHTML.
 > As templateExampleService the service layer that have include your repository 
 ```
 @Getter @Setter
	private PrimeBeanSpcificationsBuilderLazyDataModel<TemplateExampleEntity> templateExampleLazyDataModel;
 @PostConstruct
	private void initLoads() {
		templateExampleLazyDataModel = new PrimeBeanSpcificationsBuilderLazyDataModel<>(templateExampleService);
	}
 ```
 ### com.xes.service
 > The service class have to implement PrimeJpaSpacificationServiceLazyDataModel<TemplateExampleEntity>  
 > As TemplateExampleEntity example of any entity of your choose that will be used in the Front End XHTML.  
 > You have to implement And Override findAllByMapFillterPageing as below.  
 > repo is your Repository interface as injted.  
 ```
 @Override
	public Page<TemplateExampleEntity> findAllByMapFillterPageing(Map<String, FilterMeta> filters, Pageable pageable) {
		SearchSpecificationsBuilder<TemplateExampleEntity> myBuilder = new SearchSpecificationsBuilderImpl<>();
		filters.forEach((key, val) -> { myBuilder.with(key, ":", val);});
		return repo.findAll(myBuilder.build(), pageable);
	}
 ```

 ### com.xes.repo
 > The interface Should extends JpaRepository<TemplateExampleEntity, Integer>,JpaSpecificationExecutor<TemplateExampleEntity>  
 > As TemplateExampleEntity example of any entity of your choose that will be used in the Front End XHTML.  
 > AS Integer the type id your entity ID  


# Can try it with 
```
 mvn spring-boot:run
 ```
 OR
 ```
  ./mvnw spring-boot:run
 ```
 
 
 > Thanks :+1: if you have any comments to share with me :shipit:  
 > By @Ismail Shebl
