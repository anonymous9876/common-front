package name.anonymous.common.front.app.heros.dto.table.embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"numArtFou", "descriptionArt"})
public class Product {
	/**
	 * Référence du numéro d'article fournisseur
	 */
	private String numArtFou;
	/**
	 * Libellé de l'article non traduit
	 */
	private String descriptionArt;

	public String getNumArtFou() {
		return numArtFou;
	}
	public void setNumArtFou(String numArtFou) {
		this.numArtFou = numArtFou;
	}
	public String getDescriptionArt() {
		return descriptionArt;
	}
	public void setDescriptionArt(String descriptionArt) {
		this.descriptionArt = descriptionArt;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
