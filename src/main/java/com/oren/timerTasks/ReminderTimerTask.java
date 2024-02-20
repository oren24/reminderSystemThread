package com.oren.timerTasks;

import com.oren.dto.Reminder;

import java.util.Set;
import java.util.TimerTask;

import static com.oren.logic.ReminderLogic.*;

public class ReminderTimerTask extends TimerTask {
	private boolean quit;
	private final Set<Reminder> reminders;

	public ReminderTimerTask(Set<Reminder> reminders) {
		this.reminders = reminders;
		this.quit = false;
	}

	public void run() {



		checkRemindersExpire(reminders);


	}

}
