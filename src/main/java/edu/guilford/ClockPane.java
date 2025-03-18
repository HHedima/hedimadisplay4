package edu.guilford;

import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ClockPane extends GridPane {
    // 1. declarations
    // 2. instantiate
    Label hourLabel = new Label("Hour");
    Label minuteLabel = new Label("Minute");
    Label secondLabel = new Label("Second");
    Label millisecondLabel = new Label("Millisecond");

    Button addHourButton = new Button("Add Hour");
    Button addMinuteButton = new Button("Add Minute");
    Button addSecondButton = new Button("Add Second");
    Button addMillisecondButton = new Button("Add Millisecond");
    Button subtractHourButton = new Button("Subtract Hour");
    Button subtractMinuteButton = new Button("Subtract Minute");
    Button subtractSecondButton = new Button("Subtract Second");
    Button subtractMillisecondButton = new Button("Subtract Millisecond");

    TextField hourValue = new TextField("00");
    TextField minuteValue = new TextField("00");
    TextField secondValue = new TextField("00");
    TextField millisecondValue = new TextField("000");

    // contructor
    public ClockPane() {
        // 3. add fields to pane
        add(hourLabel, 0, 0);
        add(hourValue, 0, 1);
        add(minuteLabel, 1, 0);
        add(minuteValue, 1, 1);
        add(secondLabel, 2, 0);
        add(secondValue, 2, 1);
        add(millisecondLabel, 3, 0);
        add(millisecondValue, 3, 1);
        add(addHourButton, 0, 2);
        add(addMinuteButton, 1, 2);
        add(addSecondButton, 2, 2);
        add(addMillisecondButton, 3, 2);
        add(subtractHourButton, 0, 3);
        add(subtractMinuteButton, 1, 3);
        add(subtractSecondButton, 2, 3);
        add(subtractMillisecondButton, 3, 3);


        // 4. set event handlers for buttons
        addHourButton.setOnAction(this::addHour);
        /* addMinuteButton.setOnAction(this::addMinute);
        addSecondButton.setOnAction(this::addSecond);
        addMillisecondButton.setOnAction(this::addMillisecond);
        subtractHourButton.setOnAction(this::subtractHour);
        subtractMinuteButton.setOnAction(this::subtractMinute);
        subtractSecondButton.setOnAction(this::subtractSecond);
        subtractMillisecondButton.setOnAction(this::subtractMillisecond); */
        


    }

    // 4. create event handlers for buttons
    public void addHour(ActionEvent e) {
        System.out.println("working");
        System.out.println("The button event is " + e);
    }

}
