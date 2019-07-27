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
        currentDoc.getSide2().setDoc(currentDoc);
        System.out.println("sended to " + currentDoc.getSide2());
    }
    
    public static void register(Doc doc){
        doc.setId(++numDocs);
        while (docsDB.containsKey(doc.getId())) doc.setId(++numDocs);
        docsDB.put(doc.getId(), doc);
        currentDoc = new Doc(doc);
        System.out.println("REGISTERED DOC ID:" + currentDoc.getId());
        System.out.println("IN ARCHIVE: " + docsDB.get(currentDoc.getId()));
        signUp1();
        System.out.println("side1 signed up.");
        sendDoc();
    }
        
    public static void confirm(Doc doc) {
        System.out.println("doc id: " + doc.getId());
        currentDoc = new Doc(doc);
        System.out.println("currentDoc id: " + currentDoc.getId());
        if (doc.getIsConfirmed()) {
            signUp2();
            System.out.println("done!");
            System.out.println("ARCHIVED DOC ID:" + currentDoc.getId());
        }
        else{
            docsDB.put(currentDoc.getId(), currentDoc);
            System.out.println("DOC CHANGED IN DB");
            System.out.println("CHANGED DOC ID:" + currentDoc.getId());
            sendDoc();
        }
    }
}
