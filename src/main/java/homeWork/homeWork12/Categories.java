package homeWork.homeWork12;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
public class Categories {
    private List<Category> arrCategory;

    public Categories() {
    }

    @Override
    public String toString() {
        return "Categories{" +
                "arrCategory=" + arrCategory +
                '}';
    }

    @XmlElement(name = "category")
    public void setArrCategory(List<Category> arrCategory) {
        this.arrCategory = arrCategory;
    }

    public List<Category> getArrCategory() {
        return arrCategory;
    }
}
