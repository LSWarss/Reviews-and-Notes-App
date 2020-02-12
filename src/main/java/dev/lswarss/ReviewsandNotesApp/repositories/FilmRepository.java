package dev.lswarss.ReviewsandNotesApp.repositories;

import dev.lswarss.ReviewsandNotesApp.DTO.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
