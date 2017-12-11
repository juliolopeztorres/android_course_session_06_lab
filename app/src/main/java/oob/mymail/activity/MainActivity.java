package oob.mymail.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

import oob.mymail.R;
import oob.mymail.fragment.DetailsFragment;
import oob.mymail.fragment.ListFragment;
import oob.mymail.model.Mail;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentUIEventsInterface {

    private boolean xlargeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.xlargeScreen = this.isXLargeScreen();
    }

    private boolean isXLargeScreen() {
        return this.getSupportFragmentManager().findFragmentById(R.id.fragment_details) != null;
    }

    @Override
    public void onMailItemClick(Mail mail) {
        if (this.xlargeScreen) {
            DetailsFragment detailsFragment = (DetailsFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_details);
            detailsFragment.updateUI(mail);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("mail", mail);
            startActivity(intent);
        }
    }
}
