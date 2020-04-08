package behavioral.b11_interpreter;

/**
 * Different types of expressions will consume the InterpreterContext...
 *
 * We will have two expression implementations, one to convert int to binary
 * and other to convert int to hexadecimal format.
 */
public interface Expression {
    String interpret(InterpreterContext ic);
}
