package notebook.models;

import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Note {
    private String id;
    private String title;
    private String content;
    private String priority;
    private String createStamp;

    public Note(String title, String content, String priority) {
        this.setId();
        this.title = title;
        this.content = content;
        this.priority = priority;
        this.createStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreateStamp() {
        return createStamp;
    }
}
