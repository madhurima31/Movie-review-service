

/**
 * @author Madhurima Mondal
 * Movie POJO with all the properties of Movie
 */
public class Movie {

    private String movieName;
    private Integer releaseYear;
    private String genre;
    private Integer totalRating;
    private Integer criticRating;
    private Integer totalNoOfUsersReviewed;



    public Movie(String movieName, Integer releaseYear, String genre){
        this.movieName= movieName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.totalRating=0;
        this.criticRating=0;
        this.totalNoOfUsersReviewed=0;
    }

    public void addMovie(String movieName, Integer releaseYear, String genre){
        this.movieName= movieName;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTotalRating() {
        return this.totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getCriticRating() {
        return this.criticRating;
    }

    public void setCriticRating(Integer criticRating) {
        this.criticRating = criticRating;
    }

    public Integer getTotalNoOfUsersReviewed() {
        return this.totalNoOfUsersReviewed;
    }

    public void setTotalNoOfUsersReviewed(Integer totalNoOfUsersReviewed) {
        this.totalNoOfUsersReviewed = totalNoOfUsersReviewed;
    }
    

}