package com.oren;
import com.oren.dto.Reminder;
import com.oren.enums.Urgency;
import com.oren.utils.Utils;

import javax.swing.*;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Set<Reminder> remindersSet = Utils.InitRemindersSet(15);

        for (Reminder reminder : remindersSet) {
            System.out.println(reminder);
//            JOptionPane.showMessageDialog(null, reminder);
            // shows a table with the reminders

        }
    }
}