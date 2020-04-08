package behavioral.b8_visitor.shopping_card;

/**
 *
 */
public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
