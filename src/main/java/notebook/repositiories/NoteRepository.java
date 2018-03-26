package notebook.repositiories;

import notebook.models.Note;

import java.util.ArrayList;

public class NoteRepository {
    private ArrayList<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void displayNotes() {
        for (Note note : this.notes) {
            System.out.println(note.toString());
        }
    }
}
