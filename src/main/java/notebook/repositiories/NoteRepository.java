package notebook.repositiories;

import notebook.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    /*private ArrayList<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }*/
}
