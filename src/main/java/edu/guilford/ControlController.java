package edu.guilford;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControlController {
    // instantiate labels
    @FXML
    private Label hourLabel;
    @FXML
    private Label minuteLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label millisecondLabel;

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

    // instantiate a new Clock object
    private Clock clock = new Clock();
    private boolean isRunning = false;

    
    private void updateLabels() {
        hourLabel.setText(String.format("%02d", clock.getHour()) + "h:");
        minuteLabel.setText(String.format("%02d", clock.getMinute()) + "m:");
        secondLabel.setText(String.format("%02d", clock.getSecond()) + "s:");
        millisecondLabel.setText(String.format("%03d", clock.getMillisecond()) + "ms");
       if (clock.getHour() == 0 && clock.getMinute() == 0 && clock.getSecond() == 0 && clock.getMillisecond() == 0) {
            isRunning = false;
        }
    }

    /**
     * Starts the clock and allows it to run in the background.
     * This method is triggered by an ActionEvent, typically from a button press.
     * It sets the isRunning flag to true and creates a new thread that continuously
     * updates the clock and the UI labels while the isRunning flag is true.
     *
     * @param event the ActionEvent that triggered this method
     */
    @FXML
    public void start(ActionEvent event) {
        System.out.println("The button event is " + event);
        isRunning = true;
        // allows the clock to run in the background
        Thread thread = new Thread(() -> {
            while (isRunning) {
                clock.tick();
                javafx.application.Platform.runLater(this::updateLabels);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void stop(ActionEvent event) {
        System.out.println("The button event is " + event);
        isRunning = false;
    }

    @FXML
    public void reset(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.clear();
        updateLabels();
    }

    /**
     * Toggles the state of the timer when the associated button is pressed.
     * If the timer is currently running, it will be stopped and the button text will be updated to "Timer Off".
     * If the timer is currently stopped, it will be started and the button text will be updated to "Timer On".
     * 
     * @param event the ActionEvent triggered by the button press
     */
    @FXML
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

    @FXML
    public void addHour(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setHour(clock.getHour() + 1);
        updateLabels();
    }

    @FXML
    public void subtractHour(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setHour(clock.getHour() - 1);
        updateLabels();
    }

    @FXML
    public void addMinute(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMinute(clock.getMinute() + 1);
        updateLabels();
    }

    @FXML
    public void subtractMinute(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMinute(clock.getMinute() - 1);
        updateLabels();
    }

    @FXML
    public void addSecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setSecond(clock.getSecond() + 1);
        updateLabels();
    }

    @FXML
    public void subtractSecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setSecond(clock.getSecond() - 1);
        updateLabels();
    }

    @FXML
    public void addMillisecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMillisecond(clock.getMillisecond() + 1);
        updateLabels();
    }

    @FXML
    public void subtractMillisecond(ActionEvent event) {
        System.out.println("The button event is " + event);
        clock.setMillisecond(clock.getMillisecond() - 1);
        updateLabels();
    }


}
