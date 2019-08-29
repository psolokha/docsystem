/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsystem2;

/**
 *
 * @author pavelsolokha
 */
public class DocSystem {
    
    private static DocSystem instance;
    private Boolean isReady = true;
    
    private DocSystem() {
        
    }
    
    public static DocSystem getInstance() {
        if (instance == null) instance = new DocSystem();
        return instance;
    }
    
    public void acceptConfirmedDocument(Document doc) {
        
        if (!DocChecker.getInstance().checkStatus(doc)) {
            DocChecker.getInstance().printErrors();
            isReady = false;
        }
        
        if (isReady) {
            if (doc.getDocID() == null) { 
                registerDocument(doc);
                sendDocument(doc);
            } else if (doc.getSide1().equals(DocumentContainer.getInstance().getDocument(doc.getDocID()).getSide1())) { 
                doc.setIsConfirmed(true);
                System.out.println("done!");
            }
            else {

                DocumentContainer.getInstance().putDocument(doc);
                sendDocument(doc);

            }
        } else {
            System.out.println("Rejected!");
        }
        
    }
    
    public void registerDocument(Document doc) {    
    DocumentContainer dc = DocumentContainer.getInstance();
    doc.setDocID(dc.getDocQuantity() + 1);
    dc.putDocument(doc);   
    }
    
    private void sendDocument(Document doc) {
        doc.getSide2().setCurrentDocument(doc);
    }
    
}
