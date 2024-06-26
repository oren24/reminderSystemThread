package com.oren.utils;

import com.oren.dto.Reminder;
import com.oren.enums.Urgency;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Utils {

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

    // check if two given dates are equal (true) or not (false)
	public boolean isNow(LocalDateTime date1, LocalDateTime date2) {
		return date1.isEqual(date2);
	}
}
