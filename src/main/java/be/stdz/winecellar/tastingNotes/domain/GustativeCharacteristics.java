package be.stdz.winecellar.tastingNotes.domain;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

@Entity
public class GustativeCharacteristics {
	private Accidity acidity;
	private Mellowness mellowness;
	private Tannines tannines;
	private Alcohol alcohol;

	public GustativeCharacteristics(Accidity acidity, Mellowness mellowness, Tannines tannines, Alcohol alcohol) {
		this.acidity = acidity;
		this.mellowness = mellowness;
		this.tannines = tannines;
		this.alcohol = alcohol;
	}

	public Accidity getAcidity() {
		return this.acidity;
	}

	public Mellowness getMellowness() {
		return this.mellowness;
	}

	public Tannines getTannines() {
		return this.tannines;
	}

	public Alcohol getAlcohol() {
		return this.alcohol;
	}

	public enum Accidity {
		LIGHT,
		MEDIUM,
		HIGH,
		DISTURBING
	}

	public enum Mellowness {
		LIGHT,
		FILMING,
		HALF_SWEET,
		SWEET
	}

	public enum Tannines {
		LIGHT,
		MEDIUM,
		HIGH,
		DISTURBING
	}

	public enum Alcohol {
		LIGHT,
		MEDIUM,
		HIGH,
		DISTURBING
	}

	@Override
	public String toString() {
		return "GustativeCharacteristics{" +
				"acidity=" + acidity +
				", mellowness=" + mellowness +
				", tannines=" + tannines +
				", alcohol=" + alcohol +
				'}';
	}
}
