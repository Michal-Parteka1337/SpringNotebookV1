package notebook.services;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.models.User;
import notebook.repositiories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceIm implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    @Override
    public Note findOne(Long id) {
        return noteRepository.getOne(id);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note noteToDelete = this.findOne(id);
        if (noteToDelete != null) {
            noteRepository.delete(noteToDelete);
        }
    }

    @Override
    public Note saveNoteForm(AddNoteForm addNoteForm) {
        String userName = addNoteForm.getUserName();
        User user = userService.findByName(userName);

        if (user == null) {
            user = new User(userName);
        }

        Note noteToAdd = new Note(addNoteForm.getNoteTitle(), addNoteForm.getNoteContent(), addNoteForm.getPriority(), user);
        return noteRepository.save(noteToAdd);
    }
}
