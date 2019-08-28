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
class Company {
    
    private Document currentDocument;

    public void setCurrentDocument(Document currentDocument) {
        this.currentDocument = currentDocument;
    }
    
    public Document createDocument(Company side2) {
        currentDocument = new Document();
        currentDocument.setSide1(this);
        currentDocument.setSide2(side2);
        return currentDocument;
    }
    
    public void modifyCurrentDocument() {
        //------- changing documents settings -----
        currentDocument.setSide2(currentDocument.getSide1());
        currentDocument.setSide1(this);
        confirmCurrentDocument();
    }
    
    public void confirmCurrentDocument() {
        DocSystem.getInstance().acceptConfirmedDocument(currentDocument);
        currentDocument = null;
    }
    
}
