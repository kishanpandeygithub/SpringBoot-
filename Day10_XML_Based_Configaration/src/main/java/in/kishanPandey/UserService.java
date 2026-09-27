package in.kishanPandey;

import java.util.List;

public class UserService {
    //protype scope example
//    private List<String> userName;
//
//    public UserService( List<String> userName) {
//        this.userName = userName;
//    }
//
//    public List<String> getUserName() {
//        return userName;
//    }

    public UserService(){
        System.out.println("UserService created");
    }

    public void init(){
        System.out.println("Post Construct phase");
    }

    public void cleanUp(){
        System.out.println("Pre Distroy phase");
    }
}
