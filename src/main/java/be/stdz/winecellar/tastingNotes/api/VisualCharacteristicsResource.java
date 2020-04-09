package be.stdz.winecellar.tastingNotes.api;

import be.stdz.winecellar.tastingNotes.domain.VisualCharacteristics;
import be.stdz.winecellar.tastingNotes.domain.WineColor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static be.stdz.winecellar.tastingNotes.api.VisualCharacteristicsResource.WineColorResource.fromWineColor;
import static be.stdz.winecellar.tastingNotes.domain.VisualCharacteristics.*;
import static be.stdz.winecellar.tastingNotes.domain.WineColor.*;

public class VisualCharacteristicsResource {

	private String clarity;
	private String intensity;
	private String sparkle;
	private WineColorResource wineColor;

	@JsonCreator
	public VisualCharacteristicsResource(@JsonProperty String clarity,
										 @JsonProperty String intensity,
										 @JsonProperty String sparkle,
										 @JsonProperty WineColorResource wineColor) {
		this.clarity = clarity;
		this.intensity = intensity;
		this.sparkle = sparkle;
		this.wineColor = wineColor;
	}

	static VisualCharacteristicsResource fromVisualCharacteristic(VisualCharacteristics visualCharacteristics) {
		return new VisualCharacteristicsResource(
				visualCharacteristics.getClarity().toString(),
				visualCharacteristics.getIntensity().toString(),
				visualCharacteristics.getSparkle().toString(),
				fromWineColor(visualCharacteristics.getWineColor()));
	}

	VisualCharacteristics toVisualCharacteristics() {
		return new VisualCharacteristics(
				Clarity.valueOf(this.clarity),
				VisualIntensity.valueOf(this.intensity),
				Sparkle.valueOf(this.sparkle),
				fromColorAndSpecificColor(this.wineColor.getColor(), this.wineColor.getSpecificColor())
		);
	}

	public String getClarity() {
		return this.clarity;
	}

	public String getIntensity() {
		return this.intensity;
	}

	public String getSparkle() {
		return this.sparkle;
	}

	public WineColorResource getWineColor() {
		return this.wineColor;
	}

	static class WineColorResource {

		private String color;
		private String specificColor;

		@JsonCreator
		WineColorResource(@JsonProperty String color,
						  @JsonProperty String specificColor) {
			this.color = color;
			this.specificColor = specificColor;
		}

		static WineColorResource fromWineColor(WineColor wineColor) {
			return new WineColorResource(wineColor.getColor(), wineColor.getSpecificColor().toString());
		}

		public String getColor() {
			return this.color;
		}

		public String getSpecificColor() {
			return this.specificColor;
		}
	}

	@Override
	public String toString() {
		return "VisualCharacteristicsResource{" +
				"clarity='" + clarity + '\'' +
				", intensity='" + intensity + '\'' +
				", sparkle='" + sparkle + '\'' +
				", wineColor=" + wineColor +
				'}';
	}
}
