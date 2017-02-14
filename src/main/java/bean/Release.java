package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * abstract class, uniting categories of releases
 * Created by Maryia_Chuhunova on 1/31/2017.
 */
public class Release implements Serializable {
    private String author;
    private String title;
    private String releaseDate;
    private String category;

    public Release() {
        category = "No category";
        author = "No author";
        title = "No title";
        releaseDate = "No date";
    }

    public Release(String category, String author, String title, String releaseDate) {
        this.category = category;
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}
