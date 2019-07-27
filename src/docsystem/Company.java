package docsystem;

public abstract class Company{
    private String name;
    private Doc doc;
    //private Company side2;
    
    public Company(String name){
        this.name = name;
    }
    
    public Doc createDoc(Company side2){
        System.out.println("created by " + name);
        doc = new Doc(this,side2);
        return doc;
    }
    
    public void register(){
        System.out.println("registered by " + name);
        Sys.register(doc);
    }
    
    public void modify(){
        System.out.println("modified by " + name);
        this.doc = new Doc(this, doc.getCreator());
        doc.setIsModified(true);
        
    }

//    public void setSide2(Company side2) {
//        this.side2 = side2;
//    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public void confirm() {
        System.out.println("confirmed by " + name);
        doc.setIsConfirmed(true);
        Sys.confirm(doc);
    }
    
}
