package behavioral.b11_interpreter;

/**
 * Now we can create our client application that will have the logic to parse the
 * user input and pass it to correct expression and then use the output to
 * generate the user response.
 */
public class InterpreterClient {

    public InterpreterContext ic;

    public InterpreterClient(InterpreterContext i){
        this.ic = i;
    }

    public String interpret(String str){
        Expression exp = null;
        //create rules for expressions
        if(str.contains("Hexadecimal")){
            exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
        } else {
            if(str.contains("Binary")){
                exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
            }else
                return str;
        }
        return exp.interpret(ic);
    }

    public static void main(String args[]){
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";
        InterpreterClient interpreterClient = new InterpreterClient(new InterpreterContext());
        System.out.println(str1 + " = " + interpreterClient.interpret(str1));
        System.out.println(str2 + " = " + interpreterClient.interpret(str2));
    }
}
