package docsystem;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

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
    
    public Doc createDoc(Doc doc) {
        doc = new Doc(this, doc);
        myFolder.putDoc(doc);
        return doc;
    }
    
    
    public void register(){
        Sys.register(doc);
        doc = null;
    }
    
    public void modify(){
        this.doc = createDoc(doc);
        Sys.confirm(doc);
        doc = null;
    }
    
    public void confirm() {
        doc.setIsConfirmed(true);
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
    
    public Doc getDoc(String name) {
        doc = myFolder.getDoc(name);
        return doc;
    }
    
    public Calendar getDocTime(){
       return myFolder.getCurrDate();
    }
    
    private class DocFolder {
        private int sCounter = 0;
        private Calendar currDate = new GregorianCalendar();
        private Map<String, Doc> docFolder = new HashMap<>(Const.MAX_DOCS_NUMBER);

        public Calendar getCurrDate() {
            return currDate;
        }
        
        public void showDocs() {
            docFolder.entrySet().forEach((es) -> {
                System.out.println("Company " + es.getValue().getSide2() + ": " + es.getKey());
            });
        }
        
        public void putDoc(Doc doc){
            sCounter = 0;
                if (docFolder.size() > Const.MAX_DOCS_NUMBER-1) {
                    return;
                }  
                docFolder.entrySet().forEach((es) -> {
                    if (doc.getSide2().equals(es.getValue().getSide2())) sCounter++;  
                });
                if (sCounter >= Const.DOCS_FOR_COMPANY) {
                    return;
                }
                sCounter = 0;
                docFolder.entrySet().forEach((es) -> {
                    if (((currDate.getTimeInMillis()-es.getValue().getTimeCreated().getTimeInMillis())/60000) < Const.MINUTES) {
                            sCounter++;
                    }
                });
                
                if (sCounter >= Const.DOCS_IN_TIME) {
                    return;
                }
                sCounter = 0;
                docFolder.put(doc.getName(), doc);
        }
        
        public void removeDoc(Doc doc){
            docFolder.remove(doc.getName());
        }
        
        public Doc getDoc(String name) {
            return docFolder.get(name);
        }
        
    }
    
}
