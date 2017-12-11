package oob.mymail.util;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;
import oob.mymail.model.Mail;

public class Util {

    private static final String FAKE_MESSAGE = "FAKE_MESSAGE";

    private static int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(), random.nextInt(), random.nextInt());
    }

    @NonNull
    public static ArrayList<Mail> getDummyData(@Nullable String fakeMessage) {
        if (fakeMessage == null) {
            fakeMessage = Util.FAKE_MESSAGE;
        }
        final String message = fakeMessage;
        return new ArrayList<Mail>(){{
            add(new Mail("Subject", message, "julio@test.es", Util.getRandomColor()));
            add(new Mail("Subject 2", message, "isa@test.es", Util.getRandomColor()));
            add(new Mail("Subject 3", message, "carlos@test.es", Util.getRandomColor()));
            add(new Mail("Subject 4", message, "ana@test.es", Util.getRandomColor()));
            add(new Mail("Subject 5", message, "david@test.es", Util.getRandomColor()));
            add(new Mail("Subject 6", message, "linares@test.es", Util.getRandomColor()));
        }};
    }
}
