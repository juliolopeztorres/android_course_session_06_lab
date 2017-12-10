package oob.mymail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import oob.mymail.R;
import oob.mymail.adapter.ListMailsAdapter;
import oob.mymail.model.Mail;
import oob.mymail.util.Util;

public class ListFragment extends Fragment {

    private ArrayList<Mail> mails;
    private ListView listViewMails;
    private ListMailsAdapter listMailsAdapter;
    private View view;
    private ListFragmentUIEventsInterface listFragmentUIEventsInterface;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_list, container, false);

        this.bindUI();
        this.setEvents();

        return this.view;
    }

    private void bindUI() {
        this.mails = Util.getDummyData();
        this.listMailsAdapter = new ListMailsAdapter(this.mails, R.layout.item_list, this.getContext());
        this.listViewMails = this.view.findViewById(R.id.listViewMails);
        this.listViewMails.setAdapter(this.listMailsAdapter);
    }

    private void setEvents() {
        this.listViewMails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listFragmentUIEventsInterface.onMailItemClick(mails.get(i));
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.detachUIElements();
    }

    private void detachUIElements() {
        this.listFragmentUIEventsInterface = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listFragmentUIEventsInterface = (ListFragmentUIEventsInterface) context;
    }

    public interface ListFragmentUIEventsInterface {
        void onMailItemClick(Mail mail);
    }
}
