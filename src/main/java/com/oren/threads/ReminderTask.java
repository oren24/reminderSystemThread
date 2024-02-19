package com.oren.threads;

import com.oren.dto.Reminder;

import java.util.Set;

public class ReminderTask extends Thread{
    private boolean quit ;
    private Set<Reminder> reminders;
    public ReminderTask(Set<Reminder> reminders) {
        this.reminders = reminders;
        this.quit = false;
    }
    public void run(){
        while (!quit) {
            for (Reminder reminder : reminders) {
                int remaindersPopped = 0;
                if (reminder.getExpirationDate().isBefore(java.time.LocalDateTime.now()) && !reminder.isPopped()) {
                    System.out.println(reminder.getText());
                    reminder.setPopped(true);
                    remaindersPopped++;
                    if (remaindersPopped == reminders.size()) {
                        end();
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void end(){
        this.quit = true;
    }
}
