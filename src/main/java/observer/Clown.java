package observer;

import core.CallBack;

import java.util.Observable;
import java.util.Random;

public class Clown extends Observable {

    public void perform() {
        int i = new Random().nextInt();
        System.out.println("perform: " + i);
        setChanged();
        notifyObservers(new CallBack() {

            @Override
            public void method(Object arg) {

            }
        });
    }

    public void oops() {
        System.out.println("oops");
    }

}
