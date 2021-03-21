import java.util.HashMap;

/**
 * @author Madhurima Mondal
 * Main class in used for input and running the MovieServices methods
 */

public class Main {

    public static void main(String[] args) throws Exception {

        MovieServices movieServices = new MovieServices();

        movieServices.reviewsMap = new HashMap<>();
        movieServices.nameToMovieMap = new HashMap<>();
        movieServices.nameToUserMap = new HashMap<>();


        String[] movieNames = {"Don", "Tiger", "Padmaavat","LunchBox","Guru", "Metro"};
        Integer[] releaseYears = {2006,2008,2006,2021,2006,2006};
        String[] genres = {"Action & Comedy", "Drama", "Comedy","Drama","Drama", "Romance"};
        String[] users = {"SRK","Salman","Deepika"};


        // input movies
        for(int index=0;index<movieNames.length;index++){
            String movieName = movieNames[index];
            Integer year = releaseYears[index];
            String genre = genres[index];
            movieServices.addMovie(movieName, year, genre);
            }
            System.out.println();

        // input users
        for(int index=0;index<users.length;index++){
                String userName = users[index];
                movieServices.addUser(userName);
            }
            System.out.println();


        // input reviews
        movieServices.addReview("SRK", "Don", 2);
        movieServices.addReview("SRK", "Padmaavat", 8);
        movieServices.addReview("Salman", "Don", 5);
        movieServices.addReview("Deepika", "Don", 9);
        movieServices.addReview("Deepika", "Guru", 6);
        movieServices.addReview("Deepika", "LunchBox", 5);
        movieServices.addReview("SRK", "Tiger", 5);
        movieServices.addReview("SRK", "Metro", 7);
        movieServices.addReview("Deepika", "Tiger", 1);

        // uncomment the following block if you want to view the test case for exception for "multiple reviews not allowed"
        /*
        movieServices.addReview("SRK", "Don", 10);   // Exception should occur as multiple reviews not allowed
        */

         // uncomment the following block if you want to view the test case for exception for "Movie yet to be released"
        /*
        movieServices.addReview("SRK", "Black Widow", 10);   // Exception should occur as Movie yet to be released
        */
        
        System.out.println();

        int n=2 ;
        System.out.println("Top "+ n + " movies by critic scores : "+ movieServices.getTopNMoviesByCriticScores(n).toString());
        System.out.println();

        Integer yearOfRelease = 2006;
        System.out.println("Average review score in year "+ yearOfRelease + " is : "+ movieServices.getAvgScoreForYearOfRelease(yearOfRelease));
        System.out.println();
        
        String movie = "Don";
        System.out.println("Average review score for "+ movie + " is : "+ movieServices.getAverageScoreForMovie(movie));
        

    }
    
}
