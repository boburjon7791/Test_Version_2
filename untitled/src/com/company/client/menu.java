package com.company.client;

import com.company.client.Person.AdminPage;
import com.company.client.Person.Login;
import com.company.client.Util.ScannerUtil;
import com.company.server.Question;
import com.company.server.Subject;
import com.company.server.User;
import com.company.server.database.Database;
import com.company.server.enums.Roles;

import java.util.Random;

public class menu extends ScannerUtil {
    public static void main(String[] args){
        User user1 = new User("Soliyev","Boburjon",
                "bobur","998932564879","1145");
        user1.setRoles(Roles.ADMIN);
        Database.USERS.add(user1);

        User user2 = new User("G'aniyev","Ahmad",
                "akki","998748796565","1414");
        Database.USERS.add(user2);

        User user3 = new User("Salimov","Husan",
                "messi","998914565656","1415");
        Database.USERS.add(user3);

        Subject subject = new Subject("Java");
        Database.SUBJECTS.add(subject);
        Question question = new Question("jvm","java virtual machine");
        Question question1 = new Question("jdk","java development kids");
        Database.QUESTIONS.add(question);
        Database.QUESTIONS.add(question1);
        subject.addQuestion(question);
        subject.addQuestion(question1);

        Subject subject1 = new Subject("C++");
        Database.SUBJECTS.add(subject1);
        Question question2 = new Question("C++ nima?","C++ dasturlash tili");
        Question question3 = new Question("C++ fayl kengaytmasi","C++ fayl kengaytmasi .cpp");
        Database.QUESTIONS.add(question2);
        Database.QUESTIONS.add(question3);
        subject1.addQuestion(question2);
        subject1.addQuestion(question3);
        /*
          for operatori sinov uchun
         */
        while (true) {
            for (User user : Database.USERS) {
                System.out.println(user.getUserName() + "->" + user.getPassword() + "->" + user.getRoles());
                System.out.println();
            }
            mainMenu();
            System.out.println("\n\n\n\n\n\n\n\n\n");
        }
    }

    public static void mainMenu() {
        System.out.println("""
                1. Login
                2. Register
                """);
        switch (scannerSTR.nextLine()){
            case "1"->{
                Login login = new Login();
                login.loginPage();
            }
            case "2"->{
                Register register = new Register();
                register.registerPage();
            }
        }
    }
}