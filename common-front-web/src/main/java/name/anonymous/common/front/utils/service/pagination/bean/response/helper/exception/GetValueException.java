package name.anonymous.common.front.utils.service.pagination.bean.response.helper.exception;

import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

/**
 * Throw if a DTO can not be transformed to map
 * @author anonymous
 *
 */
public class GetValueException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 3635514007816877253L;
	private BeanPropertyDefinition beanPropertyDefinition;
	private Object object;

	public GetValueException() {
		super();
	}
	public GetValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public GetValueException(String message, Throwable cause) {
		super(message, cause);
	}
	public GetValueException(String message) {
		super(message);
	}
	public GetValueException(Throwable cause) {
		super(cause);
	}

	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

	public BeanPropertyDefinition getBeanPropertyDefinition() {
		return beanPropertyDefinition;
	}
	public void setBeanPropertyDefinition(BeanPropertyDefinition beanPropertyDefinition) {
		this.beanPropertyDefinition = beanPropertyDefinition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetValueException [beanPropertyDefinition=").append(beanPropertyDefinition).append(", object=").append(object).append("]");
		return builder.toString();
	}
}
