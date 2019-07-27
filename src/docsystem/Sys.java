package docsystem;

import java.util.HashMap;
import java.util.Map;

public class Sys{
    private static Integer numDocs = 0;
    private static Map<Integer, Doc> docsDB = new HashMap<>();
    private static Doc currentDoc;
    
    private static void signUp1(){
        currentDoc.setSignSide1(true);
    }
    
    private static void signUp2(){
        currentDoc.setSignSide2(true);
    }
    
    private static void sendDoc(){
        currentDoc.getSide2().setDoc(currentDoc);
    }
    
    public static void register(Doc doc){
        doc.setId(++numDocs);
        while (docsDB.containsKey(doc.getId())) doc.setId(++numDocs);
        docsDB.put(doc.getId(), doc);
        currentDoc = new Doc(doc);
        signUp1();
        sendDoc();
    }
        
    public static void confirm(Doc doc) {
        currentDoc = new Doc(doc);
        if (doc.getIsConfirmed()) {
            signUp2();
            System.out.println("done!");
        }
        else{
            docsDB.put(currentDoc.getId(), currentDoc);
            sendDoc();
        }
    }
}
