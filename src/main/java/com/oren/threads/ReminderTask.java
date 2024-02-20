package com.oren.threads;

import com.oren.dto.Reminder;

import java.util.Set;

import static com.oren.logic.ReminderLogic.*;

public class ReminderTask extends Thread {
	private boolean quit;
	private final Set<Reminder> reminders;

	public ReminderTask(Set<Reminder> reminders) {
		this.reminders = reminders;
		this.quit = false;
	}

	public void run() {
		while (!quit) {

			checkRemindersExpire(reminders);

			int counter = reminders.size();
			for (Reminder reminder : reminders) {

				if (reminder.isPopped()) {
					counter--;
				}
				if (counter == 0) {
					end();
				}
			}

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void end() {
		this.quit = true;
	}
}
