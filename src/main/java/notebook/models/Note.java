package notebook.models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String priority;
    private String createStamp;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Note() { }

    public Note(String title, String content, String priority, User user) {
        this.title = title;
        this.content = content;
        this.priority = priority;
        this.user = user;
        this.createStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCreateStamp() {
        this.createStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());;
    }
}
