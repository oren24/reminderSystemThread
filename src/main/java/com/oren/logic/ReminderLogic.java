package com.oren.logic;

import com.oren.dto.Reminder;
import com.oren.enums.Urgency;

import java.time.LocalDateTime;

public class ReminderLogic {
    private Reminder reminder;

    public ReminderLogic(Reminder reminder) {
        this.reminder = reminder;
    }
//    public String getReminderText() {
//        String modifiedText = fixTextByUrgency(reminder.getText(), reminder.getUrgency());
//        return modifiedText;
//    }

//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public LocalDateTime getExpirationDate() {
//        return expirationDate;
//    }
//
//    public void setExpirationDate(LocalDateTime expirationDate) {
//        this.expirationDate = expirationDate;
//    }
//
//    public Urgency getUrgency() {
//        return urgency;
//    }

    public void setUrgency(Urgency urgency) {
        this.reminder.setUrgency(urgency);
    }

    public boolean isPopped() {
        return reminder.isPopped();
    }

    public void setPopped(boolean popped) {
        reminder.setPopped(popped);
    }
//    public String fixTextByUrgency(String text, Urgency urgency) {
//        String fixedText=text;
//        if (urgency == Urgency.IMPORTANT) {
//            fixedText=fixedText.toUpperCase();
//            return fixedText;
//        }
//        if (urgency == Urgency.Critical) {
//            fixedText = "!!! "+fixedText.toUpperCase() + " !!!";
//            return fixedText;
//        }
//        return fixedText;
//    }

}
