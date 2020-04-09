package be.stdz.winecellar.tastingNotes.infrastructure;

import java.util.UUID;

import be.stdz.winecellar.tastingNotes.domain.TastingNote;

import org.springframework.data.repository.CrudRepository;

public interface TastingNoteRepository extends CrudRepository<TastingNote, Long> {
}
