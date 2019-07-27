package docsystem;

public abstract class Company{
    private String name;
    private Doc doc;
    //private Company side2;
    
    public Company(String name){
        this.name = name;
    }
    
    public Doc createDoc(Company side2){
        doc = new Doc(this,side2);
        return doc;
    }
    
    public void register(){
        Sys.register(doc);
    }
    
    public void modify(){
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
        doc.setIsConfirmed(true);
        Sys.confirm(doc);
    }
    
}
