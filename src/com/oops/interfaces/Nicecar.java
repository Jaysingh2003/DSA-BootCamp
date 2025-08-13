package com.oops.interfaces;

public class Nicecar {

    //enggine is the interface so we intailize like this
    private Engine engine;
    private Media player = new CDplayer();


    public Nicecar() {
        engine = new Powerengine();
    }

    public Nicecar(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void acc() {
        engine.acc();
    }

    public void startmusic() {
        player.start();
    }

    public void stopmusic() {
        player.stop();
    }

    public void updardengine() {
        this.engine = new Electricengine();
    }
}
