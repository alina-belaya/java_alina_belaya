package date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;

public class FrameCreate {
    static JTextField tfh;
    static JTextField tfb;

    static void frameMain(Holiday holiday, Person persona){
        JFrame frameMain = new JFrame("Reminder");

        JButton button1 = new JButton("Send holiday MSG");
        button1.setBounds(40, 130, 150, 30);
        button1.addActionListener(e -> {
            try {
                frameHoliday(holiday);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        JLabel labelH = new JLabel("Today`s holiday: ");
        labelH.setBounds(60, 50, 150, 30);

        if (holiday == null) {
            tfh = new JTextField("None");
        } else {
            tfh = new JTextField(String.valueOf(holiday.holidayName));
            frameMain.add(button1);
        }
        tfh.setEditable(false);
        tfh.setBounds(170, 50, 150, 30);

        JButton button2 = new JButton("Send b-day MSG");
        button2.setBounds(210, 130, 150, 30);
        button2.addActionListener(e -> {
            try {
                frameBDay(persona);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        JLabel labelB = new JLabel("Today`s birthday: ");
        labelB.setBounds(60, 90, 150, 30);

        if (persona == null) {
            tfb = new JTextField("None");
        } else {
            tfb = new JTextField(String.valueOf(persona.name));
            frameMain.add(button2);
        }
        tfb.setEditable(false);
        tfb.setBounds(170, 90, 150, 30);

        frameMain.add(tfh);
        frameMain.add(labelH);
        frameMain.add(tfb);
        frameMain.add(labelB);

        frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMain.setSize(400, 300);
        frameMain.setLayout(null);
        frameMain.setVisible(true);

    }

    static void frameHoliday(Holiday holiday) throws IOException {
        JFrame frameHoliday = new JFrame("Send holiday MSG");

        JLabel label = new JLabel("Today`s holiday: ");
        label.setBounds(80, 30, 200, 30);

        JTextField tf = new JTextField(String.valueOf(holiday.holidayName));
        tf.setEditable(false);
        tf.setBounds(190, 30, 300, 30);

        JLabel labelGifts = new JLabel("Gift ideas:");
        labelGifts.setBounds(10, 70, 200, 30);

        List<String> list = webSearch.giftSearchHoliday(holiday.holidayName);
        JTextArea area = new JTextArea(16, 50);
        for (String s: list) {
            area.append(s + "\n");
        }
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10,110, 350,500);

        BufferedReader reader;
        List<InternetAddress> personEmailList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(
                    "resources/Birthdays.txt"));
            String line = reader.readLine();
            while (line != null) {
                Person p = BirthdayFile.fromLineToPerson(line);
                if (Objects.equals(holiday.getHolidayName(), "8 березня") && Objects.equals(p.getSex(), "F")) personEmailList.add(p.getEmail());
                else if (Objects.equals(holiday.getHolidayName(), "14 жовтня") && Objects.equals(p.getSex(), "M")) personEmailList.add(p.getEmail());
                else if (!Objects.equals(holiday.getHolidayName(), "14 жовтня") && !Objects.equals(holiday.getHolidayName(), "8 березня")) personEmailList.add(p.getEmail());
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | ParseException | AddressException e) {
            e.printStackTrace();
        }
        InternetAddress[] personEmail = new InternetAddress[personEmailList.size()];
        for(int i = 0; i < personEmailList.size(); i++) personEmail[i] = personEmailList.get(i);

        JLabel labelMSG = new JLabel("Generated Message:");
        labelMSG.setBounds(380, 70, 200, 30);

        String msg = GenerateMSG.generateMessage(holiday.getHolidayName());
        String subject = "Happy Holidays";
        JTextArea sendEmail = new JTextArea(16, 50);
        sendEmail.append(msg);
        sendEmail.setEditable(true);
        JScrollPane scrollEmail = new JScrollPane(sendEmail);
        scrollEmail.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollEmail.setBounds(380,110, 300,200);
        JButton buttonEmail = new JButton("Send");
        buttonEmail.setBounds(380, 580, 300, 30);
        buttonEmail.addActionListener(e -> {
            try {
                MailSend.generateAndSendEmailMulti(subject, sendEmail.getText(), personEmail);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        });

        JLabel labelTo = new JLabel("Sending to: ");
        labelTo.setBounds(380, 320, 300, 30);

        JTextArea sendTo = new JTextArea(16, 50);
        sendTo.append(msg);
        sendTo.setEditable(false);
        JScrollPane scrollTo = new JScrollPane(sendTo);
        scrollTo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTo.setBounds(380,360, 300,200);

        frameHoliday.add(tf);
        frameHoliday.add(label);
        frameHoliday.add(scroll);
        frameHoliday.add(labelGifts);
        frameHoliday.add(labelMSG);
        frameHoliday.add(scrollEmail);
        frameHoliday.add(buttonEmail);
        frameHoliday.add(labelTo);
        frameHoliday.add(scrollTo);
        frameHoliday.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameHoliday.setSize(700, 700);
        frameHoliday.setLayout(null);
        frameHoliday.setVisible(true);
    }

    static void frameBDay(Person person) throws IOException {
        JFrame frameHoliday = new JFrame("Send holiday MSG");

        JLabel label = new JLabel("Information: ");
        label.setBounds(80, 30, 200, 30);

        JTextField tf = new JTextField(String.valueOf(person));
        tf.setEditable(false);
        tf.setBounds(190, 30, 300, 30);

        JLabel labelGifts = new JLabel("Gift ideas:");
        labelGifts.setBounds(10, 70, 200, 30);

        List<String> list = webSearch.giftSearchBday(person);
        JTextArea area = new JTextArea(16, 100);
        for (String s: list) {
            area.append(s + "\n");
        }
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10,110, 350,500);

        JLabel labelMSG = new JLabel("Generated Message:");
        labelMSG.setBounds(380, 70, 200, 30);

        String msg = GenerateMSG.generateMessage(person, "Birthday");
        String subject = "Happy Birthday " + person.getName();
        JTextArea sendEmail = new JTextArea(16, 50);
        sendEmail.append(msg);
        sendEmail.setEditable(true);
        JScrollPane scrollEmail = new JScrollPane(sendEmail);
        scrollEmail.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollEmail.setBounds(380,110, 300,200);
        JButton buttonEmail = new JButton("Send");
        buttonEmail.setBounds(380, 320, 300, 30);
        buttonEmail.addActionListener(e -> {
            try {
                MailSend.generateAndSendEmail1(subject, sendEmail.getText(), person.getEmail());
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        });

        frameHoliday.add(tf);
        frameHoliday.add(label);
        frameHoliday.add(scroll);
        frameHoliday.add(labelGifts);
        frameHoliday.add(labelMSG);
        frameHoliday.add(scrollEmail);
        frameHoliday.add(buttonEmail);
        frameHoliday.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameHoliday.setSize(700, 700);
        frameHoliday.setLayout(null);
        frameHoliday.setVisible(true);
    }


}
