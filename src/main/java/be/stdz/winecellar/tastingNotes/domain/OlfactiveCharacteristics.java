package be.stdz.winecellar.tastingNotes.domain;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

@Entity
public class OlfactiveCharacteristics {
	private Purity purity;
	private OlfactiveIntensity intensity;
	private List<Aroma> aromas;

	public OlfactiveCharacteristics(Purity purity, OlfactiveIntensity intensity, List<Aroma> aromas) {
		this.purity = purity;
		this.intensity = intensity;
		this.aromas = aromas;
	}

	public Purity getPurity() {
		return this.purity;
	}

	public OlfactiveIntensity getIntensity() {
		return this.intensity;
	}

	public List<Aroma> getAromas() {
		return this.aromas;
	}

	public enum Purity {
		PLEASANT,
		UNPLEASANT
	}

	public enum OlfactiveIntensity {
		LIGHT,
		MEDIUM,
		PRONOUNCED
	}

	public enum Aroma {
		FRUITY,
		FLORAL,
		VEGETAL,
		SPICY,
		EATERICAL,
		ANIMAL,
		WOODY,
		CHEMICAL,
		BURNING,
		BALMY
	}

	@Override
	public String toString() {
		return "OlfactiveCharacteristics{" +
				"pureness=" + purity +
				", intensity=" + intensity +
				", aromas=" + aromas +
				'}';
	}
}
