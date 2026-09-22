import java.util.Scanner;

/**
 * Campus Cafe Ordering System
 * BBC 2 - OOP Java Programming Group Assignment
 *
 * Demonstrates:
 *   - Ternary statements
 *   - For loop
 *   - While loop
 *   - Do-while loop
 *
 * Group Members:
 *   1. _Nannyomo Elizabeth. 25/U/15519/PS
 *   2.Sserulyo Stuart 25/U/1275
 *   3. Mugabe Marvin 25/U/14448/EVE
 *   4.Atusiimirwe Rabecca.  25/U/12324/EVE
 *   5. Kyambadde Reagan. 25/U/15183/PS
 */
public class CampusCafeOrderingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu data
        String[] menuItems = {"Chapati", "Rolex", "Chips", "Soda", "Chicken"};
        double[] menuPrices = {1000, 2500, 5000, 1500, 8000};

        double cartTotal = 0;
        boolean keepOrdering = true;

        System.out.println("=====================================");
        System.out.println("   WELCOME TO THE CAMPUS CAFE SYSTEM  ");
        System.out.println("=====================================");

        // ---------- DO-WHILE LOOP ----------
        // Keeps the ordering session running until the student chooses to stop.
        do {
            // ---------- FOR LOOP ----------
            // Displays every item on the menu with its price.
            System.out.println("\n--- MENU ---");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". " + menuItems[i] + " - UGX " + menuPrices[i]);
            }

            System.out.print("\nEnter item number to order (1-" + menuItems.length + "): ");
            int choice = -1;

            // ---------- WHILE LOOP ----------
            // Keeps asking until the student enters a valid menu number.
            while (choice < 1 || choice > menuItems.length) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > menuItems.length) {
                        System.out.print("Invalid choice. Please enter a number between 1 and "
                                + menuItems.length + ": ");
                    }
                } else {
                    System.out.print("Please enter a valid number: ");
                    scanner.next(); // discard invalid input
                }
            }

            System.out.print("Enter quantity: ");
            int quantity = -1;
            while (quantity < 1) {
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    if (quantity < 1) {
                        System.out.print("Quantity must be at least 1. Try again: ");
                    }
                } else {
                    System.out.print("Please enter a valid number: ");
                    scanner.next();
                }
            }

            double itemTotal = menuPrices[choice - 1] * quantity;
            cartTotal += itemTotal;

            System.out.println(quantity + " x " + menuItems[choice - 1]
                    + " added. Subtotal: UGX " + itemTotal);

            // ---------- TERNARY STATEMENT ----------
            // Quick status message depending on how much has been spent so far.
            String spendingStatus = (cartTotal >= 10000) ? "Big spender! 🎉" : "Still browsing...";
            System.out.println("Cart total so far: UGX " + cartTotal + " (" + spendingStatus + ")");

            System.out.print("\nOrder another item? (y/n): ");
            String response = scanner.next();

            // ---------- TERNARY STATEMENT ----------
            // Decides whether to continue the do-while loop.
            keepOrdering = response.equalsIgnoreCase("y") ? true : false;

        } while (keepOrdering);

        // ---------- TERNARY STATEMENT ----------
        // Apply a 10% discount automatically if the total is UGX 15,000 or more.
        double discount = (cartTotal >= 15000) ? cartTotal * 0.10 : 0;
        double finalTotal = cartTotal - discount;

        System.out.println("\n=====================================");
        System.out.println("           ORDER SUMMARY");
        System.out.println("=====================================");
        System.out.println("Subtotal:  UGX " + cartTotal);
        System.out.println("Discount:  UGX " + discount);
        System.out.println("TOTAL DUE: UGX " + finalTotal);
        System.out.println("=====================================");
        System.out.println("Thank you for ordering at the Campus Cafe!");

        scanner.close();
    }
}
