package name.anonymous.common.front.app.heros.dto.table;

import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import name.anonymous.common.front.app.heros.dto.table.embeddable.MissionState;
import name.anonymous.common.front.app.heros.model.embeddable.Hero;
import name.anonymous.common.front.app.heros.model.embeddable.Money;
import name.anonymous.common.front.app.heros.model.embeddable.Version;

@JsonPropertyOrder({
	"num",
	"hero",
	"version",
	"totalAmount",
	"state"})
public class MissionTableModel {
	private UUID id;

	private String num;

	private Hero hero;

	private Version version;

	private Money totalAmount;

	private MissionState state;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Money getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
