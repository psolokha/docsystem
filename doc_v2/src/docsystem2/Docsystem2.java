package docsystem2;     

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
        
    }
    
}
