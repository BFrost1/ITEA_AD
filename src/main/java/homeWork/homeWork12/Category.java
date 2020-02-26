package homeWork.homeWork12;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class Category {
    private int id;
    private int parentId;
    private String name;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}';
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }
}
