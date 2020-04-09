package be.stdz.winecellar.tastingNotes.api;

import be.stdz.winecellar.tastingNotes.domain.BlindTastingNote;
import be.stdz.winecellar.tastingNotes.domain.RegularTastingNote;
import be.stdz.winecellar.tastingNotes.domain.TastingNote;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static be.stdz.winecellar.tastingNotes.api.GustativeCharacteristicsResource.*;
import static be.stdz.winecellar.tastingNotes.api.OlfactiveCharacteristicsResource.fromOlfactiveCharacteristic;
import static be.stdz.winecellar.tastingNotes.api.VisualCharacteristicsResource.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TastingNoteResource {

	private Long tastingNoteId;
	private Boolean blindTasting;
	private VisualCharacteristicsResource visualCharacteristicsResource;
	private OlfactiveCharacteristicsResource olfactiveCharacteristicsResource;
	private GustativeCharacteristicsResource gustativeCharacteristicsResource;
	private String generalDescription;
	private String conclusion;
	private Integer score;
	private String wineId;

	@JsonCreator
	public TastingNoteResource(@JsonProperty Long tastingNoteId,
							   @JsonProperty boolean blindTasting,
							   @JsonProperty("visualCharacteristics") VisualCharacteristicsResource visualCharacteristicsResource,
							   @JsonProperty("olfactiveCharacteristics") OlfactiveCharacteristicsResource olfactiveCharacteristicsResource,
							   @JsonProperty("gustativeCharacteristics") GustativeCharacteristicsResource gustativeCharacteristicsResource,
							   @JsonProperty String generalDescription,
							   @JsonProperty String conclusion,
							   @JsonProperty int score,
							   @JsonProperty String wineId) {
		this.tastingNoteId = tastingNoteId;
		this.blindTasting = blindTasting;
		this.visualCharacteristicsResource = visualCharacteristicsResource;
		this.olfactiveCharacteristicsResource = olfactiveCharacteristicsResource;
		this.gustativeCharacteristicsResource = gustativeCharacteristicsResource;
		this.generalDescription = generalDescription;
		this.conclusion = conclusion;
		this.score = score;
		this.wineId = wineId;
	}

	public static TastingNoteResource fromTastingNote(TastingNote tastingNote) {
		String wineId = "";
		if (tastingNote instanceof RegularTastingNote) {
			wineId = ((RegularTastingNote) tastingNote).getWineId();
		}

		return new TastingNoteResource(tastingNote.getTastingNoteId(),
				(tastingNote instanceof BlindTastingNote),
				fromVisualCharacteristic(tastingNote.getVisualCharacteristics()),
				fromOlfactiveCharacteristic(tastingNote.getOlfactiveCharacteristics()),
				fromGustativeCharacteristics(tastingNote.getGustativeCharacteristics()),
				tastingNote.getGeneralDescription(),
				tastingNote.getConclusion(),
				tastingNote.getScore(),
				wineId);
	}

	public TastingNote toTastingNote() {
		TastingNote tastingNote = null;
		if (this.blindTasting) {
			tastingNote = new BlindTastingNote(this.visualCharacteristicsResource.toVisualCharacteristics(),
					this.olfactiveCharacteristicsResource.toOlfactiveCharacteristics(),
					this.gustativeCharacteristicsResource.toGustativeCharacteristics(),
					this.generalDescription,
					this.conclusion,
					this.score);
		} else {
			tastingNote = new RegularTastingNote(this.visualCharacteristicsResource.toVisualCharacteristics(),
					this.olfactiveCharacteristicsResource.toOlfactiveCharacteristics(),
					this.gustativeCharacteristicsResource.toGustativeCharacteristics(),
					this.generalDescription,
					this.conclusion,
					this.score,
					this.wineId);
		}
		return tastingNote;
	}

	public Long getTastingNoteId() {
		return this.tastingNoteId;
	}

	public void setTastingNoteId(Long tastingNoteId) {
		this.tastingNoteId = tastingNoteId;
	}

	public Boolean getBlindTasting() {
		return this.blindTasting;
	}

	public void setBlindTasting(Boolean blindTasting) {
		this.blindTasting = blindTasting;
	}

	public VisualCharacteristicsResource getVisualCharacteristicsResource() {
		return this.visualCharacteristicsResource;
	}

	public void setVisualCharacteristicsResource(VisualCharacteristicsResource visualCharacteristicsResource) {
		this.visualCharacteristicsResource = visualCharacteristicsResource;
	}

	public OlfactiveCharacteristicsResource getOlfactiveCharacteristicsResource() {
		return this.olfactiveCharacteristicsResource;
	}

	public void setOlfactiveCharacteristicsResource(OlfactiveCharacteristicsResource olfactiveCharacteristicsResource) {
		this.olfactiveCharacteristicsResource = olfactiveCharacteristicsResource;
	}

	public GustativeCharacteristicsResource getGustativeCharacteristicsResource() {
		return this.gustativeCharacteristicsResource;
	}

	public void setGustativeCharacteristicsResource(GustativeCharacteristicsResource gustativeCharacteristicsResource) {
		this.gustativeCharacteristicsResource = gustativeCharacteristicsResource;
	}

	public String getGeneralDescription() {
		return this.generalDescription;
	}

	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getWineId() {
		return this.wineId;
	}

	public void setWineId(String wineId) {
		this.wineId = wineId;
	}

	@Override
	public String toString() {
		return "TastingNoteResource{" +
				"tastingNoteId=" + tastingNoteId +
				", blindTasting=" + blindTasting +
				", visualCharacteristicsResource=" + visualCharacteristicsResource +
				", olfactiveCharacteristicsResource=" + olfactiveCharacteristicsResource +
				", gustativeCharacteristicsResource=" + gustativeCharacteristicsResource +
				", generalDescription='" + generalDescription + '\'' +
				", conclusion='" + conclusion + '\'' +
				", score=" + score +
				", wineId='" + wineId + '\'' +
				'}';
	}
}
