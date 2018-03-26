package notebook.services;

import notebook.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InitAppService {

    @Autowired
    NoteService noteService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeData() {
        System.out.println("Initialize data..");

        noteService.saveNote(new Note("Initial Note 1","Initial Note 1 content", "High"));
        noteService.saveNote(new Note("Initial Note 2", "Initial Note 2 content", "Low"));

        System.out.println("Initialized!");
    }
}
