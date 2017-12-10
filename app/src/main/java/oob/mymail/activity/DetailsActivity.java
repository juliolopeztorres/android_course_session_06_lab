package oob.mymail.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import oob.mymail.R;
import oob.mymail.exception.MailNotFoundException;
import oob.mymail.model.Mail;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        try {
            Mail mail = this.getMail();
        } catch (MailNotFoundException e) {
            processMailException(e.getMessage());
        }
    }

    private void processMailException(String exeptionMessage) {
        Log.i(String.valueOf(this.getApplicationInfo().uid), exeptionMessage);
        Toast.makeText(this, exeptionMessage, Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public Mail getMail() throws MailNotFoundException {
        Mail mail = (Mail) this.getIntent().getSerializableExtra("mail");
        if (mail == null) {
            throw new MailNotFoundException();
        }

        return mail;
    }
}
