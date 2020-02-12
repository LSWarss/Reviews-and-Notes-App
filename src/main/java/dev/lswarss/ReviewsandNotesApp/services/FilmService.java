package dev.lswarss.ReviewsandNotesApp.services;

import dev.lswarss.ReviewsandNotesApp.commands.FilmForm;
import dev.lswarss.ReviewsandNotesApp.DTO.Film;

import java.util.List;

public interface FilmService {

    List<Film> listAll();

    Film getById(Long id) throws Exception;

    Film saveOrUpdate(Film film);

    void delete(Long id);

    Film saveOrUpdateFilmForm(FilmForm filmForm);
}
