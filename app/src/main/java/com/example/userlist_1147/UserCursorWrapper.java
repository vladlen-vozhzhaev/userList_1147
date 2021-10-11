package com.example.userlist_1147;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.userlist_1147.database.UserDBSchema;

import java.util.UUID;

public class UserCursorWrapper extends CursorWrapper {

    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public User getUser(){
        String uuidString = getString(getColumnIndex(UserDBSchema.Cols.UUID));
        String userName = getString(getColumnIndex(UserDBSchema.Cols.USERNAME));
        String userLastname = getString(getColumnIndex(UserDBSchema.Cols.USERLASTNAME));
        String phone = getString(getColumnIndex(UserDBSchema.Cols.PHONE));
        User user = new User(UUID.fromString(uuidString));
        user.setUserName(userName);
        user.setUserLastname(userLastname);
        user.setPhone(phone);
        return user;
    }
}
