package be.stdz.winecellar.tastingNotes.api;

import java.util.List;

import be.stdz.winecellar.tastingNotes.domain.OlfactiveCharacteristics;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static be.stdz.winecellar.tastingNotes.domain.OlfactiveCharacteristics.*;
import static java.util.stream.Collectors.*;

public class OlfactiveCharacteristicsResource {

	private String pureness;
	private String intensity;
	private List<String> aromas;

	@JsonCreator
	public OlfactiveCharacteristicsResource(@JsonProperty String pureness,
											@JsonProperty String intensity,
											@JsonProperty List<String> aromas) {
		this.pureness = pureness;
		this.intensity = intensity;
		this.aromas = aromas;
	}

	static OlfactiveCharacteristicsResource fromOlfactiveCharacteristic(OlfactiveCharacteristics olfactiveCharacteristics) {
		return new OlfactiveCharacteristicsResource(
				olfactiveCharacteristics.getPurity().toString(),
				olfactiveCharacteristics.getIntensity().toString(),
				olfactiveCharacteristics.getAromas().stream().map(Aroma::toString).collect(toList()));
	}

	OlfactiveCharacteristics toOlfactiveCharacteristics() {
		return new OlfactiveCharacteristics(Purity.valueOf(this.pureness),
				OlfactiveIntensity.valueOf(this.intensity),
				aromas.stream().map(Aroma::valueOf).collect(toList()));
	}

	public String getPureness() {
		return this.pureness;
	}

	public String getIntensity() {
		return this.intensity;
	}

	public List<String> getAromas() {
		return this.aromas;
	}
}
