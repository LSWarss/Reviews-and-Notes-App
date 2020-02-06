package dev.lswarss.ReviewsandNotesApp.repositories;

import dev.lswarss.ReviewsandNotesApp.domain.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
