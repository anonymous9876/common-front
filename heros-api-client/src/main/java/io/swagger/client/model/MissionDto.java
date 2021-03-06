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
import io.swagger.client.model.HeroDto;
import io.swagger.client.model.MissionState;
import io.swagger.client.model.Money;
import io.swagger.client.model.Version;
import java.util.UUID;

/**
 * MissionDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-31T17:38:54.800+01:00")
public class MissionDto {
  @JsonProperty("hero")
  private HeroDto hero = null;

  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("num")
  private String num = null;

  @JsonProperty("state")
  private MissionState state = null;

  @JsonProperty("totalAmount")
  private Money totalAmount = null;

  @JsonProperty("version")
  private Version version = null;

  public MissionDto hero(HeroDto hero) {
    this.hero = hero;
    return this;
  }

   /**
   * Get hero
   * @return hero
  **/
  @ApiModelProperty(value = "")
  public HeroDto getHero() {
    return hero;
  }

  public void setHero(HeroDto hero) {
    this.hero = hero;
  }

  public MissionDto id(UUID id) {
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

  public MissionDto num(String num) {
    this.num = num;
    return this;
  }

   /**
   * Get num
   * @return num
  **/
  @ApiModelProperty(value = "")
  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public MissionDto state(MissionState state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public MissionState getState() {
    return state;
  }

  public void setState(MissionState state) {
    this.state = state;
  }

  public MissionDto totalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

   /**
   * Get totalAmount
   * @return totalAmount
  **/
  @ApiModelProperty(value = "")
  public Money getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
  }

  public MissionDto version(Version version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public Version getVersion() {
    return version;
  }

  public void setVersion(Version version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MissionDto missionDto = (MissionDto) o;
    return Objects.equals(this.hero, missionDto.hero) &&
        Objects.equals(this.id, missionDto.id) &&
        Objects.equals(this.num, missionDto.num) &&
        Objects.equals(this.state, missionDto.state) &&
        Objects.equals(this.totalAmount, missionDto.totalAmount) &&
        Objects.equals(this.version, missionDto.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hero, id, num, state, totalAmount, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MissionDto {\n");
    
    sb.append("    hero: ").append(toIndentedString(hero)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    num: ").append(toIndentedString(num)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

