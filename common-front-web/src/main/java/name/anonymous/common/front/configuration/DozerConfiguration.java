package name.anonymous.common.front.configuration;

import static org.dozer.loader.api.TypeMappingOptions.beanFactory;
import static org.dozer.loader.api.TypeMappingOptions.mapNull;

import java.util.Collections;
import java.util.UUID;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import name.anonymous.common.front.configuration.dozer.beanFactory.UuidBeanFactory;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;

@Configuration
public class DozerConfiguration {
	@Bean
	public DozerBeanMapper dozerBean() {
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));

		dozerBeanMapper.addMapping(new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(UUID.class, UUID.class, beanFactory(UuidBeanFactory.class.getName()));
			}
		});

		dozerBeanMapper.addMapping(new BeanMappingBuilder() {
			protected void configure() {
				mapping(PaginatedDataBean.class, PaginatedDataBean.class, mapNull(true)).exclude("data");
			}
		});

		return dozerBeanMapper;
	}
}
