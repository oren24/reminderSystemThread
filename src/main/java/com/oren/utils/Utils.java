package com.oren.utils;

import com.oren.dto.Reminder;
import com.oren.enums.Urgency;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Utils {

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

	// chooses random urgency
	public static Urgency getRandomUrgency() {
		int random = (int) (Math.random() * 3);

		return Urgency.values()[random];
	}

	public static Set<Reminder> InitRemindersSet(int length) {
		Set<Reminder> remindersSet = new HashSet<>();
		for (int index = 0; index < length; index++) {
			remindersSet.add(new Reminder("Reminder " + index, LocalDateTime.now().plusMinutes(index + 1), getRandomUrgency()));
		}
		return remindersSet;
	}

	public static String localDateTimeToStringFormat(LocalDateTime localDateTime) {

		int dayOfMonth = localDateTime.getDayOfMonth();
		int month = localDateTime.getMonthValue();
		int year = localDateTime.getYear();
		int hour = localDateTime.getHour();
		int minute = localDateTime.getMinute();
		String formattedDate = dayOfMonth + "/" + month + "/" + year + " " + hour + ":" + minute;
		return formattedDate;
	}

	// check if two given dates are equal (true) or not (false)
	public boolean isNow(LocalDateTime date1, LocalDateTime date2) {
		return date1.isEqual(date2);
	}
}
