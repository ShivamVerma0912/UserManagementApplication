package com.geekster.UserManagementApp.Repo;

import com.geekster.UserManagementApp.User.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private List<User> userList;

    public UserRepo(List<User> userList){
        this.userList = new ArrayList<>();
    }


    public List<User> getUserList() {
        return this.userList;
    }

    public boolean add(User user) {
        userList.add(user);
        return true;
    }
    public boolean remove(User user){
        userList.remove(user);
        return true;
    }
}
