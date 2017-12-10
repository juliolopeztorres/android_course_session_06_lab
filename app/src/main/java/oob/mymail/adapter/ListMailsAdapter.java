package oob.mymail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import oob.mymail.R;
import oob.mymail.model.Mail;

public class ListMailsAdapter extends BaseAdapter {

    private static final int SUBJECT_LIMIT = 40;
    private static final int MESSAGE_LIMIT = 80;

    private ArrayList<Mail> mails;
    private int layout;
    private Context context;

    public ListMailsAdapter(ArrayList<Mail> mails, int layout, Context context) {
        this.mails = mails;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.mails.size();
    }

    @Override
    public Object getItem(int i) {
        return this.mails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflateView(view);
        MailViewHolder viewHolder = (MailViewHolder) view.getTag();

        Mail currentMail = (Mail) this.getItem(i);

        viewHolder.getTextViewInitialLetter().setText(this.getInitialLetter(currentMail.getSenderName()));
        viewHolder.getTextViewInitialLetter().setBackgroundColor(currentMail.getColor());
        viewHolder.getTextViewSubject().setText(this.limitString(currentMail.getSubject(), SUBJECT_LIMIT));
        viewHolder.getTextViewMessage().setText(this.limitString(currentMail.getMessage(), MESSAGE_LIMIT));

        return view;
    }

    @NonNull
    private View inflateView(View view) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(this.layout, null);
            MailViewHolder viewHolder = createMailViewHolder(view);

            view.setTag(viewHolder);
        }
        return view;
    }

    @NonNull
    private MailViewHolder createMailViewHolder(View view) {
        MailViewHolder viewHolder;
        viewHolder = new MailViewHolder();
        viewHolder
                .setTextViewInitialLetter((TextView) view.findViewById(R.id.textViewInitialLetter))
                .setTextViewSubject((TextView) view.findViewById(R.id.textViewSubject))
                .setTextViewMessage((TextView) view.findViewById(R.id.textViewMessage));
        return viewHolder;
    }

    @NonNull
    private String getInitialLetter(String senderName) {
        return senderName.substring(0, 1).toUpperCase();
    }

    private String limitString(String string, int subjectLimit) {
        if (string.length() > subjectLimit) {
            return string.substring(0, subjectLimit - 3) + "...";
        }
        return string;
    }
}
