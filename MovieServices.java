import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/** 
@author Madhurima Mondal

This class implements the following functionalities:
* Adding users and movies.
* User to review a movie.
* List of top n movies by total review score by ‘critics’ in a particular genre.
* Average review score in a particular year of release.
*Average review score for a particular movie.

*/
public class MovieServices {
    Map<Movie, Map<User, Integer>> reviewsMap ;
    Map<String, Movie> nameToMovieMap ;
    Map<String, User> nameToUserMap ;

    Map<Integer,List<Movie>> yearToMoviesMap = new HashMap<>();

    /*
     ** This method adds a new User  
     */
    public void addUser(String userName) throws Exception{
        if(nameToUserMap.containsKey(userName)){
            throw new Exception("User already exists with same name.");
        }
        User user = new User(userName);
        nameToUserMap.put(userName,user);
        System.out.println("User "+ userName + " added.");
    }

    /*
     ** This method adds new a new Movie  
     */
    public void addMovie(String movieName, Integer year, String genre) throws Exception{
        if(nameToMovieMap.containsKey(movieName)){
            throw new Exception("Movie already exists with same name.");
        }
        Movie movie = new Movie(movieName,year,genre);
        nameToMovieMap.put(movieName, movie);
        reviewsMap.put(movie,new HashMap<User,Integer>());
        if(yearToMoviesMap.get(year)==null){
            yearToMoviesMap.put(year, new ArrayList<>());
        }
        yearToMoviesMap.get(year).add(movie);
        System.out.println("Movie "+ movieName + " released in Year "+ year + " for Genres "+ genre + " added.");
   
    }


    /*
     ** This method adds a new review given by a User  
     */
    public void addReview(String userName, String movieName, Integer rating) throws Exception{

        // this.reviewsMap = reviewsMap;
        Movie movie = nameToMovieMap.get(movieName);
        User user = nameToUserMap.get(userName);

        if(reviewsMap.get(movie)!=null){
            Map<User, Integer> userToScoreMap = reviewsMap.get(movie);
            if(userToScoreMap.get(user)!=null){
                // user has already reviewed the movie
                throw new Exception("Multiple Reviews not allowed");
            }else{
               
                Integer userRating = rating;
                Integer currnoOfReviews = user.getNoOfReviews()+1;
                user.setNoOfReviews(currnoOfReviews);
                if(currnoOfReviews>3){
                    //promote user to critic
                    if(!user.getIsCritic()){
                        promoteUserToCritic(user);
                    }           
                    userRating *= 2; 
                    movie.setCriticRating(movie.getCriticRating()+userRating);
                }
                userToScoreMap.put(user,userRating);
                movie.setTotalRating(movie.getTotalRating()+userRating);
                movie.setTotalNoOfUsersReviewed(movie.getTotalNoOfUsersReviewed()+1);
                
            }
        }else{
            throw new Exception("Movie yet to be released");
        }
        System.out.println("Review for movie "+ movieName + " by " + userName +" with rating "+rating + " added."); 
    }


    /*
    ** This method promotes user to critic when number of reviews is more than 3
    */
    public void promoteUserToCritic(User user){
        user.setIsCritic(true);
        System.out.println(user.getUserName() + " promoted to Critic now.");
    }

/*
** This method returns the list of top n movies by total review score by ‘critics’ in a particular genre.
*/
  public List<String> getTopNMoviesByCriticScores(Integer n)
  {
    List<String> topMovies = new ArrayList<>();

    // priority queue to arrange movies in descending order of their critic scores
    PriorityQueue<Movie> maxCriticScoreMovies = new PriorityQueue<>(
        (movie1,movie2)->movie2.getCriticRating().compareTo(movie1.getCriticRating()));

        for(Movie movie: nameToMovieMap.values()){
            maxCriticScoreMovies.add(movie);
        }
        while(n!=0){
            Movie currentMovie = maxCriticScoreMovies.peek();

            // if critic rating =0 i.e movie is not rated by any critic , then we donot include it in the list
            if(currentMovie!=null && currentMovie.getMovieName()!=null && currentMovie.getCriticRating()!=0)
                topMovies.add(maxCriticScoreMovies.poll().getMovieName());
            n--;
        }

    return topMovies;
}

/*
** This method returns the average review score in a particular year of release.
*/
  public double getAvgScoreForYearOfRelease(Integer yearOfRelease) throws Exception
  {
  
      List<Movie> listOfMovies = yearToMoviesMap.get(yearOfRelease);
      if(listOfMovies==null)
      {
          throw new Exception("No movie released this year");
      }

        double averageScore =0;
        Integer totalScore = 0;
        Integer totalNoOfReviewers = 0;
        for(Movie movie :listOfMovies){
            totalScore+=movie.getTotalRating();
            totalNoOfReviewers+= movie.getTotalNoOfUsersReviewed();
        }

        if(totalNoOfReviewers!=0){
            averageScore = (double)totalScore/ totalNoOfReviewers;
        }

         // rounding off average Score to 2 decimal places
        averageScore = (double)Math.round(averageScore * 100)/100;
        return averageScore;
  }

    /*
    ** This method returns the average review score for a particular movie.
    */
    public double getAverageScoreForMovie(String movieName) throws Exception
    {  
        Movie movie = nameToMovieMap.get(movieName);
        if(movie==null)
        {
            throw new Exception("No such movie exists");
        }
        double averageScore =0;
        if(movie.getTotalNoOfUsersReviewed()!=0){
            averageScore = (double)movie.getTotalRating()/movie.getTotalNoOfUsersReviewed();
        }

        // rounding off average Score to 2 decimall places
        averageScore = (double)Math.round(averageScore * 100)/100;
        return averageScore;
    }

}
