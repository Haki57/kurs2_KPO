package behavioral.b2_mediator.chat_2;

/**
 * Mediator pattern client
 */
public class MexdiatorPatternDemo {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Bob");
        User user2 = new UserImpl(mediator, "Jack");
        User user3 = new UserImpl(mediator, "Nick");
        User user4 = new UserImpl(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        user1.send("Hi All");
    }
}
