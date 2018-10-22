package name.anonymous.common.front.app.heros.model;

import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;

import name.anonymous.common.front.app.heros.model.embeddable.Hero;
import name.anonymous.common.front.app.heros.model.embeddable.MissionState;
import name.anonymous.common.front.app.heros.model.embeddable.Money;
import name.anonymous.common.front.app.heros.model.embeddable.Version;

public class MissionApiModel {
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Numéro de commande
	 */
	private String num;

	private Version version;

	private MissionState state;

	private Money totalAmount;

	private Hero hero;

	public Money getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public MissionState getState() {
		return state;
	}

	public void setState(MissionState state) {
		this.state = state;
	}

	public Hero gethero() {
		return hero;
	}

	public void sethero(Hero hero) {
		this.hero = hero;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
