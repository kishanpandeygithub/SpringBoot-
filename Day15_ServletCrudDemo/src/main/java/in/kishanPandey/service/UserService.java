package in.kishanPandey.service;

import in.kishanPandey.model.User;
import in.kishanPandey.servlet.UserServlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import  java.util.Map;
public class UserService {
    private Map<Integer , User> userDb ;

    public UserService(){
        userDb = new HashMap<>();
    }

    //create method
    public User createUser(User user){
        userDb.put(user.getId() ,user);
        return user;
    }

    //get all user
    public List<User> getAllUsers(){
        List<User> userRes= new ArrayList<>();
        for(User user : userDb.values()){
            userRes.add(user);
        }
        return  userRes;
    }

    //get user by order
    public User getUserById(Integer id){
       return userDb.getOrDefault(id , null);
    }

}
