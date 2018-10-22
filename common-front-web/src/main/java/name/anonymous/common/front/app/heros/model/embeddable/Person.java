package name.anonymous.common.front.app.heros.model.embeddable;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "name", "email", "ldap"})
public class Person implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -5630250990028371881L;

	private String lastName;
	private String firstName;
	private String email;
	private String ldap;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLdap() {
		return ldap;
	}

	public void setLdap(String ldap) {
		this.ldap = ldap;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
