package Cruise;

import Exceptions.CruiseShipInvalidFuelEnteredException;
import javax.swing.*;

public class InputVerify extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            double value = Double.parseDouble(text);
            if(value>=10 && value<=100) {
                return true;
            }
            else {
            throw new CruiseShipInvalidFuelEnteredException("Please enter a valid Fuel value between 10 and 100 inclusively.");
            }
        } catch (CruiseShipInvalidFuelEnteredException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}