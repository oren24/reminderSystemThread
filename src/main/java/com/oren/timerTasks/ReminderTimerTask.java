package com.oren.timerTasks;

import com.oren.dto.Reminder;
import com.oren.enums.Urgency;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TimerTask;

import static com.oren.utils.Utils.fixTextByUrgency;
import static com.oren.utils.Utils.localDateTimeToStringFormat;

public class ReminderTimerTask extends TimerTask {
	private boolean quit;
	private final Set<Reminder> reminders;

	public ReminderTimerTask(Set<Reminder> reminders) {
		this.reminders = reminders;
		this.quit = false;
	}

	public void run() {
//		while (!quit) {


			for (Reminder reminder : reminders) {

				if (reminder.getExpirationDate().isBefore(java.time.LocalDateTime.now()) && !reminder.isPopped()) {

					Urgency urgency = reminder.getUrgency();
					String reminderText = reminder.getText();
					reminderText = fixTextByUrgency(reminderText, urgency);

					LocalDateTime expirationDate = reminder.getExpirationDate();
					String expirationDateText = localDateTimeToStringFormat(expirationDate);
					String massage = "Reminder expired:\n " + reminderText + "\n at\n\t " + expirationDateText;
					System.out.println(massage);
					JOptionPane.showMessageDialog(null, massage);
					reminder.setPopped(true);


				}


			}
//			this.end();
//		}
	}

	public void end() {
		this.cancel();
	}
}
