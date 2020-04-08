package behavioral.b3_chain_of_responsibility.random;

/**
 * ChainDemo is responsible for creating a chain of Handler instances, and pass 3 requests to them.
 * The Handlers will randomly decide if and when any of them will handle the request.
 */
public class Handler {

    private static java.util.Random s_rn = new java.util.Random();
    private static int s_next = 1;
    private int m_id = s_next++;
    private Handler m_next;

    public void add(Handler next) {
        if (m_next == null)
            m_next = next;
        else
            m_next.add(next);
    }
    public void wrap_around(Handler root) {
        if (m_next == null)
            m_next = root;
        else
            m_next.wrap_around(root);
    }
    public void handle(int num) {
        if (s_rn.nextInt(4) != 0) {
            System.out.print(m_id + "-busy ");
            m_next.handle(num);
        } else
            System.out.println(m_id + "-handled-" + num);
    }
}
