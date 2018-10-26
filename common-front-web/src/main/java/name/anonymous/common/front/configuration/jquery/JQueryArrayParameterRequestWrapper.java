package name.anonymous.common.front.configuration.jquery;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.cache.annotation.Cacheable;

import name.anonymous.common.front.utils.uri.jquery.JqueryUtils;

public class JQueryArrayParameterRequestWrapper extends HttpServletRequestWrapper {
	public JQueryArrayParameterRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	@Cacheable
	public Map<String, String[]> getParameterMap() {
		return modifyParameterMap(super.getParameterMap());
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(getParameterMap().keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return getParameterMap().get(name);
	}

	@Override
	public String getParameter(String name) {
		return getParameterValues(name) != null && getParameterValues(name).length > 0 ? getParameterValues(name)[0] : null;
	}

	private Map<String, String[]> modifyParameterMap(Map<String, String[]> oldParameterMap) {
		Map<String, String[]> newParameterMap = new HashMap<>(oldParameterMap.size());
		for (Map.Entry<String, String[]> entry : oldParameterMap.entrySet()) {
			String key = entry.getKey();
			StringBuilder stringBuilder = new StringBuilder();
			JqueryUtils.replaceBracket(key, stringBuilder);
			newParameterMap.put(stringBuilder.toString(), entry.getValue());
		}
		return newParameterMap;
	}
}