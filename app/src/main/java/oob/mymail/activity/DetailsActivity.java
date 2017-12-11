package oob.mymail.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import oob.mymail.R;
import oob.mymail.exception.MailNotFoundException;
import oob.mymail.fragment.DetailsFragment;
import oob.mymail.model.Mail;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        try {
            DetailsFragment detailsFragment = (DetailsFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_details);
            detailsFragment.updateUI(this.getMail());
        } catch (MailNotFoundException e) {
            processMailException(e.getMessage());
        }
    }

    private Mail getMail() throws MailNotFoundException {
        Mail mail = (Mail) this.getIntent().getSerializableExtra("mail");
        if (mail == null) {
            throw new MailNotFoundException();
        }

        return mail;
    }

    private void processMailException(String exceptionMessage) {
        Log.i(String.valueOf(this.getApplicationInfo().uid), exceptionMessage);
        Toast.makeText(this, exceptionMessage, Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
