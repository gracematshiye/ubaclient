package za.ac.uba.model;

/**
 * Created by gracem on 2017/10/27.
 */
public class UserViewModel {
    private Integer studentId;
    private String name;
    private String surname;
    private String email;
    private Double funds;
    private Boolean loggedIn;
    private String sessionKey;

    public UserViewModel(Integer studentId, String name, String surname, String email, Double funds, Boolean loggedIn, String sessionKey) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.funds = funds;
        this.loggedIn = loggedIn;
        this.sessionKey = sessionKey;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
