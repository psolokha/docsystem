package docsystem;

public class Doc {
    
    private Integer id;
    private Company creator;
    private Company side2;
    private Boolean isConfirmed = false;
    private Boolean signSide1 = false;
    private Boolean signSide2 = false;
    
    public Doc(Company creator, Company side2){
        this.creator = creator;
        this.side2 = side2;
    }
    
    public Doc(Company creator, Company side2, Integer id){
        this.id = id;
        this.creator = creator;
        this.side2 = side2;
    }
    
    public Doc (Doc doc) {
        this.id = doc.getId();
        this.creator = doc.getCreator();
        this.side2 = doc.getSide2();
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Integer getId() {
        return id;
    }

    public Company getSide2() {
        return side2;
    }

    public Company getCreator() {
        return creator;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSignSide1() {
        return signSide1;
    }

    public void setSignSide1(Boolean signSide1) {
        this.signSide1 = signSide1;
    }

    public Boolean getSignSide2() {
        return signSide2;
    }

    public void setSignSide2(Boolean signSide2) {
        this.signSide2 = signSide2;
    }
    
    
}
