import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner sc = new Scanner(System.in);
        // Initial test data
        library.addBook(new Book("B01", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("B02", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("B03", "Java: A Beginner's Guide", "Herbert Schildt"));
        boolean running = true;
        while (running) {
            System.out.println("\n--- Campus Library Console ---");
            System.out.println("1. View Catalog");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Select option: ");
            String input = sc.nextLine().trim();
            switch (input) {
                case "1" -> {
                    if (library.getCatalog().isEmpty()) {
                        System.out.println("Catalog is empty.");
                    } else {
                        library.getCatalog().forEach(System.out::println);
                    }
                }
                case "2" -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    System.out.println("Book registered.");
                }
                case "3" -> {
                    System.out.print("Enter Book ID to borrow: ");
                    String id = sc.nextLine();
                    if (library.checkOut(id)) {
                        System.out.println("Done! Book issued.");
                    } else {
                        System.out.println("Operation failed: Book unavailable or ID invalid.");
                    }
                }
                case "4" -> {
                    System.out.print("Enter Book ID to return: ");
                    String id = sc.nextLine();
                    if (library.checkIn(id)) {
                        System.out.println("Done! Book returned.");
                    } else {
                        System.out.println("Operation failed: Book was not checked out or ID invalid.");
                    }
                }
                case "5" -> {
                    running = false;
                    System.out.println("Session closed.");
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
        sc.close();
    }
}