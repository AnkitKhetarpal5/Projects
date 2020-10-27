package Cruise;

import java.util.Random;

public class Passengers {
    private static String[] nameOfPassengers = {"Mohit","Ankit","Shri","JK","Jeel","Abin","Pratibha","Deesha","Triandra","Malav","Nikunj","Yash","Oshin","Ranjit","Siddhant","Snehpal","Shubham"};
    private static String[] nameOfIslands = {"Bali","Bora Bora","Maui","Capri","Tahiti","Hvar","Kauai","Montreal"};
    private static String[] speedMessages = {"Outrageous, I want my money back.","How dare you scare me like that?","What is wrong with you?"};
    private static String[] islandsMessages = {"What a beautiful island?","I want to spend the rest of my days here.","No free drinks? Too expensive."};
    private static String[] boardPasses={"BRONZE","SILVER","GOLD"};
    private static int[] cost={300,500,900};

    Random rand = new Random();

    public String[] getNameOfPassengers(int size){
        int randomNumber = rand.nextInt(size);
        String[] namesOfPassengers = new String[randomNumber];
        for (int i=0;i<randomNumber;i++){
            namesOfPassengers[i]=nameOfPassengers[i];
        }
        return namesOfPassengers;
    }
    public String[] getNameOfIslands(int size){
        int randomNumber = rand.nextInt(size);
        String[] namesOfIslands = new String[randomNumber];
        for (int i=0;i<randomNumber;i++){
            namesOfIslands[i]=nameOfIslands[i];
        }
        return namesOfIslands;
    }
    public String getBoardPass(){
        int randomNumber = rand.nextInt(3);
        return boardPasses[randomNumber];
    }
    public String getDestination(){
        int randomNumber = rand.nextInt(8);
        return nameOfIslands[randomNumber];
    }
    public String getSpeedMessages(){
        int randomNumber = rand.nextInt(8);
        return speedMessages[randomNumber];
    }
    public String getIslandMessages(){
        int randomNumber = rand.nextInt(8);
        return islandsMessages[randomNumber];
    }
    public String[] getNameOfIslands(){
        return nameOfIslands;
    }
    public int[] getCost(){
        return cost;
    }

}
