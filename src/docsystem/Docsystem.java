package docsystem;

public class Docsystem {

    public static void main(String[] args) {

        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");
        
        //scene1;
        gaz.createDoc(luk);
        gaz.register();
        luk.confirm();
        
        
        //scene2;
        luk.createDoc(gaz);
        luk.register();
        gaz.modify();
        luk.modify();
        gaz.modify();
        luk.modify();
        gaz.confirm();
        
        
        
//        
        
    }
    
}
