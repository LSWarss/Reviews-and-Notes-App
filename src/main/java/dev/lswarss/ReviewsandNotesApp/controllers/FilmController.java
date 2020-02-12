package dev.lswarss.ReviewsandNotesApp.controllers;

import dev.lswarss.ReviewsandNotesApp.commands.FilmForm;
import dev.lswarss.ReviewsandNotesApp.converters.FilmToFilmForm;
import dev.lswarss.ReviewsandNotesApp.DTO.Film;
import dev.lswarss.ReviewsandNotesApp.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class FilmController {


    private FilmService filmService;
    private FilmToFilmForm filmToFilmForm;


    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @Autowired
    public void setFilmToFilmForm(FilmToFilmForm filmToFilmForm){
        this.filmToFilmForm = filmToFilmForm;
    }

    @RequestMapping("/")
    public String redirectToList()
    {
        return "redirect:/film/list";
    }

    @RequestMapping({"/film/list", "/film"})
    public String listFilms(Model model){
        model.addAttribute("films", filmService.listAll());
        return "film/list";
    }

    @RequestMapping("film/show/{id}")
    public String getFilm(@PathVariable String id, Model model) throws Exception {
        model.addAttribute("film", filmService.getById(Long.valueOf(id)));
        return "film/show";
    }

    @RequestMapping("film/edit/{id}")
    public String editFilm(@PathVariable String id, Model model) throws Exception {
        Film film = filmService.getById(Long.valueOf(id));
        FilmForm filmForm = filmToFilmForm.convert(film);
        model.addAttribute("filmForm", filmForm);
        return "film/filmform";
    }

    @RequestMapping("film/new")
    public String newFilm(Model model)
    {
        model.addAttribute("filmForm", new FilmForm());
        return "film/filmform";
    }

    @RequestMapping(value = "/film", method = RequestMethod.POST)
    public String saveOrUpdateFilm(@Valid FilmForm filmForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "film/filmform";
        }

        Film savedFilm = filmService.saveOrUpdateFilmForm(filmForm);

        return "redirect:/film/show/" + savedFilm.getId();
    }

    @RequestMapping("/film/delete/{id}")
    public String delete(@PathVariable String id){
        filmService.delete(Long.valueOf(id));
        return "redirect:/film/list";
    }





}
