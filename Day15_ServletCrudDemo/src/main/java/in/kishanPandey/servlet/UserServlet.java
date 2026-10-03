package in.kishanPandey.servlet;

import in.kishanPandey.model.User;
import in.kishanPandey.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (id == null || email == null || name == null || mobile == null) {
            //return 404
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    "" +
                            "{\n" +
                            "    \"message\": \"User Cant Be Added Some Field Are Missing \"\n" +
                            "}"
            );
        }
        User user = new User(id, name, email, mobile);
        User CreatedUser = userService.createUser(user);

        ///return the json user
        response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().write(
                "" +
                        "{\n" +
                        "    \"message\": \"User added Successfully\"\n" +
                        "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        if (userId == null) {
            List<User> users = userService.getAllUsers();
            //return user
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));

        }
        Integer id = Integer.parseInt(userId);
        User userResponce = userService.getUserById(id);
        if (userResponce == null) {
            response.setStatus(404);
            response.setContentType("application/json");
        }

        //return json user
        response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().write(userToJson(userResponce));
    }

    @Override
    public void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    @Override
    public void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    private String userToJson(User userResponce) {
        return "{\n" +
                "    \" id\": " + userResponce.getId() + " ,\n" +
                "    \"name\" : " + userResponce.getName() + "  ,\n" +
                "    \"email\" : " + userResponce.getEmail() + "  ,\n" +
                "    \"mobile\": " + userResponce.getMobile() + " \n" +
                "}";
    }

    private String usersToJson(List<User> usersResponce) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < usersResponce.size(); i++) {
            stringBuilder.append(userToJson(usersResponce.get(i)));
            if (i < usersResponce.size() - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
