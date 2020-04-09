package be.stdz.winecellar.tastingNotes.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import be.stdz.winecellar.tastingNotes.domain.TastingNote;
import be.stdz.winecellar.tastingNotes.domain.TastingNotesApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static be.stdz.winecellar.tastingNotes.api.TastingNoteResource.*;
import static java.util.stream.Collectors.*;

@RestController
@RequestMapping("/tasting-notes")
public class TastingNotesController {

	private static final Logger logger = LoggerFactory.getLogger(TastingNotesController.class);

	private TastingNotesApplicationService tastingNotesApplicationService;

	public TastingNotesController(TastingNotesApplicationService tastingNotesApplicationService) {
		this.tastingNotesApplicationService = tastingNotesApplicationService;
	}

	@GetMapping("/")
	public ResponseEntity<List<TastingNoteResource>> getAllTastingNotes(Authentication authentication) {
		//sub is the globally unique user identifier in the google realm
		String sub = (String)(((JwtAuthenticationToken) authentication).getToken()).getClaims().get("sub");

		List<TastingNote> tastingNotes = this.tastingNotesApplicationService.retrieveAllTastingNotes();

		return ResponseEntity.of(Optional.of(tastingNotes.stream().map(TastingNoteResource::fromTastingNote).collect(toList())));
	}

	@GetMapping("/{tastingNoteId}")
	public ResponseEntity<TastingNoteResource> getTastingNoteById(@PathVariable Long tastingNoteId) {
		return ResponseEntity.ok(TastingNoteResource.fromTastingNote(this.tastingNotesApplicationService.retrieveTastingNoteById(tastingNoteId)));
	}

	@PostMapping("/")
	public ResponseEntity<TastingNoteResource> createTastingNote(@RequestBody TastingNoteResource tastingNoteResource, UriComponentsBuilder uriComponentsBuilder) {
		//TODO create TastingNote for the currently logged in user. Use Authentication claims sub property!!

		TastingNote createdTastingNote = this.tastingNotesApplicationService.createTastingNote(tastingNoteResource.toTastingNote());

		UriComponents uriComponents = uriComponentsBuilder.path("/tasting-notes/{id}").buildAndExpand(createdTastingNote.getTastingNoteId());

		return ResponseEntity.created(uriComponents.toUri()).body(TastingNoteResource.fromTastingNote(createdTastingNote));
	}
}
