package homeWork.homeWork12;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "items")
public class Items {
    private List<Item> arrItem;

    public Items() {
    }

    @Override
    public String toString() {
        return "Items{" +
                "arrItem=" + arrItem +
                '}';
    }

    @XmlElement(name = "item")
    public void setArrItem(List<Item> arrItem) {
        this.arrItem = arrItem;
    }

    public List<Item> getArrItem() {
        return arrItem;
    }
}
