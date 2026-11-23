import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    record Expense(String name, double amount, String category) {}

    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add expense  2. List all  3. Total  4. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Amount (€): ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    expenses.add(new Expense(name, amount, cat));
                    System.out.println("Added!");
                }
                case "2" -> expenses.forEach(e ->
                        System.out.printf("%-15s €%.2f  [%s]%n", e.name(), e.amount(), e.category()));
                case "3" -> System.out.printf("Total: €%.2f%n",
                        expenses.stream().mapToDouble(Expense::amount).sum());
                case "4" -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
