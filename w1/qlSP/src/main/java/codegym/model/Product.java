package codegym.model;

public class Product {
    private int idP;
    private String pName;
    private double price;
    private String imgURL;
    private Category category;
    private boolean status;

    public Product(int idP, String pName, double price, String imgURL, Category category, boolean status) {
        this.idP = idP;
        this.pName = pName;
        this.price = price;
        this.imgURL = imgURL;
        this.category = category;
        this.status = status;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
