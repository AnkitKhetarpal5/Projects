package GUI;

import Cruise.CruiseShip;
import Cruise.InputVerify;
import Cruise.Passengers;
import Exceptions.CruiseShipExceptions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CruiseShipGUI extends JFrame implements ActionListener, FocusListener {
    CruiseShip cruiseShip;
    Passengers passengers = new Passengers();
    private JButton motorOnButton = new JButton("MOTOR ON");
    private JButton motorOffButton = new JButton("MOTOR OFF");
    private JButton addFuel = new JButton("ADD FUEL");
    private JButton goForward = new JButton("GO FORWARD");
    private JTextField enterFuel = new JTextField("0");
    private JLabel displayFuel = new JLabel("Current Fuel: ");
    private JLabel informationDisplay = new JLabel("This has information regarding your cruise.");
    private JLabel informationOfIslands = new JLabel("");

    public CruiseShipGUI(CruiseShip cruiseShip) {
        setTitle("Cruise Ship");
        this.cruiseShip=cruiseShip;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        motorOnButton.setBorder(border);
        motorOffButton.setBorder(border);
        addFuel.setBorder(border);
        goForward.setBorder(border);
        enterFuel.setBorder(border);
        displayFuel.setBorder(border);
        informationDisplay.setBorder(border);
        informationDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        displayFuel.setHorizontalAlignment(SwingConstants.CENTER);
        enterFuel.setHorizontalAlignment(SwingConstants.CENTER);
        informationOfIslands.setHorizontalAlignment(SwingConstants.CENTER);
        informationOfIslands.setText("We are at "+cruiseShip.getCurrentIsland());

        motorOnButton.addActionListener(this);
        motorOffButton.addActionListener(this);
        addFuel.addActionListener(this);
        goForward.addActionListener(this);
        enterFuel.addFocusListener(this);

        add(motorOnButton);
        add(motorOffButton);
        add(addFuel);
        add(goForward);
        add(enterFuel);
        add(displayFuel);
        add(informationDisplay);
        add(informationOfIslands);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(700, 500);
        setLayout(new GridLayout(4, 2, 5, 5));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "MOTOR ON":
                    cruiseShip.startEngine();
                    informationDisplay.setForeground(Color.GREEN);
                    informationDisplay.setText("You are ready to go forward.");
                    displayFuel.setText(Double.toString(cruiseShip.getFuel()));
                    break;
                case "MOTOR OFF":
                    cruiseShip.stopEngine();
                    displayFuel.setText(Double.toString(cruiseShip.getFuel()));
                    break;
                case "ADD FUEL":
                    enterFuel.setInputVerifier(new InputVerify());
                    cruiseShip.addFuel(enterFuel.getText());
                    displayFuel.setText(Double.toString(cruiseShip.getFuel()));
                    informationDisplay.setForeground(Color.GREEN);
                    informationDisplay.setText("You have added "+cruiseShip.getFuel()+" fuel to your ship.");
                    break;
                case "GO FORWARD":
                    cruiseShip.goForward();
                    displayFuel.setText(Double.toString(cruiseShip.getFuel()));
                    informationOfIslands.setText(cruiseShip.getCurrentIsland());
                    informationDisplay.setText("You have moved "+cruiseShip.getDistanceTravelled()+"km and your ship fuel is: "+cruiseShip.getFuel()+"litres");
                    cruiseShip.getPassengers();
                    break;
                default:
                    break;
            }
        }catch(CruiseShipExceptions exception){
            informationDisplay.setForeground(Color.RED);
            informationDisplay.setText(exception.getMessage());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        enterFuel.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}