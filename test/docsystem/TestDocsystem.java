package docsystem;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sf
 */
public class TestDocsystem {
    
    public TestDocsystem() {
        
        System.out.println("Start test:");
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testTwoDocsPerCompany() {
        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");
        luk.createDoc(gaz, "doc2");
        luk.createDoc(gaz, "doc3");
        luk.createDoc(gaz, "doc4");
        luk.createDoc(gaz, "doc5");
        luk.showDocs();
     }
     
     @Test
     public void testFiveDocsPerHour(){
        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");
        Gazprom gaz1 = new Gazprom("Gazprom1");
        Gazprom gaz2 = new Gazprom("Gazprom2");
        Gazprom gaz3 = new Gazprom("Gazprom3");
        Gazprom gaz4 = new Gazprom("Gazprom4");
        Gazprom gaz5 = new Gazprom("Gazprom5");
        luk.createDoc(gaz, "doc2");
        luk.createDoc(gaz, "doc3");
        luk.createDoc(gaz1, "document1");
        luk.createDoc(gaz2, "document2");
        luk.createDoc(gaz3, "document3");
        luk.createDoc(gaz4, "document4");
        luk.createDoc(gaz5, "document5");
        luk.showDocs();
     }
     
     @Test
     public void testTenDocsPerSession(){
        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom");
        Gazprom gaz1 = new Gazprom("Gazprom1");
        Gazprom gaz2 = new Gazprom("Gazprom2");
        Gazprom gaz3 = new Gazprom("Gazprom3");
        Gazprom gaz4 = new Gazprom("Gazprom4");
        Gazprom gaz5 = new Gazprom("Gazprom5");
        luk.createDoc(gaz, "doc2");
        luk.createDoc(gaz, "doc3");
        luk.createDoc(gaz1, "document1");
        luk.createDoc(gaz2, "document2");
        luk.createDoc(gaz3, "document3");
        Calendar cal = luk.getDocTime();
        cal.set(Calendar.HOUR_OF_DAY, 20);
        luk.createDoc(gaz4, "document4");
        luk.createDoc(gaz5, "document5");
        luk.createDoc(gaz1, "document6");
        luk.createDoc(gaz2, "document7");
        luk.createDoc(gaz3, "document8");
        luk.createDoc(gaz4, "document9");
        luk.createDoc(gaz5, "document10");
        luk.showDocs();
     }
     
     @Test
     public void testFrom21To7(){
        Lukoil luk = new Lukoil("Lukoil");
        Gazprom gaz = new Gazprom("Gazprom"); 
        Sys.currentDate.set(Calendar.HOUR_OF_DAY, 3);
        luk.createDoc(gaz, "doc1");
        luk.register();
     }
}
