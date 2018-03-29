package notebook.models;

public class AddNoteForm {
    private String noteTitle;
    private String noteContent;
    private String priority;
    private String userName;

    public AddNoteForm(String noteTitle, String noteContent, String priority, String userName) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.priority = priority;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        return "Title: " + noteTitle + " Content: " + noteContent + " User: " + userName;
    }
}
