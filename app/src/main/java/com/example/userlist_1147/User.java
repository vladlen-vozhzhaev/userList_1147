package com.example.userlist_1147;

import java.util.UUID;

public class User {
    private String userName;
    private String userLastname;
    private String phone;
    private UUID uuid;

    public User(UUID uuid){
        this.uuid = uuid;
    }

    public User(){
        uuid = UUID.randomUUID();
    }

    public String getUserName() {
        return userName;
    }
    public String getUserLastname() {
        return userLastname;
    }
    public String getPhone() {
        return phone;
    }
    public UUID getUuid() {return uuid;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
