package behavioral.b2_mediator.chat_2;

/**
 * Mediator interface
 */
public interface ChatMediator {
    public void sendMessage(String msg, User user);
    void addUser(User user);
}
