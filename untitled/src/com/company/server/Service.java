package com.company.server;

import com.company.server.database.Database;
import com.company.server.enums.Roles;

import java.util.ArrayList;
import java.util.List;

import static com.company.client.Util.ScannerUtil.scannerSTR;


public class Service implements Database {
    Database database = new Database() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    };

    //register
    public Boolean register(User user){
        if(user == null){
            return null;
        }
        for (User user2 : USERS) {
            if(user2.getUserName().equals(user.getUserName())){
                return false;
            }
        }
        USERS.add(user);
        return true;
    }

    //for admins
    public List<User> getUsersList(User admin){
        if(admin == null){
            return null;
        }
        if(!admin.getRoles().equals(Roles.ADMIN)){
            return null;
        }
        return USERS;
    }
    public Boolean addSubject(User admin,String name){
        if(admin == null && name == null){
            return null;
        }
        assert admin != null;
        if(name.isBlank()){
            return null;
        }
        if(admin.getRoles().equals(Roles.ADMIN)) {
            for (Subject subject : SUBJECTS) {
                if(subject.getName().equals(name)){
                    return null;
                }
            }
            Subject subject = new Subject(name);
            SUBJECTS.add(subject);
            return true;
        }
        return false;
    }

    public static List<Question> questionsList() {
        return QUESTIONS;
    }

    public boolean addQuestion(Subject subject,String question, User user,String answer){
        if (user == null && subject == null) {
            return false;
        }
        assert user != null;
        if (!user.getRoles().equals(Roles.ADMIN)) {
            return false;
        }
        if(question.isBlank() || answer.isBlank()){
            return false;
        }
        Question question1 = new Question();
        for (Subject subject1 : SUBJECTS) {
            if(subject1.equals(subject)){
                subject1.addQuestion(question1);
                question1.setQuestion(question);
                question1.setAnswer(answer);
            }
        }
        QUESTIONS.add(question1);

        return true;
    }
    public static List<User> usersList(){
        return USERS;
    }
    public static boolean changePasswordAdmin(User admin,String newPassword,String oldPassword){
        if (admin == null) {
            return false;
        }
        if(admin.getRoles().equals(Roles.USER)){
            return false;
        }
        if(!oldPassword.equals(admin.getPassword())){
            return false;
        }
        admin.setPassword(newPassword);
        return true;
    }



    //for students
    public List<UserTestSolveHistory> userTestSolveHistory(User user){
        if(user == null){
            return null;
        }

        return user.getSubjectList();
    }


    public static boolean changePasswordUser(User user,String newPassword,String oldPassword){
        if (user != null) {
            return false;
        }
        if(!oldPassword.equals(user.getPassword())){
            return false;
        }
        user.setPassword(newPassword);
        return true;
    }

    public List<Subject> subjectsList() {
        return SUBJECTS;
    }
    public List<UserTestSolveHistory> studentSubjectsList(User user){
        if(user == null){
            return null;
        }
        return user.getSubjectList();
    }
    public List<Question> selectSubject(User user, Subject subject){
        if(user == null){
            return null;
        }
        Subject subject1 = new Subject();
        for (Subject subject2 : SUBJECTS) {
            if(subject2.equals(subject)){
                subject1 = subject2;
            }
        }
        return subject1.getSubjectQuestions();
    }
    public User checkUser(String userName,String password){
        if(userName.isBlank() || password.isBlank()){
            return null;
        }
        for (User user1 : USERS) {
            if(user1.getUserName().equals(userName) &&
            user1.getPassword().equals(password)){
                return user1;
            }
        }
        return null;
    }
    public Boolean checkUserName(String userName){
        if(userName.isBlank()){
            return null;
        }
        for (User user1 : USERS) {
            if(user1.getUserName().equals(userName)){
                return false;
            }
        }
        return true;
    }

    public List<Question> selectQuestion(User user, Subject subject){
        if(user == null){
            return null;
        }
            return subject.getSubjectQuestions();

    }
    public Double getStudentTotalBall(User user){
        if(user == null){
            return null;
        }
        return user.getTotalBall();
    }
    public Double getStudentSelectSubjectBall(User user,Subject subject){
        if (user == null && subject == null){
            return null;
        }
        return subject.getTotalBall();
    }
    public Boolean getQuestion(User user,Subject subject, Question question,String answer){
        /**
         * if this method returns null user error
         * if return true correct answer
         * else if return false incorrect answer
        **/
        if (user == null) {
            return null;
        }


            if (question.getAnswer().equals(answer)) {
                user.setTotalBall(1);
                user.addSubjectList(subject,1);
                return true;
            }else{
                user.addSubjectList(subject,0);
            }
                return false;

    }

    public Boolean changePassword(User user, String oldPassword, String newPassword) {
        if(user == null){
            return null;
        }
        if(!user.getPassword().equals(oldPassword)){
            return false;
        }
        String patternPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        if(!newPassword.matches(patternPassword)){
            return false;
        }
        user.setPassword(newPassword);
        return true;
    }

    public List<Question> getQuestionList() {
        return QUESTIONS;
    }

    public Boolean addUsers(User user) {
        if(user == null){
            return null;
        }
        USERS.add(user);
        return true;
    }

    public Boolean checkSubject(String name,User admin) {
        if(admin == null){
            return null;
        }
        if(!admin.getRoles().equals(Roles.ADMIN)){
            return null;
        }
        if(name.isBlank()){
            return false;
        }
        for (Subject subject : SUBJECTS) {
            if(subject.getName().equals(name)){
                return false;
            }
        }
        Subject subject = new Subject(name);
        SUBJECTS.add(subject);
        return true;
    }
}
