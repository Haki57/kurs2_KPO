package behavioral.b2_mediator.chat;

import java.util.Date;

/**
 * A Mediator class
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
    }
}
