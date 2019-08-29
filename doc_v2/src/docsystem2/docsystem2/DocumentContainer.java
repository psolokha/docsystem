/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsystem2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author pavelsolokha
 */
public class DocumentContainer {
    
    private Integer docQuantity = 0;
    private static DocumentContainer instance;
    private HashMap<Integer, Document> documentContainer = new HashMap<>();
    
    private DocumentContainer() {
        
    }
    
    public static DocumentContainer getInstance(){
        if (instance == null) instance = new DocumentContainer();
        return instance;
    }
    
    public void putDocument (Document doc) {
        documentContainer.put(doc.getDocID(), new Document(doc));
        docQuantity++;
    }
    
    public Document getDocument (Integer docNumber) {
        return documentContainer.get(docNumber);
    }
    
    public void removeDocument (Document doc) {
        documentContainer.remove(doc.getDocID());
    }

    public Integer getDocQuantity() {
        return docQuantity;
    }
    
    public Boolean checkDocsNumberByCompany(Document doc) {
        if (!documentContainer.isEmpty()) {
            int side1 = 0;
            int side2 = 0;
            ArrayList<Document> documents = new ArrayList<>(documentContainer.values());
            for (Document document : documents) {
                if (document.getSide1().equals(doc.getSide1()) || document.getSide2().equals(doc.getSide1())) side1++;
                if (document.getSide1().equals(doc.getSide2()) || document.getSide2().equals(doc.getSide2())) side2++;
            }
            System.out.println(side1);
        }
        return true;
    }
    
    public Boolean checkDocsTimeCreated(Document doc) {
        if (!documentContainer.isEmpty()) {
            Integer docs = 0;
            Iterator<Document> iterator = documentContainer.values().iterator();
            while(iterator.hasNext()) {

                if (doc.getCreator().equals(iterator.next().getCreator())) {
                if ((Calendar.getInstance().getTimeInMillis() - iterator.next().getDateCreated().getTimeInMillis()) > 1000*60*60) docs++;
                }
            }
        }
        return true;
    }
    
     
}
