package com.geekster.UserManagementApp.Service;

import com.geekster.UserManagementApp.Repo.UserRepo;
import com.geekster.UserManagementApp.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUser(){
        return userRepo.getUserList();
    }

    public String addUser(User user) {
        boolean addedStatus = userRepo.add(user);
        if(addedStatus) return "User added successfully";
        return "User addition failed..!!";
    }

    public User userGetById(String userId) {
        List<User> userList = userRepo.getUserList();
        for(User user : userList){
            if(user.getUserId().equals(userId))
                return user;
        }
        return null;
    }

    public boolean updateUserById(String userId,String name) {
        List<User> userList = userRepo.getUserList();
        for(User user : userList){
            if(user.getUserId().equals(userId)){
                //remove original
                userRepo.remove(user);

                user.setName(name);

                userRepo.add(user);
                return true;
            }
        }
        return false;
    }

    public String removeUserByUserId(String userId) {
        String status = "";
        boolean dResponse = false;
        if(userId != null){
            List<User> userList = userRepo.getUserList();
            for(User user : userList){
                if(user.getUserId().equals(userId)) {
                    dResponse = userRepo.remove(user);
                    if (dResponse)
                        status = "UserId " + userId + " deleted successfully";
                    else
                        status = "UserId " + userId + " was not found";
                    return status;
                }
            }
        }
        return "UserId "+userId +" was not found..!!!";
    }
}
