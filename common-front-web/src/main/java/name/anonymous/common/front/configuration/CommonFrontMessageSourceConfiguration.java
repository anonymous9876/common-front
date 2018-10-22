package name.anonymous.common.front.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class CommonFrontMessageSourceConfiguration {
	private static final String COMMON_I18N = "/i18n/common/";
	private static final String INDIRECT_PURCHASES_I18N = "/i18n/heros/";

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.addBasenames(
				COMMON_I18N + "common",
				INDIRECT_PURCHASES_I18N + "heros",
				"classpath:mail/MailMessages"
		);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setCacheMillis(0);
		return messageSource;
	}
}
