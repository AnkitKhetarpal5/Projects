package shamim.hamburgers;
import java.util.Scanner;
public class Hamburger {
    private String hamburgername;
    private String breadtype;
    private String meattype;
    private double basicprice;
    private double addprice = 0;
    private double itemprice = 0;
    private int numberitems = 0;
    public String addition;
    private String[] item1 = new String [5];
    public void set_item(String[] value) {
        this.item1 = value;
    }
    public String[] get_item() {
        return item1;
    }
    public void set_hamburgername(String value) {
        this.hamburgername = value;
    }
    public String get_hamburgername() {
        return hamburgername;
    }
    public void set_breadtype(String value) {
        this.breadtype = value;
    }
    public String get_breadtype() {
        return breadtype;
    }
    public void set_meattype(String value) {
        this.meattype = value;
    }
    public String get_meattype() {
        return meattype;
    }
    public void set_basicprice(double value) {
        this.basicprice = value;
    }
    public double get_basicprice() {
        return basicprice;
    }
    public Hamburger(String hamburgername, String breadtype, String meattype, double basicprice) {
        this.hamburgername = hamburgername;
        this.breadtype = breadtype;
        this.meattype = meattype;
        this.basicprice = basicprice;
    }
    public void TypeOfHamburger() {
        System.out.println(hamburgername + " hamburger  on a " + breadtype + " with " + meattype
                + ", price is : " + basicprice);
    }
    private String[] item2 = new String[4]; // Empty array for store additems
   
    public String[] AddItems() {
        boolean flag = true; // for exit
        System.out.println("You can add other items :\n");
        System.out.println("1.Tomato , 2.Lettuce , 3.Cheese , 4.Carrot , 5.Exit : \n");
        System.out.println();
        for (numberitems = 0; numberitems < 4; numberitems++) {
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Added " + item1[i-1] + "for an extra 0.27");
                    break;
                case 2:
                    System.out.println("Added " + item1[i-1] + " for an extra 0.75");
                    break;
                case 3:
                    System.out.println("Added " + item1[i-1] + " for an extra 1.13");
                    break;
                case 4:
                    System.out.println("Added " + item1[i-1] + " for an extra 0.35");
                    break;
                default:
                    flag = false;
                    numberitems = item1.length;
            }
            if (flag) {
                item2[numberitems] = item1[i - 1];
            }
        }
        System.out.print("\nYou Added: ");
        for (String singleItem : item2) {
            if (singleItem != null) {
                System.out.print(singleItem + "/");
            }
        }
        return item2;
    }

    public double Addprice(String[] item2) {
        for (String singleItem : item2) {
            addition = singleItem;
            if (addition != null) {
                switch (addition) {
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
                    default:
                }
                addprice = addprice + itemprice;
            }
        }

        return addprice;
    }

    public double TotalPrice(double price) {
        return (basicprice + addprice);
    }
}
