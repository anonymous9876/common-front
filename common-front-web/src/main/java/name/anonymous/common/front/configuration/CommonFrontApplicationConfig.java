package name.anonymous.common.front.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import name.anonymous.common.front.configuration.i18n.I18nJs;
import name.anonymous.common.front.configuration.i18n.I18nJsFactory;

@Configuration
public class CommonFrontApplicationConfig {
	@Bean
	@RequestScope
	public I18nJs i18nJs(I18nJsFactory i18nJsFactory) {
		return i18nJsFactory.getI18nJs();
	}
}
