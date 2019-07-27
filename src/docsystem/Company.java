package docsystem;

public abstract class Company{
    private String name;
    private Doc doc;
    
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
        System.out.println(doc);
        doc = null;
    }
    
    public void modify(){
        System.out.println("current Doc is created by " + doc.getCreator());
        System.out.println("doc id: " + doc.getId());
        this.doc = new Doc(this, doc.getCreator(), doc.getId());
        System.out.println("modified by " + name);
        System.out.println("modify docID:" + doc.getId());
        Sys.confirm(doc);
        doc = null;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public void confirm() {
        System.out.println("confirmed by " + name);
        doc.setIsConfirmed(true);
        Sys.confirm(doc);
        doc = null;
    }
    
}
