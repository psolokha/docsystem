package docsystem;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Sys{
    public static final Calendar currentDate = new GregorianCalendar();
    private static Integer numDocs = 0;
    private static Map<Integer, Doc> docsDB = new HashMap<>();
    private static Doc currentDoc;
    
    public static void register(Doc doc){
        
        if (currentDate.get(Calendar.HOUR_OF_DAY) >= 21 || currentDate.get(Calendar.HOUR_OF_DAY)< 7 ) {
            System.out.println("Service will be avilable at 7:00");
        }
        else {
        doc.setId(++numDocs);
        while (docsDB.containsKey(doc.getId())) doc.setId(++numDocs);
        docsDB.put(doc.getId(), doc);
        currentDoc = new Doc(doc);
        signUp1();
        sendDoc();
        }

    }
    
        public static void confirm(Doc doc) {
            if (currentDate.get(Calendar.HOUR_OF_DAY) >= 21 || currentDate.get(Calendar.HOUR_OF_DAY)< 7 ) {
            System.out.println("Service will be avilable at 7:00");
        }
            else {
                currentDoc = new Doc(doc);
        if (doc.getIsConfirmed()) {
            signUp2();
            currentDoc.getCreator().removeDoc(currentDoc);
            currentDoc.getSide2().removeDoc(currentDoc);
            System.out.println("done!");
        }
        else{
            docsDB.put(currentDoc.getId(), currentDoc);
            sendDoc();
        }
            }
    }
    
    private static void signUp1(){
        currentDoc.setSignSide1(true);
    }
    
    private static void signUp2(){
        currentDoc.setSignSide2(true);
    }
    
    private static void sendDoc(){
        currentDoc.getSide2().setDoc(currentDoc);
    }
}
