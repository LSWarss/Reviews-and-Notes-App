package dev.lswarss.ReviewsandNotesApp.commands;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class FilmForm {

    // == fields ==
    private Long id;
    private String title;
    private String director;
    private Date watchDate;
    private String review;
    private String notes;
}
