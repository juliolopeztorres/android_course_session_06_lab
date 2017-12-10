package oob.mymail.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

import oob.mymail.R;
import oob.mymail.fragment.ListFragment;
import oob.mymail.model.Mail;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentUIEventsInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onMailItemClick(Mail mail) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("mail", mail);
        startActivity(intent);
    }
}
