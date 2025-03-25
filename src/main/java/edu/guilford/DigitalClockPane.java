package edu.guilford;

import javafx.scene.control.Label;

import javafx.scene.layout.FlowPane;

public class DigitalClockPane extends FlowPane{
    // instantiate clock
    private Clock clock;

    // inantiate labels for the clock
    private Label hourLabel = new Label();
    private Label minuteLabel = new Label();
    private Label secondLabel = new Label();
    private Label millisecondLabel = new Label();

    // constructor
    public DigitalClockPane(Clock clock) {
        super();
        this.clock = clock;

        // set the style of the pane
        setStyle("-fx-background-color: black;");
        setStyle("-fx-text-fill: white;");
        setPrefSize(640, 180);
        setAlignment(getAlignment().CENTER);

        // add the labels to the pane
        getChildren().addAll(hourLabel, minuteLabel, secondLabel, millisecondLabel);

        // customize the labels
        hourLabel.setStyle("-fx-font-family: 'Monospaced'; -fx-font-size: 48px;");
        minuteLabel.setStyle("-fx-font-family: 'Monospaced'; -fx-font-size: 48px;");
        secondLabel.setStyle("-fx-font-family: 'Monospaced'; -fx-font-size: 48px;");
        millisecondLabel.setStyle("-fx-font-family: 'Monospaced'; -fx-font-size: 48px;");


        // update the labels
        updateLabels();        
    }

    // getters and setters
    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public void getHourLabel() {
        hourLabel.setText(String.format("%02d", clock.getHour()) + "h:");
    }

    public void setHourLabel(Label hourLabel) {
        this.hourLabel = hourLabel;
    }

    public void getMinuteLabel() {
        minuteLabel.setText(String.format("%02d", clock.getMinute()) + "m:");
    }

    public void setMinuteLabel(Label minuteLabel) {
        this.minuteLabel = minuteLabel;
    }

    public void getSecondLabel() {
        secondLabel.setText(String.format("%02d", clock.getSecond()) + "s:");
    }

    public void setSecondLabel(Label secondLabel) {
        this.secondLabel = secondLabel;
    }

    public void getMillisecondLabel() {
        millisecondLabel.setText(String.format("%03d", clock.getMillisecond()) + "ms");
    }

    public void setMillisecondLabel(Label millisecondLabel) {
        this.millisecondLabel = millisecondLabel;
    }

    // update the labels
    public void updateLabels() {
        hourLabel.setText(String.format("%02d", clock.getHour()) + "h:");
        minuteLabel.setText(String.format("%02d", clock.getMinute()) + "m:");
        secondLabel.setText(String.format("%02d", clock.getSecond()) + "s:");
        millisecondLabel.setText(String.format("%03d", clock.getMillisecond()) + "ms");
    }

}
