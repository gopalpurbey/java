import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class telephone {
    private Map<String, String> directory = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        telephone app = new telephone();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nTelephone Directory");
            System.out.println("1. Add Record");
            System.out.println("2. Show All Records");
            System.out.println("3. Search Record");
            System.out.println("4. Modify Record");
            System.out.println("5. Delete Record");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addRecord();
                    break;
                case 2:
                    showRecords();
                    break;
                case 3:
                    searchRecord();
                    break;
                case 4:
                    modifyRecord();
                    break;
                case 5:
                    deleteRecord();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addRecord() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        directory.put(name, phone);
        System.out.println("Record added successfully.");
    }

    private void showRecords() {
        if (directory.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Map.Entry<String, String> entry : directory.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
        }
    }

    private void searchRecord() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        String phone = directory.get(name);
        if (phone != null) {
            System.out.println("Name: " + name + ", Phone: " + phone);
        } else {
            System.out.println("Record not found.");
        }
    }

    private void modifyRecord() {
        System.out.print("Enter name to modify: ");
        String name = scanner.nextLine();
        if (directory.containsKey(name)) {
            System.out.print("Enter new phone number: ");
            String phone = scanner.nextLine();
            directory.put(name, phone);
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    private void deleteRecord() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        if (directory.remove(name) != null) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }
}
