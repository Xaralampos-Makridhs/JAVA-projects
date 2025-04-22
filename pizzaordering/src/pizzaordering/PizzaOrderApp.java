package pizzaordering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaOrderApp extends JFrame {
    private JTextField ordernoTextField, customernameTextField, quantityTextField, rateTextField, costofToppingsTextField, totalamountTextField;
    private JLabel companyLabel, ordernoLabel, customernameLabel, quantityLabel, rateLabel, costofToppingsLabel, totalamountLabel;
    private JCheckBox onionChk, cheeseChk, tomatoChk, babyCrustChk;
    private JButton calcRateBtn, calcTotalBtn, clearBtn;
    private JPanel pizzaPanel, toppingsPanel;
    private JRadioButton panpizzaBtn, stuffedpizzaBtn, regularpizzaBtn;
    private ButtonGroup pizzaGroup;

    public PizzaOrderApp() {
        setTitle("Pizza Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        companyLabel = new JLabel("Sthn pizza mas.", JLabel.CENTER);
        companyLabel.setBounds(250, 10, 150, 30);
        add(companyLabel);

        ordernoLabel = new JLabel("Order No:");
        ordernoLabel.setBounds(30, 60, 100, 25);
        add(ordernoLabel);

        ordernoTextField = new JTextField();
        ordernoTextField.setBounds(130, 60, 150, 25);
        add(ordernoTextField);

        customernameLabel = new JLabel("Customer Name:");
        customernameLabel.setBounds(30, 100, 120, 25);
        add(customernameLabel);

        customernameTextField = new JTextField();
        customernameTextField.setBounds(150, 100, 150, 25);
        add(customernameTextField);

        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(30, 140, 100, 25);
        add(quantityLabel);

        quantityTextField = new JTextField();
        quantityTextField.setBounds(130, 140, 150, 25);
        add(quantityTextField);

        rateLabel = new JLabel("Rate:");
        rateLabel.setBounds(330, 60, 100, 25);
        add(rateLabel);

        rateTextField = new JTextField();
        rateTextField.setBounds(430, 60, 150, 25);
        rateTextField.setEditable(false);
        add(rateTextField);

        costofToppingsLabel = new JLabel("Topping Cost:");
        costofToppingsLabel.setBounds(330, 100, 100, 25);
        add(costofToppingsLabel);

        costofToppingsTextField = new JTextField();
        costofToppingsTextField.setBounds(430, 100, 150, 25);
        costofToppingsTextField.setEditable(false);
        add(costofToppingsTextField);

        totalamountLabel = new JLabel("Total Amount:");
        totalamountLabel.setBounds(330, 140, 100, 25);
        add(totalamountLabel);

        totalamountTextField = new JTextField();
        totalamountTextField.setBounds(430, 140, 150, 25);
        totalamountTextField.setEditable(false);
        add(totalamountTextField);

        pizzaPanel = new JPanel();
        pizzaPanel.setBorder(BorderFactory.createTitledBorder("Pizza Type"));
        pizzaPanel.setBounds(30, 200, 250, 150);
        pizzaPanel.setLayout(null);

        panpizzaBtn = new JRadioButton("Pan Pizza");
        panpizzaBtn.setBounds(10, 20, 120, 20);
        pizzaPanel.add(panpizzaBtn);

        stuffedpizzaBtn = new JRadioButton("Stuffed Pizza");
        stuffedpizzaBtn.setBounds(10, 40, 120, 20);
        pizzaPanel.add(stuffedpizzaBtn);

        regularpizzaBtn = new JRadioButton("Regular Pizza");
        regularpizzaBtn.setBounds(10, 60, 120, 20);
        pizzaPanel.add(regularpizzaBtn);

        pizzaGroup = new ButtonGroup();
        pizzaGroup.add(panpizzaBtn);
        pizzaGroup.add(stuffedpizzaBtn);
        pizzaGroup.add(regularpizzaBtn);

        add(pizzaPanel);

        toppingsPanel = new JPanel();
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        toppingsPanel.setBounds(330, 200, 250, 150);
        toppingsPanel.setLayout(null);

        onionChk = new JCheckBox("Onion");
        onionChk.setBounds(10, 20, 120, 20);
        toppingsPanel.add(onionChk);

        cheeseChk = new JCheckBox("Cheese");
        cheeseChk.setBounds(10, 40, 120, 20);
        toppingsPanel.add(cheeseChk);

        tomatoChk = new JCheckBox("Tomato");
        tomatoChk.setBounds(130, 20, 120, 20);
        toppingsPanel.add(tomatoChk);

        babyCrustChk = new JCheckBox("Baby Crust");
        babyCrustChk.setBounds(130, 40, 120, 20);
        toppingsPanel.add(babyCrustChk);

        add(toppingsPanel);

        calcTotalBtn = new JButton("Calculate TOTAL");
        calcTotalBtn.setBounds(50, 350, 160, 30);
        add(calcTotalBtn);

        calcRateBtn = new JButton("Calculate RATE");
        calcRateBtn.setBounds(240, 350, 160, 30);
        add(calcRateBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(430, 350, 100, 30);
        add(clearBtn);

        calcRateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double rate = 0;
                if (panpizzaBtn.isSelected()) {
                    rate += 5.0;
                } else if (stuffedpizzaBtn.isSelected()) {
                    rate += 6.0;
                } else if (regularpizzaBtn.isSelected()) {
                    rate += 4.0;
                }

                double toppings = 0;
                if (onionChk.isSelected()) toppings += 0.5;
                if (cheeseChk.isSelected()) toppings += 1.0;
                if (tomatoChk.isSelected()) toppings += 0.5;
                if (babyCrustChk.isSelected()) toppings += 0.75;

                rateTextField.setText(String.valueOf(rate));
                costofToppingsTextField.setText(String.valueOf(toppings));
            }
        });

        calcTotalBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rate = Double.parseDouble(rateTextField.getText());
                    double toppings = Double.parseDouble(costofToppingsTextField.getText());
                    int quantity = Integer.parseInt(quantityTextField.getText());
                    double total = (rate + toppings) * quantity;
                    totalamountTextField.setText(String.valueOf(total));
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, "Please fill in the blank for the rate!");
                    ev.printStackTrace();
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ordernoTextField.setText("");
                customernameTextField.setText("");
                quantityTextField.setText("");
                rateTextField.setText("");
                costofToppingsTextField.setText("");
                totalamountTextField.setText("");
                pizzaGroup.clearSelection();
                onionChk.setSelected(false);
                cheeseChk.setSelected(false);
                tomatoChk.setSelected(false);
                babyCrustChk.setSelected(false);
            }
        });

        setVisible(true);
    }
   }