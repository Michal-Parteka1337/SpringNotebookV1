package notebook.services;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.repositiories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class AddNoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(AddNoteForm addNoteForm) {
        Note note = new Note(addNoteForm.getNoteTitle(), addNoteForm.getNoteContent(), addNoteForm.getPriority());
        noteRepository.addNote(note);
    }

    public ArrayList<Note> getNotes() {
        return noteRepository.getNotes();
    }

}
