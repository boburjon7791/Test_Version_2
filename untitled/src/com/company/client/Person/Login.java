package com.company.client.Person;

import com.company.client.Util.ScannerUtil;
import com.company.server.Service;
import com.company.server.User;

public class Login extends ScannerUtil {
    public void loginPage() {
        System.out.println("Input username");
        String username = scannerSTR.nextLine();

        System.out.println("Input password");
        String password = scannerSTR.nextLine();

        Service service = new Service();
        User user = service.checkUser(username, password);
        if(user == null){
            System.out.println("Wrong username or password");
        }else{
        switch (user.getRoles()){
            case ADMIN -> {
                AdminPage adminPage = new AdminPage();
                adminPage.adminPage(user);
            }
            case USER -> {
                UserPage userPage = new UserPage();
                userPage.userPage(user);
            }
          }
        }
    }
}
