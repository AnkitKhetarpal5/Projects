package GUI;

import Cruise.CruiseShip;

import javax.swing.*;

public class ControlCenterGUI extends JFrame {
    private JLabel lblPassengerInformation = new JLabel("This is the information");
    private JLabel lblspeedOfCruise = new JLabel("Current speed: ");
    CruiseShip cruiseShip;

    public ControlCenterGUI(CruiseShip cruiseShip){
        this.cruiseShip = this.cruiseShip;
        setTitle("Control Center");
        lblPassengerInformation.setBounds(0, 50, 300, 30);
        lblPassengerInformation.setHorizontalAlignment(SwingConstants.CENTER);
        lblspeedOfCruise.setBounds(0, 150, 300, 30);
        lblspeedOfCruise.setHorizontalAlignment(SwingConstants.CENTER);

        add(lblPassengerInformation);
        add(lblspeedOfCruise);
        if(cruiseShip.getCurrentSpeed()>=200){
            JOptionPane.showMessageDialog(this, "Alert! The speed is 200.");
        }

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 300);
        //setLayout(new GridLayout(8, 1, 5, 5));
        setLocation(300,500);
        setVisible(true);
    }

}
