/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsystem2;

import java.util.Calendar;

/**
 *
 * @author pavelsolokha
 */
public class Document {
    
    private Company side1;
    private Company side2;
    Calendar dateCreated;
    private Integer docID;
    
    public Document(){
        dateCreated = Calendar.getInstance();
    }
    
    public Document(Document doc) {
        this.side1 = doc.getSide1();
        this.side2 = doc.getSide2();
        this.dateCreated = doc.getDateCreated();
        this.docID = doc.getDocID();
    }

    public Company getSide1() {
        return side1;
    }

    public Company getSide2() {
        return side2;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public Integer getDocID() {
        return docID;
    }

    public void setSide1(Company side1) {
        this.side1 = side1;
    }

    public void setSide2(Company side2) {
        this.side2 = side2;
    }

    public void setDocID(Integer docID) {
        this.docID = docID;
    }
    
}
