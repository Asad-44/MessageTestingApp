import java.util.Date;

class Message {
    private String content;
    private String sender;
    private String receiver;
    private Date timestamp;
    private boolean isRead;

    public Message(String content, String sender, String receiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = new Date();
        this.isRead = false;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public void markAsUnread() {
        this.isRead = false;
    }

    @Override
    public String toString() {
        return "From: " + sender + " | To: " + receiver + " | Message: " + content +
                " | Sent at: " + timestamp + " | Status: " + (isRead ? "Read" : "Unread");
    }

}
