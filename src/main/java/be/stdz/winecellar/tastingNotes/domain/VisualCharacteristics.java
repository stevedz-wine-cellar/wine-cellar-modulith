package be.stdz.winecellar.tastingNotes.domain;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

@Entity
public class VisualCharacteristics {
	private Clarity clarity;
	private VisualIntensity intensity;
	private Sparkle sparkle;
	private WineColor wineColor;

	public VisualCharacteristics(Clarity clarity, VisualIntensity intensity, Sparkle sparkle, WineColor wineColor) {
		this.clarity = clarity;
		this.intensity = intensity;
		this.sparkle = sparkle;
		this.wineColor = wineColor;
	}

	public Clarity getClarity() {
		return this.clarity;
	}

	public VisualIntensity getIntensity() {
		return this.intensity;
	}

	public Sparkle getSparkle() {
		return this.sparkle;
	}

	public WineColor getWineColor() {
		return this.wineColor;
	}

	public enum Sparkle {
		FINE,
		COARSE,
		CORONA
	}

	public enum Clarity {
		CLEAR,
		CLOUDY
	}

	public enum VisualIntensity {
		LIGHT,
		MEDIUM,
		DEEP
	}
}
