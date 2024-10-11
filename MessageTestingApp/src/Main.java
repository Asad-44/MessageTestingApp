import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessagingApp app = new MessagingApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMessaging App Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Send Message");
            System.out.println("3. Display All Messages (Latest First)");
            System.out.println("4. Display Messages From Person");
            System.out.println("5. Delete a Message");
            System.out.println("6. Display Read Messages");
            System.out.println("7. Display Unread Messages");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    app.addContact(name);
                    break;

                case 2:
                    System.out.print("Enter receiver's name: ");
                    String receiver = scanner.nextLine();
                    System.out.print("Enter message content: ");
                    String content = scanner.nextLine();
                    app.sendMessage(content, receiver);
                    break;

                case 3:
                    app.displayMessagesSortedByTime();
                    break;

                case 4:
                    System.out.print("Enter receiver's name to filter: ");
                    String person = scanner.nextLine();
                    app.displayMessagesFromPerson(person);
                    break;

                case 5:
                    app.displayAllMessagesWithIndex();
                    System.out.print("Enter the index of the message to delete: ");
                    int indexToDelete = scanner.nextInt();
                    app.deleteMessage(indexToDelete);
                    break;

                case 6:
                    app.displayMessagesByStatus(true);
                    break;

                case 7:
                    app.displayMessagesByStatus(false);
                    break;

                case 0:
                    System.out.println("Exiting app...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
