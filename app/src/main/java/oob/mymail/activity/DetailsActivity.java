package oob.mymail.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import oob.mymail.R;
import oob.mymail.exception.MailNotFoundException;
import oob.mymail.model.Mail;

public class DetailsActivity extends AppCompatActivity {

    private TextView textViewSubject;
    private TextView textViewSenderName;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.bindUI();

        try {
            this.updateUI(this.getMail());
        } catch (MailNotFoundException e) {
            processMailException(e.getMessage());
        }
    }

    private void bindUI() {
        this.textViewSubject = this.findViewById(R.id.textViewDetailSubject);
        this.textViewSenderName = this.findViewById(R.id.textViewDetailSenderName);
        this.textViewMessage = this.findViewById(R.id.textViewDetailMessage);
    }

    private Mail getMail() throws MailNotFoundException {
        Mail mail = (Mail) this.getIntent().getSerializableExtra("mail");
        if (mail == null) {
            throw new MailNotFoundException();
        }

        return mail;
    }

    private void processMailException(String exeptionMessage) {
        Log.i(String.valueOf(this.getApplicationInfo().uid), exeptionMessage);
        Toast.makeText(this, exeptionMessage, Toast.LENGTH_SHORT).show();
        this.finish();
    }

    private void updateUI(Mail mail) {
        this.textViewSubject.setText(mail.getSubject());
        this.textViewSenderName.setText(mail.getSenderName());
        this.textViewMessage.setText(mail.getMessage());
    }
}
