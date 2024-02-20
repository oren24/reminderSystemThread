package com.oren.dto;

import com.oren.enums.Urgency;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.oren.logic.ReminderLogic.fixTextByUrgency;

public class Reminder implements Comparable<Reminder> {
	/**
	 * This class represents a reminder object
	 *
	 * @param text - the text of the reminder
	 * @param expirationDate - the date and time the reminder will expire
	 * @param urgency - the urgency of the reminder
	 * @param isPopped - a boolean that indicates if the reminder has been popped or not (default is false)
	 */
	private String text;
	private LocalDateTime expirationDate;
	private Urgency urgency;
	private boolean isPopped;

	/**
	 * Constructor
	 *
	 * @param text
	 * @param expirationDate
	 * @param urgency        </br>
	 *                       Reminder object with the given parameters where: isPopped = false
	 */
	public Reminder(String text, LocalDateTime expirationDate, Urgency urgency) {
		this.text = text;
		this.expirationDate = expirationDate;
		this.urgency = urgency;
		this.isPopped = false;

	}

	/**
	 * Constructor
	 *
	 * @param text
	 * @param expirationDate </br>
	 *                       Reminder object with the given parameters where: urgency = NORMAL and isPopped = false
	 */
	public Reminder(String text, LocalDateTime expirationDate) {
		this(text, expirationDate, Urgency.NORMAL);

	}

	/**
	 * Constructor
	 *
	 * @param text
	 * @param urgency </br>
	 *                Reminder object with the given parameters where: expirationDate = LocalDateTime.now() and isPopped = false
	 */
	public Reminder(String text, Urgency urgency) {
		this(text, LocalDateTime.now(), urgency);

	}

	public String getText() {
		String modifiedText = fixTextByUrgency(text, urgency);
		return modifiedText;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Urgency getUrgency() {
		return urgency;
	}

	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}

	public boolean isPopped() {
		return isPopped;
	}

	public void setPopped(boolean popped) {
		isPopped = popped;
	}

	/**
	 * compares two reminders by their expiration date
	 *
	 * @param reminder
	 * @return a string representation of the reminder</br>
	 * -1 if this reminder is before the given reminder</br>
	 * 1 if this reminder is after the given reminder</br>
	 * 0 if the reminders are equal
	 */
	@Override
	public int compareTo(Reminder reminder) {
		if (this.expirationDate.isBefore(reminder.expirationDate)) {
			return -1;
		}
		if (this.expirationDate.isAfter(reminder.expirationDate)) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Reminder)) {
			return false;
		}
		Reminder reminder = (Reminder) object;
		return Objects.equals(getText(), reminder.getText());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getText());
	}

	@Override
	public String toString() {
		return "Reminder{" +
				"text='" + fixTextByUrgency(text, urgency) + '\'' +
				", expirationDate=" + expirationDate +
				", urgency=" + urgency +
				", isPopped=" + isPopped +
				'}';
	}

}

