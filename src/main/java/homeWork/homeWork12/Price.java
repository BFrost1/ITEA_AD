package homeWork.homeWork12;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "price")
public class Price {
    private String date;
    private String firmName;
    private int firmId;
    private double rate;
    private Delivery delivery;
    private List<Categories> arrCategories;
    private List<Items> arrItems;

    public Price() {
    }

    @Override
    public String toString() {
        return "Price{" +
                "date='" + date + '\'' +
                ", firmName='" + firmName + '\'' +
                ", firmId=" + firmId +
                ", rate=" + rate +
                ", delivery=" + delivery +
                ", arrCategories=" + arrCategories +
                ", arrItems=" + arrItems +
                '}';
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @XmlElement
    public void setFirmId(int firmId) {
        this.firmId = firmId;
    }

    @XmlElement
    public void setRate(double rate) {
        this.rate = rate;
    }

    @XmlElement(name = "categories")
    public void setArrCategories(List<Categories> arrCategories) {
        this.arrCategories = arrCategories;
    }

    @XmlElement(name = "items")
    public void setArrItems(List<Items> arrItems) {
        this.arrItems = arrItems;
    }

    @XmlElement(name = "delivery")
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getDate() {
        return date;
    }

    public String getFirmName() {
        return firmName;
    }

    public int getFirmId() {
        return firmId;
    }

    public double getRate() {
        return rate;
    }

    public List<Categories> getArrCategories() {
        return arrCategories;
    }

    public List<Items> getArrItems() {
        return arrItems;
    }
}
