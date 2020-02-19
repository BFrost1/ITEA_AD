package homeWork.homeWork1.shellHeroes;

public class Hero {
    private String imageURL;
    private String name;
    private String replicaOne;
    private String replicaTwo;
    private String replicaThree;

    public Hero() {
    }

    public Hero(String name, String replicaOne, String replicaTwo, String replicaThree) {
        this.name = name;
        this.replicaOne = replicaOne;
        this.replicaTwo = replicaTwo;
        this.replicaThree = replicaThree;
    }

    public Hero(String imageURL, String name, String replicaOne, String replicaTwo, String replicaThree) {
        this.imageURL = imageURL;
        this.name = name;
        this.replicaOne = replicaOne;
        this.replicaTwo = replicaTwo;
        this.replicaThree = replicaThree;
    }

    @Override
    public String toString() {
        return "Heroe{" +
                "imageURL='" + imageURL + '\'' +
                ", name='" + name + '\'' +
                ", replicaOne='" + replicaOne + '\'' +
                ", replicaTwo='" + replicaTwo + '\'' +
                ", replicaThree='" + replicaThree + '\'' +
                '}';
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getReplicaOne() {
        return replicaOne;
    }

    public void setReplicaOne(String replicaOne) {
        this.replicaOne = replicaOne;
    }

    public String getReplicaTwo() {
        return replicaTwo;
    }

    public void setReplicaTwo(String replicaTwo) {
        this.replicaTwo = replicaTwo;
    }

    public String getReplicaThree() {
        return replicaThree;
    }

    public void setReplicaThree(String replicaThree) {
        this.replicaThree = replicaThree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
