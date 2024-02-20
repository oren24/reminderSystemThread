package com.oren.app;

import com.oren.dto.Reminder;
import com.oren.enums.Urgency;
import com.oren.threads.ReminderTask;
import com.oren.timerTasks.ReminderTimerTask;
import com.oren.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import static com.oren.utils.Utils.localDateTimeToStringFormat;

public class ReminderSystem extends JFrame {

	// Singleton instance
	private static ReminderSystem instance;

	// Attributes
	private static Set<Reminder> reminders;
	private ReminderTask reminderTask;
	private ReminderTimerTask reminderTimerTask;
	private Timer timer;

	private ReminderSystem() {// Constructor is private to prevent instantiation from outside the class (Singleton)
		reminders = Utils.InitRemindersSet(10);
		initializeTask();
		initializeGUI();
	}

	public static ReminderSystem getInstance() { // Singleton getInstance method to get the instance of the class
		if (instance == null) {
			instance = new ReminderSystem();
		}
		return instance;
	}

	private void initializeTask() { // Initialize the reminder task and start it in a new thread
//		reminderTask = new ReminderTask(reminders);
//		new Thread(reminderTask).start();
		// creating reminder task as a timer task and scheduling it to run every 10 seconds
		 timer = new Timer();
		 ReminderTimerTask reminderTimerTask = new ReminderTimerTask(reminders);
		 timer.schedule(reminderTimerTask, 0, 10000);

	}

	private void initializeGUI() {
		setTitle("Reminder System");
		setLayout(new FlowLayout());

		JButton addButton = new JButton("Add Reminder");
		JButton viewButton = new JButton("View Reminders");
		JButton exitButton = new JButton("Exit");

		add(addButton);
		add(viewButton);
		add(exitButton);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = JOptionPane.showInputDialog("Enter reminder text:");
				String minutesStr = JOptionPane.showInputDialog("Enter minutes from now:");

				int minutes;
				try {
					minutes = Integer.parseInt(minutesStr);
				} catch (NumberFormatException ex) {
					minutes = 0;
					JOptionPane.showMessageDialog(ReminderSystem.this, "Invalid minutes entered!");
				}
				reminders.add(new Reminder(text, LocalDateTime.now().plusMinutes(minutes)));

			}
		});

		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<Reminder> sortedReminders = new ArrayList<>(reminders);
				sortedReminders.sort(Comparator.comparing(Reminder::getExpirationDate));


				String[] attributesNames = {"text", "expirationDate", "urgency", "isPopped"};
				String[][] data = new String[sortedReminders.size()][4];
				for (int index = 0; index < sortedReminders.size(); index++) {

					Reminder reminder = sortedReminders.get(index);
					String modifiedDate = localDateTimeToStringFormat(reminder.getExpirationDate());
					Urgency urgency = reminder.getUrgency();
					boolean isPopped = reminder.isPopped();

					data[index][0] = reminder.getText();
					data[index][1] = modifiedDate;
					data[index][2] = urgency.toString();
					data[index][3] = String.valueOf(isPopped);
				}
				JTable table = new JTable(data, attributesNames);
				JScrollPane scrollPane = new JScrollPane(table);
				JFrame frame = new JFrame("Reminders");
				frame.add(scrollPane, BorderLayout.CENTER);
				frame.setSize(800, 200);
				frame.setVisible(true);


			}
		});

		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				reminderTask.end();

				timer.cancel();
				System.exit(0);
			}
		});

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}


