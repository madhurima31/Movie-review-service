/**
 * @author Madhurima Mondal
 * User POJO with all the properties of User
 */
public class User {

    private String userName;
    private Boolean isCritic;
    private Integer noOfReviews;

    public User(String userName) {
        this.userName = userName;
        this.isCritic = false;
        this.noOfReviews = 0;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getIsCritic() {
        return this.isCritic;
    }

    public void setIsCritic(Boolean isCritic) {
        this.isCritic = isCritic;
    }

    public Integer getNoOfReviews() {
        return this.noOfReviews;
    }

    public void setNoOfReviews(Integer noOfReviews) {
        this.noOfReviews = noOfReviews;
    }
    
}
