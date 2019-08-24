package com.cmile.secondassignment.models;

public class UserDetails {

    private String userFirstName;
    private String userLastName;
    private int userAge;
    private String userEmail;
    private long userPhone;
    private String userBirthdate;
    private String userCountry;

    public UserDetails(String userFirstName, String userLastName, int userAge, String userEmail, long userPhone, String userBirthdate, String userCountry) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userBirthdate = userBirthdate;
        this.userCountry = userCountry;
    }

    public UserDetails() {
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(String userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }
}
