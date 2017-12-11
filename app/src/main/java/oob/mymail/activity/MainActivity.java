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
    private DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.detailsFragment = (DetailsFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_details);
        this.xlargeScreen = this.isXLargeScreen();
    }

    private boolean isXLargeScreen() {
        return this.detailsFragment != null;
    }

    @Override
    public void onMailItemClick(Mail mail) {
        if (this.xlargeScreen) {
            this.detailsFragment.updateUI(mail);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("mail", mail);
            startActivity(intent);
        }
    }
}
