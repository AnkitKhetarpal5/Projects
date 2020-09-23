package shamim.hamburgers;
import java.util.Scanner;
public class HamburgerMain {
    public static void main(String[] args) {
        System.out.println("\t\t####################################");
        System.out.println("\t\t#    Welcome To Shamim Hamburger   #");
        System.out.println("\t\t####################################\n");
        System.out.println("Please Choose Hamburger Type : \n");
        System.out.println("1. Basic Hamburger  2. Healthy Hamburger  3. Deluxe Hamburger");

        Scanner input = new Scanner(System.in);
        double price = 0;
        
        String[] item3 = {"Tomato", "Lettuce", "Cheese", "Carrot", "Exit"};
        int i = input.nextInt();
        switch (i) {
            case 1:
                Hamburger basic = new Hamburger("Basic", "White roll ", "Sausage", 3.56);
                basic.TypeOfHamburger();
                System.out.println("--------------------------------------------------------------------");
                basic.set_item(item3);
                
                price = basic.Addprice(basic.AddItems());
               
                System.out.println("\nPrice of Additons is :" + price);
                System.out.printf("Basic price is :%.2f \n", basic.get_basicprice());
                System.out.printf("Total Price is :%.2f \n", basic.TotalPrice(price));
                
                break;
            case 2:
                HealthyHamburger Healthy = new HealthyHamburger("Healthy", "Brown rye roll", "Bacon", 5.67);
                Healthy.TypeOfHamburger();
                System.out.println("--------------------------------------------------------------------");
                price = Healthy.Addprice(Healthy.AddItems());
                System.out.println("\nPrice of Additons is : " + price);
                
                System.out.printf("Basic price is :%.2f " , Healthy.get_basicprice());
                System.out.printf("Total Price is :%.2f \n", Healthy.TotalPrice(price));
               
                    break;
            case 3:
                Hamburger Deluxe = new DeluxeHamburger("Deluxe ", "White roll ", "Sausage & Bacon", 14.54);
                Deluxe.TypeOfHamburger();
                System.out.println("--------------------------------------------------------------------");
                price = Deluxe.Addprice(Deluxe.AddItems()); 
                
                System.out.printf("\nPrice of Additons is :%.2f \n", price);
                System.out.printf("Basic price is :%.2f \n" , Deluxe.get_basicprice());
                System.out.printf("Total Price is :%.2f \n", Deluxe.TotalPrice(price));
                break;                                    
        }
    }
}

