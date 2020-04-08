package behavioral.b8_visitor.shopping_card;

/**
 *
 */
public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
