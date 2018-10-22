package name.anonymous.common.front.utils.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * retrieve a parameter path of current request url
 *
 * @author anonymous
 *
 */
@Service
public class RequestUtil {
	private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

	public String getContextPath() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		return request.getContextPath();
	}

	/**
	 * @return "HERO" or "VILAIN"
	 */
	public String getUserType() {
		String url = getUrl();
		String userType = ANT_PATH_MATCHER.extractUriTemplateVariables(getContextPath() + "/{userType}/**", url)
				.get("userType");
		if (userType == null) {
			throw new IllegalStateException(String.format("userType is not in this URL : %s", url));
		}
		return userType;
	}

	/**
	 *
	 * @return a BU number like "005" for LMIT
	 */
	public String getBu() {
		String url = getUrl();
		String bu = ANT_PATH_MATCHER.extractUriTemplateVariables(getContextPath() + "/{userType}/{bu}/**", url)
				.get("bu");
		if (bu == null) {
			throw new IllegalStateException(String.format("bu is not in this URL : %s", url));
		}
		return bu;
	}

	/**
	 * @return a BU number like 5 for LMIT
	 */
	public int getBuInt() {
		return Integer.parseInt(getBu());
	}

	/**
	 * @return application name like "heros"
	 */
	public String getApp() {
		String url = getUrl();
		String app = ANT_PATH_MATCHER.extractUriTemplateVariables(getContextPath() + "/{userType}/{bu}/{app}/**", url)
				.get("app");
		if (app == null) {
			throw new IllegalStateException(String.format("app is not in this URL : %s", url));
		}
		return app;
	}

	/**
	 * @return url request with context path
	 */
	public String getUrl() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// JSP
		String url = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
		if (url == null) {
			// Controller
			url = request.getRequestURI();
		}
		return url;
	}

	/**
	 * @return a url with userType and BU
	 */
	public String getBuBaseUrl() {
		return "/" + getUserType() + "/" + getBu();
	}

	/**
	 * @return a url with userType, BU and app
	 */
	public String getAppBaseUrl() {
		return getBuBaseUrl() + "/" + getApp();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestUtil [getUrl()=").append(getUrl()).append("]");
		return builder.toString();
	}
}
