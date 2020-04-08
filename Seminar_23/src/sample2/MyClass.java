package sample2;

@MyTestAnnotation1
@MyTestAnnotation2
@MyTestAnnotation3
public class MyClass {

    @MyBugReport(assignedTo = "Vasya Pupkin", severity = 10)
    public static String makeReport1(){
        return "very important message";
    }

    @MyBugReport(severity = 5, assignedTo = "nobody knows")
    public static String makeReport2(){
        return "read it in case there is nothing to do else";
    }
}
