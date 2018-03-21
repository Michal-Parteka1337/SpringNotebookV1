package notebook.controllers;

import notebook.models.User;
import notebook.repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser ( //Response body - returned String is response, not view
            @RequestParam String name,
            @RequestParam String surname
    ) {
        User u = new User();
        u.setName(name);
        u.setSurname(surname);
        userRepository.save(u);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
