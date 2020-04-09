package be.stdz.winecellar.tastingNotes.domain;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import be.stdz.winecellar.tastingNotes.infrastructure.TastingNoteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import static java.util.stream.Collectors.*;

@Transactional
@Service
public class TastingNotesApplicationService {

	private final TastingNoteRepository tastingNoteRepository;

	public TastingNotesApplicationService(TastingNoteRepository tastingNoteRepository) {
		this.tastingNoteRepository = tastingNoteRepository;
	}

	public TastingNote createTastingNote(TastingNote tastingNote) {
		return this.tastingNoteRepository.save(tastingNote);
	}

	public TastingNote retrieveTastingNoteById(Long tastingNoteId) {
		return this.tastingNoteRepository.findById(tastingNoteId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No Tasting Note found for %d", tastingNoteId)));
	}

	public List<TastingNote> retrieveAllTastingNotes() {
		Iterable<TastingNote> allTastingNotes = this.tastingNoteRepository.findAll();

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(allTastingNotes.iterator(), Spliterator.ORDERED), false).collect(toList());
	}
}
