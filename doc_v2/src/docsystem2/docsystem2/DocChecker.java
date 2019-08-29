/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsystem2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author pavelsolokha
 */
public class DocChecker {
    
    private static DocChecker instance;
    private List<String> errorList = new ArrayList<>();
    private Boolean isAllowed = true;
    private Document currentDocument;
    
    private DocChecker() {
        
    }
    
    public static DocChecker getInstance() {
        if (instance == null) instance = new DocChecker();
        return instance;
    }
    
    public Boolean checkStatus(Document doc) {
        DocumentContainer dc = DocumentContainer.getInstance();
        
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 21 || Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 7) {
            errorList.add("System works from 7 to 21!");
            isAllowed = false;
        }
        if (!dc.checkDocsNumberByCompany(doc)) {
            errorList.add("Too many docs for one of companies!");
            isAllowed = false;
        }
        
        
        return isAllowed;
    }

    public void printErrors() {
        for (String string : errorList) {
            System.out.println(string);
        }
    }
    
}
