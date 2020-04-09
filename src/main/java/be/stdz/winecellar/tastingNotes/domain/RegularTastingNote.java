package be.stdz.winecellar.tastingNotes.domain;

import java.util.UUID;

import org.springframework.cloud.gcp.data.datastore.core.mapping.DiscriminatorValue;
import org.springframework.data.annotation.Reference;

@DiscriminatorValue("regular_tasting")
public class RegularTastingNote extends TastingNote {

	private String wineId;

	public RegularTastingNote(VisualCharacteristics visualCharacteristics, OlfactiveCharacteristics olfactiveCharacteristics, GustativeCharacteristics gustativeCharacteristics, String generalDescription, String conclusion, int score, String wineId) {
		super(visualCharacteristics, olfactiveCharacteristics, gustativeCharacteristics, generalDescription, conclusion, score);
		this.wineId = wineId;
	}

	public String getWineId() {
		return this.wineId;
	}
}
