package notebook.models;

public class AddNoteForm {
    private String noteTitle;
    private String noteContent;
    private String priority;

    public AddNoteForm(String noteTitle, String noteContent, String priority) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.priority = priority;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
