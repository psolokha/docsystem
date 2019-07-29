package docsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Company{
    private String name;
    private Doc doc;
    public DocFolder myFolder = new DocFolder();
    
    public Company(String name){
        this.name = name;
    }
    
    public Doc createDoc(Company side2, String docName){
        doc = new Doc(this,side2, docName);
        myFolder.putDoc(doc);
        return doc;
    }
    
    public Doc creatDoc(Doc doc) {
        doc = new Doc(this, doc);
        myFolder.putDoc(doc);
        return doc;
    }
    
    
    public void register(){
        Sys.register(doc);
        doc = null;
    }
    
    public void modify(){
        this.doc = creatDoc(doc);
        Sys.confirm(doc);
        doc = null;
    }
    
    public void setDoc(Doc doc) {
        this.doc = doc;
    }
    
    public void showDocs(){
        myFolder.showDocs();
    }
    
    public void removeDoc(Doc doc) {
        myFolder.removeDoc(doc);
    }

    public void confirm() {
        doc.setIsConfirmed(true);
        Sys.confirm(doc);
        doc = null;
    }
    
    private class DocFolder {
        private int docCounter = 0;
        private int sCounter = 0;
        private Date currDate = new Date();
        private Map<String, Doc> docFolder = new HashMap<>();
        
        public void cheking(Doc doc) {
                System.out.println("cheking number of docs...");
                if (docCounter > 10) {
                    System.out.println("Too many docs in system");
                    return;
                }
                
                System.out.println("cheking number of same companies...");
                docFolder.entrySet().forEach((es) -> {
                    if (doc.getSide2().equals(es.getValue().getSide2())) sCounter++;  
                });
                
                if (sCounter > 2) {
                    System.out.println("More than 2 docs to 1 company");
                    return;
                }
                sCounter = 0;
                
                System.out.println("cheking number of documents in the last hour");
                docFolder.entrySet().forEach((es) -> {
                    if (((currDate.getTime()-es.getValue().getTimeCreated().getTimeInMillis())/60000) < 60) {
                            sCounter++;
                            System.out.println(sCounter);
                    }
                });
                System.out.println(docFolder.size());
                if (sCounter > 4) {
                    System.out.println("Too many documents is last hour");
                    return;
                }
                sCounter = 0;
                 
        }
        
        public void showDocs() {
            docFolder.entrySet().forEach((es) -> {
                System.out.println("Company " + es.getValue().getSide2() + ": " + es.getKey());
            });
        }
        
        public void putDoc(Doc doc){
                if (docCounter > 10) {
                    return;
                }
                
                docFolder.entrySet().forEach((es) -> {
                    if (doc.getSide2().equals(es.getValue().getSide2())) sCounter++;  
                });
                
                if (sCounter >= 2) {
                    return;
                }
                sCounter = 0;
                
                docFolder.entrySet().forEach((es) -> {
                    if (((currDate.getTime()-es.getValue().getTimeCreated().getTimeInMillis())/60000) < 60) {
                            sCounter++;
                    }
                });
                if (sCounter > 4) {
                    return;
                }
                sCounter = 0;
            
                docFolder.put(doc.getName(), doc);
                docCounter++;
        }
        
        public void removeDoc(Doc doc){
            docFolder.remove(doc.getName());
            docCounter--;
        }
        
        public Doc getDoc(String name) {
            return docFolder.get(doc.getName());
        }
        
    }
    
}
