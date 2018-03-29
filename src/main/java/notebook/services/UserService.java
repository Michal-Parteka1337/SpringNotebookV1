package notebook.services;

import notebook.models.Note;
import notebook.models.User;
import notebook.repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }

    public User findOne(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User userToDelete = this.findOne(id);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        }
    }

    public void assignNote(Long id, Note note) {
        User user = this.findOne(id);
        user.addNote(note);
    }
}
