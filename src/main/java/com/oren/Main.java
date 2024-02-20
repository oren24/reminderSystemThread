package com.oren;

import com.oren.app.ReminderSystem;
import com.oren.dto.Reminder;
import com.oren.utils.Utils;

import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
		// to see how IntelliJ IDEA suggests fixing it.


		// start the reminderSystem singleton instance
		ReminderSystem reminderSystem = ReminderSystem.getInstance();
		reminderSystem.setVisible(true);



	}
}