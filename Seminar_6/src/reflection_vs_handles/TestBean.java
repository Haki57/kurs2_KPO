package reflection_vs_handles;

public class TestBean {

    //private
    int intValue; //TODO: we cannot access private field from outside...
    private String stringValue; //

    public void setIntValue(int newValue){
        intValue = newValue;
    }
    public int getIntValue(){
        System.out.println("getIntValue() invoked...");
        return intValue;
    }

    public void setStringValue(String newValue){
        stringValue = newValue;
    }
    public String getStringValue(){
        return stringValue;
    }

    private String readPrivate(){
        return stringValue;
    }
}
