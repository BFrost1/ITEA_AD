package homeWork.homeWork12;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "item")
public class Item {
    private int id;
    private int categoryId;
    private String code;
    private String barcode;
    private String vendor;
    private String name;
    private String description;
    private String url;
    private String image;
    private double priceRUAH;
    private double priceRUSD;
    private String stock;
    private Delivery delivery;
    private String guarantee;
    private String param;
    private int condition;
    private int custom;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", code='" + code + '\'' +
                ", barcode='" + barcode + '\'' +
                ", vendor='" + vendor + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", priceRUAH=" + priceRUAH +
                ", priceRUSD=" + priceRUSD +
                ", stock='" + stock + '\'' +
                ", delivery=" + delivery +
                ", guarantee='" + guarantee + '\'' +
                ", param='" + param + '\'' +
                ", condition=" + condition +
                ", custom=" + custom +
                '}';
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @XmlElement
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement
    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public void setPriceRUAH(double priceRUAH) {
        this.priceRUAH = priceRUAH;
    }

    @XmlElement
    public void setPriceRUSD(double priceRUSD) {
        this.priceRUSD = priceRUSD;
    }

    @XmlElement
    public void setStock(String stock) {
        this.stock = stock;
    }

    @XmlElement
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @XmlElement
    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    @XmlElement
    public void setParam(String param) {
        this.param = param;
    }


    @XmlElement
    public void setCondition(int condition) {
        this.condition = condition;
    }

    @XmlElement
    public void setCustom(int custom) {
        this.custom = custom;
    }

    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCode() {
        return code;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public double getPriceRUAH() {
        return priceRUAH;
    }

    public double getPriceRUSD() {
        return priceRUSD;
    }

    public String getStock() {
        return stock;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public String getParam() {
        return param;
    }

    public int getCondition() {
        return condition;
    }

    public int getCustom() {
        return custom;
    }
}
