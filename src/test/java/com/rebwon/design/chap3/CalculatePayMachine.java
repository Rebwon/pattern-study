package com.rebwon.design.chap3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class CalculatePayMachine extends Frame implements ActionListener, DocumentListener {
    private JLabel workingHoursLabel = new JLabel("Working Hours = ", Label.RIGHT);
    private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = ", Label.RIGHT);
    private JLabel payAmountLabel = new JLabel("Pay Amount = ", Label.RIGHT);

    private JTextField tfWorkingHours = new JTextField();
    private JTextField tfOverTimeHours = new JTextField();
    private JTextField tfResult = new JTextField();

    private JButton calcButton = new JButton("Calculate");
    private JButton resetButton = new JButton("Reset");
    private JButton end = new JButton("Stop");

    public CalculatePayMachine() {
        super("Payment Calculation");

        this.init();
        this.start();
        this.setSize(500, 250);
        this.setVisible(true);
    }

    private void start() {
        calcButton.addActionListener(this);
        resetButton.addActionListener(this);

        tfWorkingHours.getDocument().addDocumentListener(this);
        tfOverTimeHours.getDocument().addDocumentListener(this);

        end.addActionListener(this);

        calcButton.setEnabled(false);
        resetButton.setEnabled(false);
    }

    private void init() {
        this.setLayout(new GridLayout(5, 1));

        Panel p = new Panel(new BorderLayout());
        p.add("West", workingHoursLabel);
        p.add("Center", tfWorkingHours);
        this.add(p);

        Panel p1 = new Panel(new BorderLayout());
        p1.add("West", overTimeHoursLabel);
        p1.add("Center", tfOverTimeHours);
        this.add(p1);

        Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        p2.add(calcButton);
        this.add(p2);

        Panel p3 = new Panel(new BorderLayout());
        p3.add("West", payAmountLabel);
        p3.add("Center", tfResult);
        this.add(p3);

        Panel p4 = new Panel(new BorderLayout());
        p4.add(resetButton);
        p4.add(end);
        this.add(p4);
    }

    public boolean isDataEntered() {
        if(tfWorkingHours.getText().trim().length() == 0 ||
            tfOverTimeHours.getText().trim().length() == 0)
            return false;
        return true;
    }

    public void checkData() {
        calcButton.setEnabled(isDataEntered());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == end) {
            System.exit(0);
        }

        if(e.getSource() == resetButton) {
            tfWorkingHours.setText("");
            tfOverTimeHours.setText("");
            tfWorkingHours.requestFocus();
            tfResult.setText("");
            resetButton.setEnabled(false);
            return;
        }

        if(e.getSource() == calcButton) {
            int x;
            try {
                x = Integer.parseInt(tfWorkingHours.getText().trim());
            } catch (NumberFormatException ex) {
                tfWorkingHours.setText("");
                tfWorkingHours.requestFocus();
                return;
            }

            int y;
            try {
                y = Integer.parseInt(tfOverTimeHours.getText().trim());
            } catch (NumberFormatException ex) {
                tfOverTimeHours.setText("");
                tfOverTimeHours.requestFocus();
                return;
            }

            int payAmount;
            payAmount = 10 * x + 15 * y;

            tfResult.setText(String.valueOf(payAmount));
            resetButton.setEnabled(true);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkData();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkData();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkData();
    }
}
