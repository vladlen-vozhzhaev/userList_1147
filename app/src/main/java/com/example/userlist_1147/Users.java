package com.example.userlist_1147;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.userlist_1147.database.UserBaseHelper;
import com.example.userlist_1147.database.UserDBSchema;

import java.util.ArrayList;

public class Users {
    ArrayList<User> userList;
    private SQLiteDatabase database;
    private Context context;

    public Users(Context context){
        this.database = new UserBaseHelper(context).getWritableDatabase();
    }

    public void addUser(User user){
        ContentValues values = getContentValues(user);
        database.insert(UserDBSchema.UserTable.NAME, null, values);
    }

    private ContentValues getContentValues(User user){
        ContentValues values = new ContentValues();
        values.put(UserDBSchema.Cols.UUID, user.getUuid().toString());
        values.put(UserDBSchema.Cols.USERNAME, user.getUserName());
        values.put(UserDBSchema.Cols.USERLASTNAME, user.getUserLastname());
        values.put(UserDBSchema.Cols.PHONE, user.getPhone());
        return values;
    }

    private UserCursorWrapper queryUsers(){
        Cursor cursor = database.query(UserDBSchema.UserTable.NAME, null, null, null, null, null, null);
        return new UserCursorWrapper(cursor);
    }

    public ArrayList<User> getUserList(){
        this.userList = new ArrayList<>();
        UserCursorWrapper cursorWrapper = queryUsers();
        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                User user = cursorWrapper.getUser();
                userList.add(user);
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }


        /*for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserName("Имя_"+(i+1));
            user.setUserLastname("Фамилия_"+(i+1));
            userList.add(user);
        }*/
        return userList;
    }
}
