package com.geekster.userManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geekster.userManagementSystem.model.UserManage;
import com.geekster.userManagementSystem.repository.UserRepo;


import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepo userRepository;


    public List<UserManage> getAllUsers(){
        return userRepository.getUsersFromDataSource();
    }

    public String addMyUser(UserManage userManagement)
    {
        boolean insertionStatus=userRepository.save(userManagement);
        if(insertionStatus)
            return "User added successfully..!";
        else
            return "Failed user add not possible";
    }

    public UserManage getUserBasedId(String id)
    {
        List<UserManage> UserRightNow=userRepository.getUsersFromDataSource();

        for(UserManage userManagement:UserRightNow){
            if(userManagement.getUserId()==Integer.parseInt(id))
                return userManagement;
        }
        return null;
    }

    public String updateUser(int id,UserManage userManagement) {
        String status;
        List<UserManage> UserRightNow=userRepository.getUsersFromDataSource();

        for(UserManage userManage:UserRightNow){
            if(userManage.getUserId()==(id)) {
                if(userRepository.update(id,userManagement))
                    return "Updated Successfully";
            }
        }
        return "cannot update User";
    }

    public String removeUserId(String id)
    {
        boolean deleteResponse=false;
        String status;
        if(id!=null){
            List<UserManage> UserRightNow=userRepository.getUsersFromDataSource();

            for(UserManage userManagement:UserRightNow){
                if(userManagement.getUserId()==Integer.parseInt(id)) {
                    deleteResponse=userRepository.remove(userManagement);
                    if(deleteResponse)
                    {
                        status="User with id "+id+" was deleted";
                    }
                    else{
                        status="Deletion was not possible on  "+id;
                    }
                    return status;
                }
            }
            return "User with "+id+" does not exist";
        }
        return "invalid id cannot acept null id";
    }
}
