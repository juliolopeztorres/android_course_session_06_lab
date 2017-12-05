package oob.mymail.util;

import android.graphics.Color;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

import oob.mymail.model.Mail;

public class Util {

    private static int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(), random.nextInt(), random.nextInt());
    }

    @NonNull
    public static ArrayList<Mail> getDummyData() {
        return new ArrayList<Mail>(){{
            add(new Mail("Subject", "Message", "Julio", Util.getRandomColor()));
            add(new Mail("Subject 2", "Message 2", "Isa", Util.getRandomColor()));
            add(new Mail("Subject 3", "Message 3", "Carlos", Util.getRandomColor()));
            add(new Mail("Subject 4", "Message 4", "Ana", Util.getRandomColor()));
            add(new Mail("Subject 5", "Message 5", "David", Util.getRandomColor()));
            add(new Mail("Subject 6", "Message 6", "Linares", Util.getRandomColor()));
        }};
    }
}
