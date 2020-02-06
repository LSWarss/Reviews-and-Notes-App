package dev.lswarss.ReviewsandNotesApp.services;

import dev.lswarss.ReviewsandNotesApp.commands.FilmForm;
import dev.lswarss.ReviewsandNotesApp.converters.FilmFormToFilm;
import dev.lswarss.ReviewsandNotesApp.domain.Film;
import dev.lswarss.ReviewsandNotesApp.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;
    private FilmFormToFilm filmFormToFilm;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, FilmFormToFilm filmFormToFilm) {
        this.filmRepository = filmRepository;
        this.filmFormToFilm = filmFormToFilm;
    }

    @Override
    public List<Film> listAll() {
        List<Film> films = new ArrayList<>();
        filmRepository.findAll().forEach(films::add);
        return films;
    }

    @Override
    public Film getById(Long id) throws Exception {
        return filmRepository.findById(id).orElseThrow(() -> new Exception("No such film found"));
    }

    @Override
    public Film saveOrUpdate(Film film) {
        filmRepository.save(film);
        return film;
    }

    @Override
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film saveOrUpdateFilmForm(FilmForm filmForm) {
        Film savedFilm = saveOrUpdate(filmFormToFilm.convert(filmForm));
        System.out.println("Saved film id: " + savedFilm.getId());
        return savedFilm;
    }
}
