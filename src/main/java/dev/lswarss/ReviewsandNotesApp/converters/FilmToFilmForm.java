package dev.lswarss.ReviewsandNotesApp.converters;

import dev.lswarss.ReviewsandNotesApp.commands.FilmForm;
import dev.lswarss.ReviewsandNotesApp.domain.Film;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilmToFilmForm implements Converter<Film, FilmForm > {
    @Override
    public FilmForm convert(Film film) {
        FilmForm filmForm = new FilmForm();
        filmForm.setId(film.getId());
        filmForm.setTitle(film.getTitle());
        filmForm.setDirector(film.getDirector());
        filmForm.setWatchDate(film.getWatchDate());
        filmForm.setReview(film.getReview());
        filmForm.setNotes(film.getNotes());
        return filmForm;
    }
}
