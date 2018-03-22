package notebook.models;

public class ResponseTransfer {
    public ResponseTransfer(String text) {
        this.text = text;
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void displayText() {
        System.out.println(this.text);
    }
}
