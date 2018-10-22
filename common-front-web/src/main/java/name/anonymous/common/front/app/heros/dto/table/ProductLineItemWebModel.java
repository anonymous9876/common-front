package name.anonymous.common.front.app.heros.dto.table;

import java.time.LocalDate;
import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import name.anonymous.common.front.app.heros.dto.table.embeddable.Product;
import name.anonymous.common.front.app.heros.model.embeddable.Address;
import name.anonymous.common.front.app.heros.model.embeddable.Person;

@JsonPropertyOrder({
	"id",
	"num", "nomFour",
	"numLig",
	"product",
	"buyer",
	"delivryAddress",
	"dateLivSouh", "dateLivAnnon", "dateLivAccept",
	"unite", "qte", "pu", "mntLig"})
public class ProductLineItemWebModel {
	private UUID id;

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	private Integer numLig;

	private Product product;

	private Person buyer;

	//Livré à  = ?
	private Address delivryAddress;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateLivSouh;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateLivAnnon;

	//hors flux
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateLivAccept;

	private String unite;


	/**
	 *  Si type de ligne (obj18.typ_pro) = "SER"
	 *  alors mntLig
	 *  Sinon (cod_unt_qte ?) * qte * pu
	 */
	//private String typeLig;
	private Double mntLig;
	private Integer qte;
	private Double pu;

	//statut_ligne (obj18.3.statut_ligne) absent du flux

	public Integer getNumLig() {
		return numLig;
	}
	public void setNumLig(Integer numLig) {
		this.numLig = numLig;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public LocalDate getDateLivSouh() {
		return dateLivSouh;
	}
	public void setDateLivSouh(LocalDate dateLivSouh) {
		this.dateLivSouh = dateLivSouh;
	}
	public LocalDate getDateLivAnnon() {
		return dateLivAnnon;
	}
	public void setDateLivAnnon(LocalDate dateLivAnnon) {
		this.dateLivAnnon = dateLivAnnon;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public Double getMntLig() {
		return mntLig;
	}
	public void setMntLig(Double mntLig) {
		this.mntLig = mntLig;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public Double getPu() {
		return pu;
	}
	public void setPu(Double pu) {
		this.pu = pu;
	}

	public LocalDate getDateLivAccept() {
		return dateLivAccept;
	}
	public void setDateLivAccept(LocalDate dateLivAccept) {
		this.dateLivAccept = dateLivAccept;
	}

	public Person getBuyer() {
		return buyer;
	}
	public void setBuyer(Person buyer) {
		this.buyer = buyer;
	}
	public Address getDelivryAddress() {
		return delivryAddress;
	}
	public void setDelivryAddress(Address delivryAddress) {
		this.delivryAddress = delivryAddress;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
