package com.company.client;

import com.company.client.Person.UserPage;
import com.company.client.Util.ScannerUtil;
import com.company.server.Service;
import com.company.server.User;

public class Register extends ScannerUtil {
    static String patternPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    static String pattern = patternPassword;
    public void registerPage(){

        System.out.println("Input first name");
        String firstName = scannerSTR.nextLine();

        System.out.println("Input last name");
        String lastName = scannerSTR.nextLine();

        Service service = new Service();
        String username;
        while (true){
            System.out.println("Input username");
            username = scannerSTR.nextLine();
            Boolean aBoolean = service.checkUserName(username);
            if(aBoolean==null){
                System.out.println("Empty!");
            }else if(!aBoolean){
                System.out.println("This username is busy");
            }else {
                break;
            }
        }

        String phoneNumber;

        while (true){
            System.out.println("Input phone number");
            System.out.print("+");
            phoneNumber = scannerSTR.nextLine();
            if(phoneNumber.matches("[0-9]{12}")){
                break;
            }else {
                System.out.println("Invalid phone number");
            }
        }

        String password;
        while (true){
            System.out.println("""
                    Input password
                    (8-20)
                    """);
            password= scannerSTR.nextLine();
            if (password.matches(patternPassword)) {
                System.out.println("Valid password");
                break;
            }else {
                System.out.println("Invalid password\n***");
            }
        }

        User user = new User(firstName,lastName,username,phoneNumber,password);
        Boolean aBoolean = service.addUsers(user);
        if(aBoolean == null){
            System.out.println("Something error");
        }else {
            System.out.println("Success");
        }
    }
}
