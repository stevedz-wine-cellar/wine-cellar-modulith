package be.stdz.winecellar.tastingNotes.domain;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

@Entity
public class WineColor {

	private String color;
	private SpecificColor specificColor;

	public WineColor(String color, SpecificColor specificColor) {
		this.color = color;
		this.specificColor = specificColor;
	}

	public String getColor() {
		return this.color;
	}

	public SpecificColor getSpecificColor() {
		return this.specificColor;
	}

	public static WineColor fromColorAndSpecificColor(String color, String specificColor) {
		return new WineColor(color, SpecificColor.valueOf(specificColor));
	}

	public enum SpecificColor {
		CHERRY,
		GRANATE,
		PURPLE,
		BROWN_RED,
		LIGHT_ROSE,
		SALMON_ROSE,
		ORANGE,
		PALE_YELLOW,
		GOLD_YELLOW,
		AMBER,
		;
	}
}
