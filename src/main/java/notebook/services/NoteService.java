package notebook.services;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import java.util.List;

public interface NoteService {

    List<Note> findAll();

    Note findOne(Long id);

    Note saveNote(Note note);

    Note saveNoteForm(AddNoteForm addNoteForm);

    void deleteNote(Long id);

}
