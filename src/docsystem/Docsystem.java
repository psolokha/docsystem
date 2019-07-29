package docsystem;

import java.util.Calendar;

public class Docsystem {

    public static void main(String[] args) {

        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");
        //Sys.currentDate.set(Calendar.HOUR_OF_DAY, 5);
        
        System.out.println();
        
        //scene1;
        gaz.createDoc(luk, "doc1");
        gaz.showDocs();
        gaz.register();
        luk.confirm();
        
        
        //scene2;
        luk.createDoc(gaz, "doc1");
        luk.showDocs();
        luk.register();
        gaz.modify();
        luk.modify();
        gaz.modify();
        luk.modify();
        gaz.confirm();
        
        
        
//        
        
    }
    
}
