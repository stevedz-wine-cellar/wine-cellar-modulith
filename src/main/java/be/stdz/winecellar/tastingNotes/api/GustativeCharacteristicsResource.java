package be.stdz.winecellar.tastingNotes.api;

import be.stdz.winecellar.tastingNotes.domain.GustativeCharacteristics;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GustativeCharacteristicsResource {

	private String acidity;
	private String mellowness;
	private String tannines;
	private String alcohol;

	@JsonCreator
	public GustativeCharacteristicsResource(@JsonProperty String acidity,
											@JsonProperty String mellowness,
											@JsonProperty String tannines,
											@JsonProperty String alcohol) {
		this.acidity = acidity;
		this.mellowness = mellowness;
		this.tannines = tannines;
		this.alcohol = alcohol;
	}

	static GustativeCharacteristicsResource fromGustativeCharacteristics(GustativeCharacteristics gustativeCharacteristics) {
		return new GustativeCharacteristicsResource(
				gustativeCharacteristics.getAcidity().toString(),
				gustativeCharacteristics.getMellowness().toString(),
				gustativeCharacteristics.getTannines().toString(),
				gustativeCharacteristics.getAlcohol().toString()
		);
	}

	GustativeCharacteristics toGustativeCharacteristics() {
		return new GustativeCharacteristics(GustativeCharacteristics.Accidity.valueOf(this.acidity),
				GustativeCharacteristics.Mellowness.valueOf(this.mellowness),
				GustativeCharacteristics.Tannines.valueOf(this.tannines),
				GustativeCharacteristics.Alcohol.valueOf(this.alcohol));
	}

	public String getAcidity() {
		return this.acidity;
	}

	public String getMellowness() {
		return this.mellowness;
	}

	public String getTannines() {
		return this.tannines;
	}

	public String getAlcohol() {
		return this.alcohol;
	}
}
