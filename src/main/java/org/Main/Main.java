package org.Main;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write a value for limit:");
        double limit = input.nextDouble();

        CreditCard myCard = new CreditCard(limit);

        int endProgram = 1;

        while (endProgram != 0) {
            System.out.println("Do you want to add a item? (1)Yes (0)No");
            endProgram = input.nextInt();

            if (endProgram == 1) {
                System.out.println("Write the name of the item:");
                String name = input.next();

                System.out.println("Write the price of the item:");
                double price = input.nextDouble();

                Purchase purchase = new Purchase(name, price);
                boolean testBalance = myCard.includeItem(purchase);

                if (testBalance == false) {
                    System.out.println("You don't have enough limit!");
                    endProgram = 0;
                }
            }
        }

        Collections.sort(myCard.getPurchases());

        for (Purchase element: myCard.getPurchases()) {
            System.out.println(element.toString());
        }

        System.out.println("The balance of the card is: " + myCard.getBalance());
    }
}