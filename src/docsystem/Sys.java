package docsystem;

import java.util.HashMap;
import java.util.Map;

public class Sys{
    private static Integer numDocs = 0;
    private static Map<Integer, Doc> docsDB = new HashMap<>();
    private static Doc currentDoc;
    
    private static void signUp1(){
        System.out.println("signed up by " + currentDoc.getCreator());
        currentDoc.setSignSide1(true);
    }
    private static void signUp2(){
        System.out.println("signed up by " + currentDoc.getSide2());
        currentDoc.setSignSide2(true);
    }
    
    private static void sendDoc(){
        System.out.println("sended to " + currentDoc.getSide2());
        currentDoc.getSide2().setDoc(currentDoc);
    }
    
    public static void register(Doc doc){
        doc.setId(++numDocs);
        while (docsDB.containsKey(doc.getId())) doc.setId(++numDocs);
        docsDB.put(doc.getId(), doc);
        currentDoc = docsDB.get(doc.getId());
        System.out.println("REGISTERED DOC ID:" + currentDoc.getId());
        signUp1();
        sendDoc();
    }
        
    
    public static void confirm(Doc doc) {
        if (doc.getIsConfirmed()) {
            signUp2();
            System.out.println("done!");
            System.out.println("ARCHIVED DOC ID:" + currentDoc.getId());
            //
            //archive!
            //
        }
        else{
            docsDB.put(currentDoc.getId(), doc);
            System.out.println("DOC CHANGED IN DB");
            System.out.println("CHANGED DOC ID:" + currentDoc.getId());
            sendDoc();
        }
    }
    
    
}