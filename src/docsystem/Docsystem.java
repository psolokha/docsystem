package docsystem;

public class Docsystem {

    public static void main(String[] args) {

        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");
        
        luk.createDoc(gaz);
        luk.register();
        
        gaz.modify();
        luk.confirm();
        
        
    }
    
}
