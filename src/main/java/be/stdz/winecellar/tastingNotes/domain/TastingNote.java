package be.stdz.winecellar.tastingNotes.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.cloud.gcp.data.datastore.core.mapping.DiscriminatorField;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.User;

@Entity(name = "tasting_notes")
@DiscriminatorField(field = "tasting_notes_type")
public abstract class TastingNote {

	@Id
	@Field(name = "tasting_note_id")
	private Long tastingNoteId;
	private VisualCharacteristics visualCharacteristics;
	private OlfactiveCharacteristics olfactiveCharacteristics;
	private GustativeCharacteristics gustativeCharacteristics;
	private String generalDescription;
	private String conclusion;
	private int score;

	@CreatedBy
	private User user;

	@CreatedDate
	public ZonedDateTime createdDate;

	@LastModifiedDate
	public ZonedDateTime modifiedDate;

	public TastingNote(VisualCharacteristics visualCharacteristics, OlfactiveCharacteristics olfactiveCharacteristics, GustativeCharacteristics gustativeCharacteristics, String generalDescription, String conclusion, int score) {
		this.visualCharacteristics = visualCharacteristics;
		this.olfactiveCharacteristics = olfactiveCharacteristics;
		this.gustativeCharacteristics = gustativeCharacteristics;
		this.generalDescription = generalDescription;
		this.conclusion = conclusion;
		this.score = score;
	}

	public Long getTastingNoteId() {
		return this.tastingNoteId;
	}

	public VisualCharacteristics getVisualCharacteristics() {
		return this.visualCharacteristics;
	}

	public OlfactiveCharacteristics getOlfactiveCharacteristics() {
		return this.olfactiveCharacteristics;
	}

	public GustativeCharacteristics getGustativeCharacteristics() {
		return this.gustativeCharacteristics;
	}

	public String getGeneralDescription() {
		return this.generalDescription;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public int getScore() {
		return this.score;
	}
}
