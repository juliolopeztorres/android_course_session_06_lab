package oob.mymail.adapter;

import android.widget.TextView;

class MailViewHolder {
    private TextView textViewInitialLetter;
    private TextView textViewSubject;
    private TextView textViewMessage;

    TextView getTextViewInitialLetter() {
        return textViewInitialLetter;
    }

    MailViewHolder setTextViewInitialLetter(TextView textViewInitialLetter) {
        this.textViewInitialLetter = textViewInitialLetter;
        return this;
    }

    TextView getTextViewSubject() {
        return textViewSubject;
    }

    MailViewHolder setTextViewSubject(TextView textViewSubject) {
        this.textViewSubject = textViewSubject;
        return this;
    }

    TextView getTextViewMessage() {
        return textViewMessage;
    }

    MailViewHolder setTextViewMessage(TextView textViewMessage) {
        this.textViewMessage = textViewMessage;
        return this;
    }
}
