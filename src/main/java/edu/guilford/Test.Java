package edu.guilford;

// this class is used to test the Clock class methods
public class Test {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.setTime(0, 1, 0, 0);
        System.out.println("Starting time: " + clock);
        clock.isTimer(true);
        while (clock.getHour() != 0 || clock.getMinute() != 0 || clock.getSecond() != 0 || clock.getMillisecond() != 0) {
            clock.tick();
            if (clock.getMillisecond() == 0) {
                System.out.println(clock);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time's up!");
        clock.setTime();
        System.out.println("Current time: " + clock);
    }

}