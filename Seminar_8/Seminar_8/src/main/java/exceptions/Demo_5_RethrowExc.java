package exceptions;

public class Demo_5_RethrowExc {}

class OpenException extends Exception {}

class CloseException extends Exception {}

//  TODO: note - that is too verbose...
class PreciseRethrow {
    public static void main(String[] args)
            throws OpenException, CloseException // TODO: comment them out...
    {
        boolean flag = (args.length > 0);
        try {
            if (flag){
                throw new OpenException();
            } else {
                throw new CloseException();
            }
        } catch(OpenException oe) {
            System.out.println("OpenException: " + oe.getMessage());
            throw oe;
        } catch (CloseException ce) {
            System.out.println("CloseException: " + ce.getMessage());
            throw ce;
        }
    }
}

// TODO: note - that's less verbose,
//  but client applications no longer have the benefit of easily dealing with
//  the specific CloseException or OpenException when they are thrown.
class RethrowVariant0 {
    public static void main(String[] args) throws Exception { // a client cannot see Exception variants...
        boolean flag = (args.length > 0);
        try {
            if (flag){
                throw new OpenException();
            }
            else {
                throw new CloseException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

//TODO: note - that was impossible prior Java 7 (the difference is in throws clause):
class RethrowVariant1 {
    public static void main(String[] args) throws OpenException, CloseException {
        boolean flag = (args.length > 0);
        try {
            if (flag){
                throw new OpenException();
            }
            else {
                throw new CloseException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

class RethrowVariant2 {
    public static void main(String args[])
        throws
            OpenException
            ,
            CloseException
            ,
            Exception
    {
        boolean flag = (args.length > 0);
        try {
            if (flag){
                throw new OpenException();
            }
            else {
                throw new CloseException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e = new OpenException(); //TODO: reassigning e - is valid here...
            //TODO: but we need to declare Exception in throws above...i.e. do like before java 7...
            throw e;
        }
    }
}
