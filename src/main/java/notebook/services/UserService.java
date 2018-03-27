package notebook.services;

import notebook.models.Note;
import notebook.models.User;
import notebook.repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

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
