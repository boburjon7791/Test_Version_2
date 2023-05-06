package com.company.client.Person;

import com.company.client.Register;
import com.company.client.Util.ScannerUtil;
import com.company.server.*;
import com.company.server.enums.Roles;

import java.util.List;

public class UserPage extends ScannerUtil {
    public void userPage(User user){
        if(user == null){
            System.out.println("Something error");
        }else if (user.getRoles().equals(Roles.USER)) {
            while(true) {
                System.out.println("Student page");
                System.out.println("""
                        ***
                        1. One subject's test history
                        2. Select subject and starting test
                        3. My all test history
                        4. Change password
                                            
                        10. Logout
                        ***
                        """);
                String str = scannerSTR.nextLine();
                boolean stop = false;
                if (str.equals("10")) {
                    break;
                }else {
                switch (str) {
                    case "1" -> {
                        Service service = new Service();

                            List<UserTestSolveHistory> userTestSolveHistories = service.userTestSolveHistory(user);
                        while (true) {
                            if (!userTestSolveHistories.isEmpty()) {
                                for (int i = 0; i < userTestSolveHistories.size(); i++) {
                                    System.out.println(i + ". " + userTestSolveHistories.get(i).getSubject() + "  " + userTestSolveHistories.get(i).getDate()+" ");
                                }
                                System.out.println("Select subject");
                                int selectedSubject = scannerNUM.nextInt();
                                if(selectedSubject==10){
                                    break;
                                }
                                System.out.println(user.getSubjectList().get(selectedSubject).getSubject() + "->" +
                                        user.getSubjectList().get(selectedSubject).getBall() + "->" + userTestSolveHistories.get(selectedSubject).getDate());
                            } else {
                                System.out.println("List empty");
                            }
                            scannerSTR.nextLine();
                        }
                    }
                    case "2" -> {
                        Service service = new Service();
                        List<Subject> subjectList = service.subjectsList();
                        while (true) {
                            for (int i = 0; i < subjectList.size(); i++) {
                                System.out.println(i + ". " + subjectList.get(i));
                            }
                            int selectedSubject = scannerNUM.nextInt();
                            if(selectedSubject==10){
                                break;
                            }
                            List<Question> questions = service.selectSubject(user, subjectList.get(selectedSubject));
                           while(true){
                            for (int i = 0; i < questions.size(); i++) {
                                System.out.println(i + ". " + questions.get(i).getQuestion());
                            }
                            int selectedQuestion = scannerNUM.nextInt();
                            if(selectedQuestion==10){
                                break;
                            }
                            System.out.println(questions.get(selectedQuestion).getQuestion());
                            System.out.println();
                            String[] answers = new String[4];
                            answers[0] = "Answer1";
                            answers[1] = "Answer2";
                            answers[2] = questions.get(selectedQuestion).getAnswer();
                            answers[3] = "Answer3";

                            for (int i = 0; i < answers.length; i++) {
                                System.out.println("[" + i + "]. " + answers[i]);
                            }
                            int selectedAnswer = scannerNUM.nextInt();
                            if(selectedAnswer==10){
                                break;
                            }
                            Boolean question = service.getQuestion(user, subjectList.get(selectedSubject),
                                    questions.get(selectedQuestion), answers[selectedAnswer]);
                            if (question == null) {
                                System.out.println("User error");
                                stop=true;
                            } else if (!question) {
                                System.out.println("Incorrect answer");
                                stop=true;
                            } else {
                                System.out.println("Correct answer");
                                stop=true;
                            }

                          }
                        }
                    }
                    case "3" -> {
                        Service service = new Service();
                        List<UserTestSolveHistory> subjectList = user.getSubjectList();
                        if(subjectList.isEmpty()){
                            System.out.println("List empty");
                        }else {
                            for (UserTestSolveHistory subject : subjectList) {
                                System.out.println(subject.getSubject()+", "+subject.getBall());
                            }
                        }
                        System.out.println("My total ball is "+user.getTotalBall());
                    }
                    case "4" -> {
                        Service service = new Service();
                        System.out.println("Input old password");
                        String oldPassword = scannerSTR.nextLine();

                        String patternPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
                        String newPassword = "";
                        while (true){
                            System.out.println("Input new password");
                            newPassword = scannerSTR.nextLine();
                            if(newPassword.matches(patternPassword)){
                                System.out.println("Valid password");
                                break;
                            }else{
                                System.out.println("Invalid password");
                            }
                        }
                        service.changePassword(user,oldPassword,newPassword);
                    }
                }
            }
                if(stop){
                    break;
                }
            }
        }else{
            System.out.println("You have no access");
        }
    }
}