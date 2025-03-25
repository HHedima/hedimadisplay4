package edu.guilford;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ClockController {

    // instantiate buttons
    @FXML
    private Button timerButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button addHourButton;
    @FXML
    private Button subtractHourButton;
    @FXML
    private Button addMinuteButton;
    @FXML
    private Button subtractMinuteButton;
    @FXML
    private Button addSecondButton;
    @FXML
    private Button subtractSecondButton;
    @FXML
    private Button addMillisecondButton;
    @FXML
    private Button subtractMillisecondButton;

    // constructor
    public ClockController() {
    }

    // instantiate a new Clock object
    private Clock clock = new Clock();
    private boolean isRunning = false;

    // get clock
    public Clock getClock() {
        return clock;
    }

    // set clock
    public void setClock(Clock clock) {
        this.clock = clock;
    }


    
    /**
     * Starts the clock and allows it to run in the background.
     * This method is triggered by an ActionEvent, typically from a button press.
     * It sets the isRunning flag to true and creates a new thread that continuously
     * updates the clock and the UI labels while the isRunning flag is true.
     *
     * @param event the ActionEvent that triggered this method
     */
    public void start(ActionEvent event) {
        System.out.println("The button event is " + event);
        isRunning = true;
        // allows the clock to run in the background
        java.util.concurrent.ScheduledExecutorService executor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (isRunning) {
                clock.tick();
                
            } else {
                executor.shutdown();
            }
        }, 0, 1, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    
    public void stop(ActionEvent event) {
        System.out.println("The button event is " + event);
        isRunning = false;
    }

    
    public void reset(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.clear();
    }

    /**
     * Toggles the state of the timer when the associated button is pressed.
     * If the timer is currently running, it will be stopped and the button text will be updated to "Timer Off".
     * If the timer is currently stopped, it will be started and the button text will be updated to "Timer On".
     * 
     * @param event the ActionEvent triggered by the button press
     */
    public void toggleTimer(ActionEvent event) {
        System.out.println("The button event is " + event);
        // toggle the timer state
        if (clock.isTimer()) {
            clock.isTimer(false);
            timerButton.setText("Change to Timer");
        } else {
            clock.isTimer(true);
            timerButton.setText("Change to Clock");
        }
        isRunning = false;
    }

    public void addHour(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setHour(clock.getHour() + 1);
    }

    public void subtractHour(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setHour(clock.getHour() - 1);
    }

    public void addMinute(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMinute(clock.getMinute() + 1);
    }

    public void subtractMinute(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMinute(clock.getMinute() - 1);
    }

    public void addSecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setSecond(clock.getSecond() + 1);
    }

    public void subtractSecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setSecond(clock.getSecond() - 1);
    }

    public void addMillisecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMillisecond(clock.getMillisecond() + 1);
    }

    public void subtractMillisecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMillisecond(clock.getMillisecond() - 1);
    }


}
