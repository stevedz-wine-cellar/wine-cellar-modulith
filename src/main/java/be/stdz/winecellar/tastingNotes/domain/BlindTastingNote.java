package be.stdz.winecellar.tastingNotes.domain;

import java.util.UUID;

import org.springframework.cloud.gcp.data.datastore.core.mapping.DiscriminatorValue;

@DiscriminatorValue("blind_tasting")
public class BlindTastingNote extends TastingNote {

	public BlindTastingNote(VisualCharacteristics visualCharacteristics, OlfactiveCharacteristics olfactiveCharacteristics, GustativeCharacteristics gustativeCharacteristics, String generalDescription, String conclusion, int score) {
		super(visualCharacteristics, olfactiveCharacteristics, gustativeCharacteristics, generalDescription, conclusion, score);
	}
}
