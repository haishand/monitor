package observer;

public class TestObserver {

    public static void main(String[] args) {
        Clown clown = new Clown();
        for(int i=0; i<5; i++) {
            Viewer v = new Viewer();
            clown.addObserver(v);
        }
        clown.perform();
    }
}
