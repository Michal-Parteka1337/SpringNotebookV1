package notebook.services;

import notebook.models.Note;
import notebook.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InitAppService {

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeData() {
        System.out.println("Initialize data..");

        User januszUser = new User("Janusz");

        userService.saveUser(januszUser);

        noteService.saveNote(new Note("High importance Note 1","Initial Note 1 content", "high", januszUser));
        noteService.saveNote(new Note("Medium importance Note 2", "content", "medium", januszUser));
        noteService.saveNote(new Note("Low importance Note 3", "Initial Note 2 content", "low", januszUser));

        System.out.println("Data initialized!");
    }
}
