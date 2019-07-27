package docsystem;

public abstract class Company{
    private String name;
    private Doc doc;
    
    public Company(String name){
        this.name = name;
    }
    
    public Doc createDoc(Company side2){
        doc = new Doc(this,side2);
        return doc;
    }
    
    public void register(){
        Sys.register(doc);
        doc = null;
    }
    
    public void modify(){
        this.doc = new Doc(this, doc.getCreator(), doc.getId());
        Sys.confirm(doc);
        doc = null;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public void confirm() {
        doc.setIsConfirmed(true);
        Sys.confirm(doc);
        doc = null;
    }
    
}
