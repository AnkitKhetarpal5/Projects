package Cruise;

import Exceptions.*;
import GUI.EndGUI;

public class CruiseShip {
    private static double distanceTravelled=0;
    private static double payback;
    static String currentIsland;
    private int currentFuel;
    private double currentSpeed;
    private double currentPassengersCount;
    Boolean exploded=false;
    Boolean engineON=false;
    Passengers passengers = new Passengers();
    String[] nameOfIslands=passengers.getNameOfIslands();
    EndGUI end;
    public String getCurrentIsland(){
        if(distanceTravelled==0){
            return nameOfIslands[0];
        }
        if(distanceTravelled>=800){
            return nameOfIslands[1];
        }
        if(distanceTravelled>=1600){
            return nameOfIslands[2];
        }
        if(distanceTravelled>=2400){
            return nameOfIslands[3];
        }
        if(distanceTravelled>=3200){
            return nameOfIslands[4];
        }
        if(distanceTravelled>=4000){
            return nameOfIslands[5];
        }
        if(distanceTravelled>=4800){
            return nameOfIslands[6];
        }
        if(distanceTravelled>=5600){
            return nameOfIslands[7];
        }
        if(distanceTravelled>=6400){
            return nameOfIslands[8];
        }
        return "The ship is moving or standstill.";
    }

    public void getPassengers(){
        String[] nameofPassengers=passengers.getNameOfPassengers(4);

        if(distanceTravelled==0){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=800){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=1600){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=2400){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=3200){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=4000){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=4800){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=5600){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
        if(distanceTravelled>=6400){
            for (int i=0 ; i<4;i++ ){
                System.out.print(" "+nameofPassengers[i]);
                System.out.print(passengers.getBoardPass());
                System.out.print(passengers.getCost());
            }
        }
    }
    public void setFuel(int currentFuel){
        if(currentFuel>=500){
            exploded=true;
        }
        this.currentFuel = currentFuel;
    }

    public double getFuel(){
        return currentFuel;
    }
    public double getDistanceTravelled(){
        return distanceTravelled;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void startEngine() throws CruiseExplodedException, CruiseDoesNotHaveFuelException, CruiseShipEngineAlreadyOnException {
    if(exploded){
        throw new CruiseExplodedException("Cruise Exploded, you can not start the Engine.");

    }
    if(engineON){
            throw new CruiseShipEngineAlreadyOnException("The engine is already On, DO not restart!");
    }
    if(currentFuel>=10){
        currentFuel-=10;
        engineON=true;
    }else{
        throw new CruiseDoesNotHaveFuelException("Please Add at least 10 coals of Fuel to start.");
    }

    }
    public void stopEngine() throws CruiseShipMotorOffException, CruiseExplodedException {
        if(exploded){
            throw new CruiseExplodedException("You can not stop, the Cruise Exploded.");
        }
        if(engineON){
            engineON=false;
            currentFuel=0;
        }else{
            throw new CruiseShipMotorOffException("The motor is already off, please turn it ON first!");
        }
    }
    public void addFuel(String currentFuel) throws CruiseExplodedException, CruiseShipEngineAlreadyOnException {
        if(exploded){
            throw new CruiseExplodedException("You can not add fuel, the Cruise Exploded.");
        }
        if(engineON){
            throw new CruiseShipEngineAlreadyOnException("Please turn OFF the motor to go add fuel.");
        }else{
            setFuel(Integer.parseInt(currentFuel));
        }
    }
    public void goForward() throws CruiseExplodedException, CruiseShipMotorOffException, CruiseDoesNotHaveFuelException, CruiseOutOfControlException {
        if(exploded){
            throw new CruiseExplodedException("You can not go forward, the Cruise ship Exploded.");
        }
        if(!engineON){
            throw new CruiseShipMotorOffException("Please turn ON the engine to go forward.");
        }
        if(currentFuel>0){
            distanceTravelled+=(currentFuel/2);
            currentSpeed=currentFuel/2;
            currentFuel=currentFuel/2;
        }else{
            throw new CruiseDoesNotHaveFuelException("Please add fuel to go forward.");
        }
        if(currentSpeed>=200){
            throw new CruiseOutOfControlException(passengers.getSpeedMessages());
        }
    }
}
