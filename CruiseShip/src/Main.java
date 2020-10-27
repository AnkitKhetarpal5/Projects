import Cruise.CruiseShip;
import GUI.*;
public class Main {
    public static void main(String[] args) {
        CruiseShip cruiseShip = new CruiseShip();
        new CruiseShipGUI(cruiseShip);
        new ControlCenterGUI(cruiseShip);
    }
}