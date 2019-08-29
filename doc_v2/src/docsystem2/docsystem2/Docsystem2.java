package docsystem2;     

import java.util.HashMap;
import java.util.Iterator;

public class Docsystem2 {

    public static void main(String[] args) {
        
        Company com1 = new Company();
        Company com2 = new Company();
        
        com1.createDocument(com2);
        com1.confirmCurrentDocument();
        com2.confirmCurrentDocument();
        
        com2.createDocument(com1);
        com2.confirmCurrentDocument();
        com1.modifyCurrentDocument();
        com2.confirmCurrentDocument();
        
//        HashMap<Integer, Document> documentContainer = new HashMap<>();
//        
//         documentContainer.put(1, new Document());
//         documentContainer.put(2, new Document());
//         
//         Iterator<Document> iterator = documentContainer.values().iterator();
//         while(iterator.hasNext()) {
//             System.out.println(iterator.next().getSide1());
//             System.out.println(iterator.next().getSide2());
//         }
            
        
    }
 
}
