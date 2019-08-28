/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsystem2;

import java.util.HashMap;

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
    
     
}
