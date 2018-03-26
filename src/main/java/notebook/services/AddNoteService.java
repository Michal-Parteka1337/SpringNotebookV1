package notebook.services;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.repositiories.NoteRepository;

public class AddNoteService {
    public NoteRepository noteRepository = new NoteRepository();

    public void addNote(AddNoteForm addNoteForm) {
        Note note = new Note(addNoteForm.getNoteTitle(), addNoteForm.getNoteContent(), addNoteForm.getPriority());
        noteRepository.addNote(note);
        noteRepository.displayNotes();
    }
}
