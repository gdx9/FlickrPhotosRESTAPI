package manor9421.com.flickrphoto;

/**
 * Created by manor on 9/21/16.
 */
public class Movie {

    private int imageRes;
    private String name;
    private int year;
    private String director;
    private String description;

    public Movie(int imageRes, String name, int year, String director, String description) {
        this.imageRes = imageRes;
        this.name = name;
        this.year = year;
        this.director = director;
        this.description = description;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
