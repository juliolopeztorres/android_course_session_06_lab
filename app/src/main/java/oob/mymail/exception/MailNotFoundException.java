package oob.mymail.exception;

public class MailNotFoundException extends Exception {
    private static final String message  = "Mail not found";

    public MailNotFoundException() {
        super(MailNotFoundException.message);
    }
}
