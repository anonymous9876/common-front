package name.anonymous.common.front.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import name.anonymous.common.front.configuration.i18n.I18nJs;

@Service
public class I18nJsChangeInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private I18nJs i18nJs;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			modelAndView.addObject("i18nJs", i18nJs);
		}
	}
}
