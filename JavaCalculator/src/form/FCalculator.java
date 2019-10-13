/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import operations.Operations;

/**
 *
 * @author Dalibor
 */
public class FCalculator extends JFrame {

    /**
     * @param args the command line arguments
     */
    private final Operations operations;

    private JLabel labelA;
    private JTextField txtFieldA;
    private JLabel labelB;
    private JTextField txtFieldB;
    private JLabel labelC;
    private JTextField txtFieldC;

    private JButton addBtn;
    private JButton subtractBtn;

    public FCalculator() {
        this.operations = Operations.getInstance();
        prepareForm();
    }

    private void prepareForm() {
        this.setLocationRelativeTo(null);
        this.setTitle("Calculator");

        this.initComponents();
        this.addComponents();

        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(300, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addBtn.addActionListener(
                (event) -> this.addBtnListener()
        );

        this.subtractBtn.addActionListener(
                (event) -> this.subtractBtnListener()
        );

    }

    private void initComponents() {
        this.labelA = new JLabel("A:");
        this.txtFieldA = new JTextField();
        this.labelB = new JLabel("B:");
        this.txtFieldB = new JTextField();
        this.labelC = new JLabel("C:");
        this.txtFieldC = new JTextField();
        this.txtFieldC.setEditable(false);
        this.addBtn = new JButton("Add");
        this.subtractBtn = new JButton("Subtract");
    }

    private void addComponents() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(25, 40, 25, 40)));
        GridLayout layout = new GridLayout(4, 2, 4, 4);
        layout.preferredLayoutSize(this.getContentPane());
        panel.setLayout(layout);
        this.getContentPane().add(panel);

        panel.add(this.labelA);
        panel.add(this.txtFieldA);
        panel.add(this.labelB);
        panel.add(this.txtFieldB);
        panel.add(this.labelC);
        panel.add(this.txtFieldC);

        panel.add(this.addBtn);
        panel.add(this.subtractBtn);

        this.pack();

    }

    private void prepareForCalculation(String operator) {
        String txtA = txtFieldA.getText();
        String txtB = txtFieldB.getText();
        if (!txtA.isEmpty() && !txtB.isEmpty()) {
            txtFieldA.setBorder(null);
            txtFieldB.setBorder(null);
            try {
                int a = Integer.parseInt(txtFieldA.getText());
                int b = Integer.parseInt(txtFieldB.getText());
                int c = Operations.doOperation(a, b, operator);
                txtFieldC.setText(Integer.toString(c));
            } catch(NumberFormatException e){
                txtFieldA.setBorder(new LineBorder(Color.red, 2));
                txtFieldB.setBorder(new LineBorder(Color.red, 2));
                txtFieldC.setText("Must be numbers!");
            }

        } else {
            if (txtA.isEmpty()) {
                txtFieldA.setBorder(new LineBorder(Color.red, 2));
            }
            if (txtB.isEmpty()) {
                txtFieldB.setBorder(new LineBorder(Color.red, 2));
            }
        }

    }

    private void addBtnListener() {
        prepareForCalculation("+");
    }

    private void subtractBtnListener() {
        prepareForCalculation("-");
    }

}
