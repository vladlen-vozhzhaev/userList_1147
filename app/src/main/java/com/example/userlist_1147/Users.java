package com.example.userlist_1147;

import java.util.ArrayList;

public class Users {
    ArrayList<User> userList;
    public ArrayList<User> getUserList(){
        this.userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserName("Имя_"+(i+1));
            user.setUserLastname("Фамилия_"+(i+1));
            userList.add(user);
        }
        return userList;
    }
}
