package com.company.server;

//import com.company.client.random.Generate;
import com.company.server.enums.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String password;
    private Roles roles=Roles.USER;
    private double totalBall=0;
    private final List<UserTestSolveHistory> userTestSolveHistories = new ArrayList<>();
    public User() {
    }

    public User(String firstName, String lastName, String userName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = "+" + phoneNumber;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalBall() {
        return totalBall;
    }

    public void setTotalBall(double totalBall) {
        this.totalBall += totalBall;
    }

    public void addSubjectList(Subject subject, int totalBall){
        UserTestSolveHistory userTestSolveHistory = new UserTestSolveHistory();
        userTestSolveHistory.setSubject(subject);
        userTestSolveHistory.setBall(totalBall);
        this.userTestSolveHistories.add(userTestSolveHistory);
    }

    public List<UserTestSolveHistory> getSubjectList() {
        return this.userTestSolveHistories;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Password='" + password.replace(password,"****") + '\'' +
                ", roles=" + roles +
                ", totalBall=" + totalBall +
                ", userTestSolveHistories=" + userTestSolveHistories +
                '}';
    }
}
