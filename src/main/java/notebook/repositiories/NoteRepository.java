package notebook.repositiories;

import notebook.models.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class NoteRepository {
    private ArrayList<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
