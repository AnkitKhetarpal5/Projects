package GUI;

import Cruise.CruiseShip;

import javax.swing.*;

public class EndGUI extends JFrame {
    CruiseShip cruiseShip;

    public EndGUI(CruiseShip cruiseShip){
        this.cruiseShip = this.cruiseShip;
        setTitle("End of Ship");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
