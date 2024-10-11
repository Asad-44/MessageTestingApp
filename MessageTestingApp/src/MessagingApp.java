public class MessagingApp {
    private Contact[] contacts = new Contact[100];
    private Message[] messages = new Message[100];
    private int contactCount = 0;
    private int messageCount = 0;


    public void addContact(String name) {

        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getName().equals(name)) {
                System.out.println("Contact " + name + " already exists.");
                return;
            }
        }


        if (contactCount < contacts.length) {
            contacts[contactCount++] = new Contact(name);
            System.out.println("Contact " + name + " added.");
        } else {
            System.out.println("Contact list is full.");
        }
    }


    public void sendMessage(String content, String receiver) {
        if (contactCount == 0) {
            System.out.println("No contacts available. Add a contact first.");
            return;
        }

        boolean contactExists = false;
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getName().equals(receiver)) {
                if (messageCount < messages.length) {
                    messages[messageCount++] = new Message(content, "Computer", receiver);
                    contactExists = true;
                    System.out.println("Message sent to " + receiver);
                } else {
                    System.out.println("Message list is full.");
                }
                break;
            }
        }
        if (!contactExists) {
            System.out.println("Contact not found.");
        }
    }


    public void displayMessagesSortedByTime() {
        if (messageCount == 0) {
            System.out.println("No messages to display.");
            return;
        }

        for (int i = 0; i < messageCount - 1; i++) {
            for (int j = 0; j < messageCount - i - 1; j++) {
                if (messages[j].getTimestamp().before(messages[j + 1].getTimestamp())) {
                    Message temp = messages[j];
                    messages[j] = messages[j + 1];
                    messages[j + 1] = temp;
                }
            }
        }

        System.out.println("\nMessages (Latest First):");
        for (int i = 0; i < messageCount; i++) {
            System.out.println(i + ". " + messages[i]);
        }
    }


    public void displayMessagesFromPerson(String person) {
        boolean messageFound = false;
        for (int i = 0; i < messageCount; i++) {
            if (messages[i].getReceiver().equals(person)) {
                System.out.println(messages[i]);
                messageFound = true;
            }
        }
        if (!messageFound) {
            System.out.println("No messages found from " + person);
        }
    }


    public void deleteMessage(int index) {
        if (index >= 0 && index < messageCount) {

            for (int i = index; i < messageCount - 1; i++) {
                messages[i] = messages[i + 1];
            }
            messages[--messageCount] = null;
            System.out.println("Message deleted.");
        } else {
            System.out.println("Invalid message index.");
        }
    }


    public void displayAllMessagesWithIndex() {
        if (messageCount == 0) {
            System.out.println("No messages to display.");
            return;
        }

        System.out.println("\nMessages:");
        for (int i = 0; i < messageCount; i++) {
            System.out.println(i + ". " + messages[i]); // Display the message index
        }
    }

    public void displayMessagesByStatus(boolean isRead) {
        boolean messageFound = false;
        System.out.println("\nMessages (" + (isRead ? "Read" : "Unread") + "):");
        for (int i = 0; i < messageCount; i++) {
            if (messages[i].isRead() == isRead) {
                System.out.println(i + ". " + messages[i]); // Display the message with index
                messageFound = true;
            }
        }
        if (!messageFound) {
            System.out.println("No " + (isRead ? "read" : "unread") + " messages found.");
        }
    }

}
