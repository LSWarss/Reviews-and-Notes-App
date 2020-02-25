package dev.lswarss.ReviewsandNotesApp.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;

import static dev.lswarss.ReviewsandNotesApp.helpClasses.JsonReader.readJsonFromUrl;


@Entity
public class Film {

    // == fields ==

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String director;
    @Getter
    @Setter
    private Date watchDate;
    @Getter
    @Setter
    private String review;
    @Getter
    @Setter
    private String notes;

    private String poster;

    public String getPoster() throws IOException, JSONException {
        setPoster();
        return poster;
    }

    public void setPoster() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("http://www.omdbapi.com/?apikey=bb798bb3&s="+getTitle());
        System.out.println(json.toString());
        JSONArray json1 = json.getJSONArray("Search");
        JSONObject json_poster = json1.getJSONObject(0);
        String poster = json_poster.get("Poster").toString();
        this.poster = poster;
    }
}
