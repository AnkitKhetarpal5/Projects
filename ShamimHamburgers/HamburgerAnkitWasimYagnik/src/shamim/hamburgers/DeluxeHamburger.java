package shamim.hamburgers;
import java.util.Scanner;
public class DeluxeHamburger extends Hamburger {    
     public DeluxeHamburger(String hamburgername, String breadtype, String meattype, double basicprice)
    {
       super(hamburgername,breadtype,meattype,basicprice); 
    }    
    int numberitems;
    String[] item2 = new String[2]; 
    public String[] AddItems() {
      String[] item_deluxe = {"Chips", "Drink", "Exit"};
        boolean flag = true; // for exit
        System.out.println("You can add other items :\n");
        System.out.println("1.Chips , 2.Drink , 3.Exit : \n");
           for (numberitems = 0; numberitems < 2; numberitems++) {
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();                   
            switch (i) {
                case 1:
                    System.out.println("Added Chips for an extra 2.75");
                    break;
                case 2:
                    System.out.println("Added Drink for an extra 1.81");
                    break;
                default:
                    flag = false;
                    numberitems = 3;  
            }
            if (flag)
            {
                item2[numberitems] = item_deluxe[i - 1];
            }
        } 
        
       System.out.print("\nYou Added: ");
        for (String singleItem : item2) 
        {
            if (singleItem != null)
              {
                System.out.print(singleItem + " ");
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
                    case "Chips":
                        itemprice = 2.75;
                        break;
                    case "Drink":
                        itemprice = 1.81;
                        break;               
                    default:                      
                }
                addprice = addprice + itemprice;
            }
        }

        return addprice;
    }  
        public double TotalPrice(double price) {
        return (get_basicprice() + addprice);
   }
    
}
