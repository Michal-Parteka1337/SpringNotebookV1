package notebook.services;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.repositiories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceIm implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

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
        Note noteToAdd = new Note(addNoteForm.getNoteTitle(), addNoteForm.getNoteContent(), addNoteForm.getPriority());
        return noteRepository.save(noteToAdd);
    }
}
