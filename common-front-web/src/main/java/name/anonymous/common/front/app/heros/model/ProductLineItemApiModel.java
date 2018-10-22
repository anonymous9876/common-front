package name.anonymous.common.front.app.heros.model;

import java.time.LocalDate;
import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;

import name.anonymous.common.front.app.heros.model.embeddable.Address;
import name.anonymous.common.front.app.heros.model.embeddable.Person;
import name.anonymous.common.front.app.heros.model.embeddable.Product;

public class ProductLineItemApiModel {
	private UUID id;
	/**
	 * Date de livraison demandée
	 */
	private LocalDate dateLivSouh;
	/**
	 * Date de livraison
	 */
	private LocalDate dateLivAnnon;

	// hors flux
	private LocalDate dateLivAccept;

	// Commandé par = name name / email
	private Person buyer;

	// Livré à  = ?
	private Address delivryAddress;

	/**
	 * Numéro de la ligne de commande
	 */
	private Integer numLig;

	private Product product;
	/**
	 * Code de l'unité de mesure (UOM_CODE) Ex: Ea
	 */
	private String unite;
	/**
	 * Quantité commandée
	 */
	private Integer qte;
	/**
	 * Prix unitaire
	 */
	private Double pu;
	/**
	 * Montant de la ligne
	 */
	private Double mntLig;
	/**
	 * Type de ligne (Montant ou QTE)
	 */
	private String typeLig;
	private Integer qteRcpt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public void setDateLivSouh(LocalDate dateLivSouh) {
		this.dateLivSouh = dateLivSouh;
	}

	public LocalDate getDateLivAnnon() {
		return dateLivAnnon;
	}

	public void setDateLivAnnon(LocalDate dateLivAnnon) {
		this.dateLivAnnon = dateLivAnnon;
	}

	public Integer getNumLig() {
		return numLig;
	}

	public void setNumLig(Integer numLig) {
		this.numLig = numLig;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
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

	public Double getMntLig() {
		return mntLig;
	}

	public void setMntLig(Double mntLig) {
		this.mntLig = mntLig;
	}

	public String getTypeLig() {
		return typeLig;
	}

	public void setTypeLig(String typeLig) {
		this.typeLig = typeLig;
	}

	public Integer getQteRcpt() {
		return qteRcpt;
	}

	public void setQteRcpt(Integer qteRcpt) {
		this.qteRcpt = qteRcpt;
	}

	public LocalDate getDateLivAccept() {
		return dateLivAccept;
	}

	public void setDateLivAccept(LocalDate dateLivAccept) {
		this.dateLivAccept = dateLivAccept;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
