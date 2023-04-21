package com.geekster.userManagementSystem.repository;

import com.geekster.userManagementSystem.model.UserManage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private List<UserManage> userManagementList;

    public UserRepo() {

        userManagementList=new ArrayList<>();
//        userManagementList.add(new UserManagement(1,"xyz","zyxsecsd","bluechip","1234567890"));
    }

    public  boolean save(UserManage userManagement)
    {
        userManagementList.add(userManagement);
        return true;
    }

    public List<UserManage> getUsersFromDataSource()
    {
        return userManagementList;
    }

    public boolean update(int id, UserManage userManagement) {
        for(UserManage userManage:userManagementList){
            if(userManage.getUserId()==id){
                remove(userManage);
                save(userManagement);
                return true;
            }
        }
        return false;
    }

    public boolean remove(UserManage userManagement){
        userManagementList.remove(userManagement);
        return true;
    }
}

