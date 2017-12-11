package oob.mymail.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import oob.mymail.R;
import oob.mymail.model.Mail;

public class DetailsFragment extends Fragment {

    private View view;
    private TextView textViewSubject;
    private TextView textViewSenderName;
    private TextView textViewMessage;

    public DetailsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_details, container, false);

        this.bindUI();

        return view;
    }

    private void bindUI() {
        this.textViewSubject = this.view.findViewById(R.id.textViewDetailSubject);
        this.textViewSenderName = this.view.findViewById(R.id.textViewDetailSenderName);
        this.textViewMessage = this.view.findViewById(R.id.textViewDetailMessage);
    }

    public void updateUI(Mail mail) {
        this.textViewSubject.setText(mail.getSubject());
        this.textViewSenderName.setText(mail.getSenderName());
        this.textViewMessage.setText(mail.getMessage());
    }
}
