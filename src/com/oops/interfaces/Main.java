package com.oops.interfaces;

public class Main {
    public static void main(String[] args) {
       // Car car = new Car();
        //what if we want to use Engine as a type
        //what thing we can accaes is depend onn the engine not on the car but method call depend on the objevct of car
//        Engine car1 = new Car();
//        car1.start();
//        car1.stop();
//        car1.acc();
//        car.brake();
//        System.out.println("Car price: " + Engine.price);
        //heere we are using Media  as a type to test his method but it show  the same output as the media and engine both
        //both stop() and start() method are same in both interface and they give the same out
//        Media media = new Car();
//        media.start();


        //Outputs are:  [
//        media starting
//        media  stopping
//        I accelerate like a normal car
//        I am braking like a normal car
//        Car price: 78000
//        media starting ]

// NOTE :- to overcome  this proble be have to use the fiffernt

    Nicecar car = new Nicecar();

    car.start();
    car.acc();
    car.stop();
    car.startmusic();
    car.stopmusic();
    //after running  this the engine will now change to electric engine bacause we have called the updardengine method
    //  beacise the upupgardeengine changed to that of the electric engine
        //  using this in nicecar class>>
//        public void updardengine() {
//            this.engine = new Electricengine();
//        }
    car.updardengine();
    car.start();
    car.acc();




}
}