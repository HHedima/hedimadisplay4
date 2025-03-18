package edu.guilford;

public class Clock {
    // instance variables
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;
    private boolean isTimer;

    // constructor
    public Clock() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.milliseconds = 0;
    }

    // constructor
    public Clock(int hours, int minutes, int seconds, int milliseconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    // getters and setters
    public void setTime(int hours, int minutes, int seconds, int milliseconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    // if no parameters are given set time to current time
    public void setTime() {
        java.util.TimeZone estTimeZone = java.util.TimeZone.getTimeZone("America/New_York");
        java.util.Calendar calendar = java.util.Calendar.getInstance(estTimeZone);
        this.hours = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        this.minutes = calendar.get(java.util.Calendar.MINUTE);
        this.seconds = calendar.get(java.util.Calendar.SECOND);
        this.milliseconds = calendar.get(java.util.Calendar.MILLISECOND);
    }

    public String getTime() {
        return String.format("%02d:%02d:%02d.%03d", this.hours, this.minutes, this.seconds, this.milliseconds);
    }

    public int getHour() {
        return hours;
    }

    public void setHour(int hours) {
        this.hours = hours;
        if (this.hours > 23) {
            this.hours = 0;
        }
        if (this.hours < 0) {
            this.hours = 23;
        }
    }

    public int getMinute() {
        return minutes;
    }

    public void setMinute(int minutes) {
        this.minutes = minutes;
        if (this.minutes > 59) {
            this.minutes = 0;
        }
        if (this.minutes < 0) {
            this.minutes = 59;
        }
    }

    public int getSecond() {
        return seconds;
    }

    public void setSecond(int seconds) {
        this.seconds = seconds;
        if (this.seconds > 59) {
            this.seconds = 0;
        }
        if (this.seconds < 0) {
            this.seconds = 59;
        }
    }

    public int getMillisecond() {
        return milliseconds;
    }

    public void setMillisecond(int milliseconds) {
        this.milliseconds = milliseconds;
        if (this.milliseconds > 999) {
            this.milliseconds = 0;
        }
        if (this.milliseconds < 0) {
            this.milliseconds = 999;
        }
    }

    public void isTimer(boolean isTimer) {
        this.isTimer = isTimer;
    }

    public boolean isTimer() {
        return this.isTimer;
    }

    public void clear() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.milliseconds = 0;
    }
    
    /**
     * Increments the time by one millisecond. If the milliseconds reach 1000, 
     * they are reset to 0 and the seconds are incremented by one. If the seconds 
     * reach 60, they are reset to 0 and the minutes are incremented by one. If 
     * the minutes reach 60, they are reset to 0 and the hours are incremented by 
     * one. If the hours reach 24, they are reset to 0.
     */
    public void incrementTime() {
        this.milliseconds++;
        if (this.milliseconds == 1000) {
            this.milliseconds = 0;
            this.seconds++;
            if (this.seconds == 60) {
                this.seconds = 0;
                this.minutes++;
                if (this.minutes == 60) {
                    this.minutes = 0;
                    this.hours++;
                    if (this.hours == 24) {
                        this.hours = 0;
                    }
                }
            }
        }
    }

    /**
     * Decrements the time by one millisecond. If the milliseconds reach -1, they are reset to 999 and the seconds are decremented.
     * If the seconds reach -1, they are reset to 59 and the minutes are decremented.
     * If the minutes reach -1, they are reset to 59 and the hours are decremented.
     * If the hours reach -1, they are reset to 23.
     */
    public void decrementTime() {
        this.milliseconds--;
        if (this.milliseconds == -1) {
            this.milliseconds = 999;
            this.seconds--;
            if (this.seconds == -1) {
                this.seconds = 59;
                this.minutes--;
                if (this.minutes == -1) {
                    this.minutes = 59;
                    this.hours--;
                    if (this.hours == -1) {
                        this.hours = 23;
                    }
                }
            }
        }
    }

    
    public void tick() {
        if (this.isTimer) {
            this.decrementTime();
        } else {
            this.incrementTime();
        }
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d.%03d", this.hours, this.minutes, this.seconds, this.milliseconds);
    }




}
