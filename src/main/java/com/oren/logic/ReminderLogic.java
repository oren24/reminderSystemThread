package com.oren.logic;

import com.oren.dto.Reminder;
import com.oren.enums.Urgency;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Set;

public class ReminderLogic {
	// check if reminders expired and then pops them
	public static void checkRemindersExpire(Set<Reminder> reminders) {
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
	}
	// adjust the text of the reminder according to its urgency
	public static String fixTextByUrgency(String text, Urgency urgency) {
		String fixedText = text;
		if (urgency == Urgency.IMPORTANT) {
			fixedText = fixedText.toUpperCase();
			return fixedText;
		}
		if (urgency == Urgency.Critical) {
			fixedText = "!!! " + fixedText.toUpperCase() + " !!!";
			return fixedText;
		}
		return fixedText;
	}
	// convert LocalDateTime to string in easier to read format
	public static String localDateTimeToStringFormat(LocalDateTime localDateTime) {

		int dayOfMonth = localDateTime.getDayOfMonth();
		int month = localDateTime.getMonthValue();
		int year = localDateTime.getYear();
		int hour = localDateTime.getHour();
		int minute = localDateTime.getMinute();
		String formattedDate = dayOfMonth + "/" + month + "/" + year + " " + hour + ":" + minute;
		return formattedDate;
	}
}
