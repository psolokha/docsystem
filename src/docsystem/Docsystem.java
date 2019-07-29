package docsystem;

import java.util.Calendar;

public class Docsystem {

    public static void main(String[] args) {

        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");

        //scene1;
        gaz.createDoc(luk, "doc1");
        gaz.register();
        luk.confirm();
        
        //scene2;
        luk.createDoc(gaz, "doc2");
        luk.register();
        gaz.modify();
        luk.modify();
        gaz.modify();
        luk.confirm();
        
    }
    
}
