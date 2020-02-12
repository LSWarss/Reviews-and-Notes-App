package dev.lswarss.ReviewsandNotesApp.converters;

import dev.lswarss.ReviewsandNotesApp.commands.FilmForm;
import dev.lswarss.ReviewsandNotesApp.DTO.Film;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FilmFormToFilm implements Converter<FilmForm, Film> {

    @Override
    public Film convert(FilmForm filmForm) {
        Film film = new Film();
        if(filmForm.getId() != null && !StringUtils.isEmpty(filmForm.getId())){
            film.setId(filmForm.getId());
        }
        film.setDirector(filmForm.getDirector());
        film.setTitle(filmForm.getTitle());
        film.setWatchDate(filmForm.getWatchDate());
        film.setReview(filmForm.getReview());
        film.setNotes(filmForm.getNotes());

        return film;
    }
}
