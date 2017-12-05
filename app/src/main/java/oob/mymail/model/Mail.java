package oob.mymail.model;

public class Mail {
    private String subject;

    private String message;

    private String senderName;

    private int color;

    public Mail(String subject, String message, String senderName, int color) {
        this.subject = subject;
        this.message = message;
        this.senderName = senderName;
        this.color = color;
    }

    public String getSubject() {
        return subject;
    }

    public Mail setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Mail setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getSenderName() {
        return senderName;
    }

    public Mail setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public int getColor() {
        return color;
    }

    public Mail setColor(int color) {
        this.color = color;
        return this;
    }
}
