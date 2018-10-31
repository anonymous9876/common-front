/*
 * heros API
 * heros
 *
 * OpenAPI spec version: heros
 * Contact: email@a.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Address;
import io.swagger.client.model.Person;
import io.swagger.client.model.Product;
import java.util.UUID;
import org.threeten.bp.LocalDate;

/**
 * ProductLineItemDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-31T17:38:54.800+01:00")
public class ProductLineItemDto {
  @JsonProperty("buyer")
  private Person buyer = null;

  @JsonProperty("dateLivAccept")
  private LocalDate dateLivAccept = null;

  @JsonProperty("dateLivAnnon")
  private LocalDate dateLivAnnon = null;

  @JsonProperty("dateLivSouh")
  private LocalDate dateLivSouh = null;

  @JsonProperty("delivryAddress")
  private Address delivryAddress = null;

  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("mntLig")
  private Double mntLig = null;

  @JsonProperty("numLig")
  private Integer numLig = null;

  @JsonProperty("product")
  private Product product = null;

  @JsonProperty("pu")
  private Double pu = null;

  @JsonProperty("qte")
  private Integer qte = null;

  @JsonProperty("qteRcpt")
  private Integer qteRcpt = null;

  @JsonProperty("typeLig")
  private String typeLig = null;

  @JsonProperty("unite")
  private String unite = null;

  public ProductLineItemDto buyer(Person buyer) {
    this.buyer = buyer;
    return this;
  }

   /**
   * Get buyer
   * @return buyer
  **/
  @ApiModelProperty(value = "")
  public Person getBuyer() {
    return buyer;
  }

  public void setBuyer(Person buyer) {
    this.buyer = buyer;
  }

  public ProductLineItemDto dateLivAccept(LocalDate dateLivAccept) {
    this.dateLivAccept = dateLivAccept;
    return this;
  }

   /**
   * Get dateLivAccept
   * @return dateLivAccept
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDateLivAccept() {
    return dateLivAccept;
  }

  public void setDateLivAccept(LocalDate dateLivAccept) {
    this.dateLivAccept = dateLivAccept;
  }

  public ProductLineItemDto dateLivAnnon(LocalDate dateLivAnnon) {
    this.dateLivAnnon = dateLivAnnon;
    return this;
  }

   /**
   * Get dateLivAnnon
   * @return dateLivAnnon
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDateLivAnnon() {
    return dateLivAnnon;
  }

  public void setDateLivAnnon(LocalDate dateLivAnnon) {
    this.dateLivAnnon = dateLivAnnon;
  }

  public ProductLineItemDto dateLivSouh(LocalDate dateLivSouh) {
    this.dateLivSouh = dateLivSouh;
    return this;
  }

   /**
   * Get dateLivSouh
   * @return dateLivSouh
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDateLivSouh() {
    return dateLivSouh;
  }

  public void setDateLivSouh(LocalDate dateLivSouh) {
    this.dateLivSouh = dateLivSouh;
  }

  public ProductLineItemDto delivryAddress(Address delivryAddress) {
    this.delivryAddress = delivryAddress;
    return this;
  }

   /**
   * Get delivryAddress
   * @return delivryAddress
  **/
  @ApiModelProperty(value = "")
  public Address getDelivryAddress() {
    return delivryAddress;
  }

  public void setDelivryAddress(Address delivryAddress) {
    this.delivryAddress = delivryAddress;
  }

  public ProductLineItemDto id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ProductLineItemDto mntLig(Double mntLig) {
    this.mntLig = mntLig;
    return this;
  }

   /**
   * Get mntLig
   * @return mntLig
  **/
  @ApiModelProperty(value = "")
  public Double getMntLig() {
    return mntLig;
  }

  public void setMntLig(Double mntLig) {
    this.mntLig = mntLig;
  }

  public ProductLineItemDto numLig(Integer numLig) {
    this.numLig = numLig;
    return this;
  }

   /**
   * Get numLig
   * @return numLig
  **/
  @ApiModelProperty(value = "")
  public Integer getNumLig() {
    return numLig;
  }

  public void setNumLig(Integer numLig) {
    this.numLig = numLig;
  }

  public ProductLineItemDto product(Product product) {
    this.product = product;
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(value = "")
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ProductLineItemDto pu(Double pu) {
    this.pu = pu;
    return this;
  }

   /**
   * Get pu
   * @return pu
  **/
  @ApiModelProperty(value = "")
  public Double getPu() {
    return pu;
  }

  public void setPu(Double pu) {
    this.pu = pu;
  }

  public ProductLineItemDto qte(Integer qte) {
    this.qte = qte;
    return this;
  }

   /**
   * Get qte
   * @return qte
  **/
  @ApiModelProperty(value = "")
  public Integer getQte() {
    return qte;
  }

  public void setQte(Integer qte) {
    this.qte = qte;
  }

  public ProductLineItemDto qteRcpt(Integer qteRcpt) {
    this.qteRcpt = qteRcpt;
    return this;
  }

   /**
   * Get qteRcpt
   * @return qteRcpt
  **/
  @ApiModelProperty(value = "")
  public Integer getQteRcpt() {
    return qteRcpt;
  }

  public void setQteRcpt(Integer qteRcpt) {
    this.qteRcpt = qteRcpt;
  }

  public ProductLineItemDto typeLig(String typeLig) {
    this.typeLig = typeLig;
    return this;
  }

   /**
   * Get typeLig
   * @return typeLig
  **/
  @ApiModelProperty(value = "")
  public String getTypeLig() {
    return typeLig;
  }

  public void setTypeLig(String typeLig) {
    this.typeLig = typeLig;
  }

  public ProductLineItemDto unite(String unite) {
    this.unite = unite;
    return this;
  }

   /**
   * Get unite
   * @return unite
  **/
  @ApiModelProperty(value = "")
  public String getUnite() {
    return unite;
  }

  public void setUnite(String unite) {
    this.unite = unite;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductLineItemDto productLineItemDto = (ProductLineItemDto) o;
    return Objects.equals(this.buyer, productLineItemDto.buyer) &&
        Objects.equals(this.dateLivAccept, productLineItemDto.dateLivAccept) &&
        Objects.equals(this.dateLivAnnon, productLineItemDto.dateLivAnnon) &&
        Objects.equals(this.dateLivSouh, productLineItemDto.dateLivSouh) &&
        Objects.equals(this.delivryAddress, productLineItemDto.delivryAddress) &&
        Objects.equals(this.id, productLineItemDto.id) &&
        Objects.equals(this.mntLig, productLineItemDto.mntLig) &&
        Objects.equals(this.numLig, productLineItemDto.numLig) &&
        Objects.equals(this.product, productLineItemDto.product) &&
        Objects.equals(this.pu, productLineItemDto.pu) &&
        Objects.equals(this.qte, productLineItemDto.qte) &&
        Objects.equals(this.qteRcpt, productLineItemDto.qteRcpt) &&
        Objects.equals(this.typeLig, productLineItemDto.typeLig) &&
        Objects.equals(this.unite, productLineItemDto.unite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyer, dateLivAccept, dateLivAnnon, dateLivSouh, delivryAddress, id, mntLig, numLig, product, pu, qte, qteRcpt, typeLig, unite);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductLineItemDto {\n");
    
    sb.append("    buyer: ").append(toIndentedString(buyer)).append("\n");
    sb.append("    dateLivAccept: ").append(toIndentedString(dateLivAccept)).append("\n");
    sb.append("    dateLivAnnon: ").append(toIndentedString(dateLivAnnon)).append("\n");
    sb.append("    dateLivSouh: ").append(toIndentedString(dateLivSouh)).append("\n");
    sb.append("    delivryAddress: ").append(toIndentedString(delivryAddress)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mntLig: ").append(toIndentedString(mntLig)).append("\n");
    sb.append("    numLig: ").append(toIndentedString(numLig)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    pu: ").append(toIndentedString(pu)).append("\n");
    sb.append("    qte: ").append(toIndentedString(qte)).append("\n");
    sb.append("    qteRcpt: ").append(toIndentedString(qteRcpt)).append("\n");
    sb.append("    typeLig: ").append(toIndentedString(typeLig)).append("\n");
    sb.append("    unite: ").append(toIndentedString(unite)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

