package shamim.hamburgers;
import java.util.Scanner;
public class HealthyHamburger extends Hamburger
{
    public HealthyHamburger(String hamburgername, String breadtype, String meattype, double basicprice)
    {
       super(hamburgername,breadtype,meattype,basicprice);      
    }    
    private int numberitems;
    private String[] item2 = new String[6]; // Empty array for store additems
    public String[] AddItems() {
      String[] item_healthy = {"Tomato", "Lettuce", "Cheese", "Carrot", "Egg", "Lentils", "Exit"};
        boolean flag = true; // for exit
        System.out.println("You can add other items :\n");
        System.out.println("1.Tomato , 2.Lettuce , 3.Cheese , 4.Carrot , 5.Egg , 6.Lentils , 7.Exit : \n");
        //System.out.println(item_healthy);
           for (numberitems = 0; numberitems < 6; numberitems++) {
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Added Tomato for an extra 0.27");
                    break;
                case 2:
                    System.out.println("Added Lettuce for an extra 0.75");
                    break;
                case 3:
                    System.out.println("Added Cheese for an extra 1.13");
                    break;
                case 4:
                    System.out.println("Added Carrot for an extra 0.35");
                    break;
                case 5:
                     System.out.println("Added Egg for an extra 5.43");
                    break;
                case 6:
                     System.out.println("Added Lentils for an extra 3.41");
                    break;
                default:
                    flag = false;
                    numberitems = 6;  // Break the For loop Condition
            }
            if (flag)
            {
                item2[numberitems] = item_healthy[i - 1];
            }
        } // End of for Loop
        
       System.out.print("\nYou Added: ");
        for (String singleItem : item2) 
        {
            if (singleItem != null)
              {
                System.out.print(singleItem + "  ");
              }
        }
        
        return item2;
    }
       private double itemprice = 0;
       private double addprice = 0;
       public double Addprice(String[] item2) {
        for (String singleItem : item2) {
            addition = singleItem;
            if (addition != null)
            {
                switch (addition)
                {
                    case "Tomato":
                        itemprice = 0.27;
                        break;
                    case "Lettuce":
                        itemprice = 0.75;
                        break;
                    case "Cheese":
                        itemprice = 1.13;
                        break;
                    case "Carrot":
                        itemprice = 0.35;
                        break;
                    case "Egg":
                        itemprice = 5.43;
                        break;
                    case "Lentils":
                        itemprice = 3.41;
                        break;                        
                    
                    default:
                }
                addprice = addprice + itemprice;
            }
        }
        return addprice;
    }
    //@Override
        public double TotalPrice(double price) {
        return (get_basicprice() + addprice);
   }
}
