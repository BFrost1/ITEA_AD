package homeWork.homeWork12;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "delivery")
public class Delivery {
        private int id;
        private String type;
        private int cost;
        private int freeFrom;
        private int time;
        private String carrier;
        private String region;

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", freeFrom=" + freeFrom +
                ", time=" + time +
                ", carrier='" + carrier + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }
    @XmlAttribute
    public void setCost(int cost) {
        this.cost = cost;
    }
    @XmlAttribute
    public void setFreeFrom(int freeFrom) {
        this.freeFrom = freeFrom;
    }
    @XmlAttribute
    public void setTime(int time) {
        this.time = time;
    }
    @XmlAttribute
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    @XmlAttribute
    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public int getFreeFrom() {
        return freeFrom;
    }

    public int getTime() {
        return time;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getRegion() {
        return region;
    }
}
