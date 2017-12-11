package oob.mymail.util;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;
import oob.mymail.model.Mail;

public class Util {

    private static final String FAKE_MESSAGE = "FAKE_MESSAGE";
    private static final String[] FAKE_EMAILS = {"julio@test.es", "isa@test.es"};

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
            for(int i = 1; i < 25; i++) {
                add(new Mail(
                    "Subject " + i,
                    message,
                    (i % 2 == 0) ? FAKE_EMAILS[0] : FAKE_EMAILS[1], Util.getRandomColor()
                ));
            }
        }};
    }
}
