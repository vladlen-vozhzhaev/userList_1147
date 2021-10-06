package com.example.userlist_1147;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    //ArrayList<String> usersName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*for (int i = 0; i < 100; i++) {
            usersName.add("User_"+i);
        }*/

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Users users = new Users();
        userAdapter = new UserAdapter(users.getUserList());
        recyclerView.setAdapter(userAdapter);
    }

    // Класс элемента списка
    private class UserHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        String userName;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String userName){
            this.userName = userName;
            itemTextView.setText(userName);
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<User> usersName;
        public UserAdapter(ArrayList<User> usersName) {
            this.usersName = usersName;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = usersName.get(position);
            userHolder.bind(user.getUserName()+" "+user.getUserLastname());
        }

        @Override
        public int getItemCount() {
            return usersName.size();
        }
    }
}