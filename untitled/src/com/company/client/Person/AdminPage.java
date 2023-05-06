package com.company.client.Person;

import com.company.client.Util.ScannerUtil;
import com.company.server.Question;
import com.company.server.Service;
import com.company.server.Subject;
import com.company.server.User;
import com.company.server.enums.Roles;

import java.util.List;

public class AdminPage extends ScannerUtil {
    public void adminPage(User admin){
        if(admin == null) {
            System.out.println("Something error");
        }else if(admin.getRoles().equals(Roles.ADMIN)) {
            while(true){
            System.out.println("Admin page");
            System.out.println("""
                    ***
                    1. Add subject
                    2. Show subjects list
                    3. Add question
                    4. Show questions list
                    5. Show users list
                    6. Change password
                    
                    0. Logout
                    ***
                    """);
            String str = scannerSTR.nextLine();
            if(str.equals("0")){
                break;
            }else{
            switch (str){
                case "1" ->{
                    Service service = new Service();
                    String name;
                    while (true){
                        System.out.println("Input subject name");
                        name = scannerSTR.nextLine();
                        if(!name.isBlank()){
                            if(service.checkSubject(name,admin)){
                                System.out.println("Success");
                                break;
                            }else if(service.checkSubject(name,admin) == null){
                                System.out.println("You have no access");
                                break;
                            }else {
                                System.out.println("Failed");
                                break;
                            }
                        }
                    }
                }
                case "2" ->{
                    Service service = new Service();
                    List<Subject> subjects = service.subjectsList();
                    for (Subject subject : subjects) {
                        System.out.println(subject.getName());
                    }
                }
                case "3" ->{
                    Service service = new Service();
                    List<Subject> subjects = service.subjectsList();
                    System.out.println("Select subject");
                    for (int i = 0; i < subjects.size(); i++) {
                        System.out.println(i+". "+subjects.get(i));
                    }
                    int selectedSubject = scannerNUM.nextInt();
                    Subject subjectS = subjects.get(selectedSubject);

                    System.out.println("Input question");
                    String question = scannerSTR.nextLine();

                    System.out.println("Input answer");
                    String answer = scannerSTR.nextLine();

                    boolean addQuestion = service.addQuestion(subjectS, question, admin, answer);

                    if(addQuestion){
                        System.out.println("Success");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "4" ->{
                    Service service = new Service();
                    List<Question> questionList = service.getQuestionList();

                    if(questionList.isEmpty()){
                        System.out.println("Empty");
                    }else{
                        for (Question question : questionList) {
                            System.out.println(question);
                        }
                    }
                }
                case "5" ->{
                    Service service = new Service();
                    List<User> usersList = service.getUsersList(admin);
                    if(usersList == null){
                        System.out.println("You have no access");
                    }else {
                        for (User user : usersList) {
                            System.out.println(user);
                        }
                    }
                }
                case "6" ->{
                    Service service = new Service();
                    System.out.println("Input old password");
                    String oldPassword = scannerSTR.nextLine();

                    System.out.println("Input new password");
                    String newPassword = scannerSTR.nextLine();

                    Boolean aBoolean = service.changePassword(admin, oldPassword, newPassword);

                    if(aBoolean == null){
                        System.out.println("Something error");
                    }else if(!aBoolean){
                        System.out.println("Error old password");
                    }else {
                        System.out.println("Success");
                    }
                }
               }
             }
            }
        }else {
            System.out.println("You have no access");
        }
    }
}