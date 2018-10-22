package name.anonymous.common.front.app.heros.dto.table.embeddable;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"value", "lastModified"})
public class MissionState implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -4955205605680549314L;

	/**
	 * Statut de la mission
	 */
	private String value;

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
