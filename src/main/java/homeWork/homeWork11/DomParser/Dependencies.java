package homeWork.homeWork11.DomParser;

import java.util.ArrayList;

public class Dependencies {
    private ArrayList<Dependency> dependency = new ArrayList<>();

    public Dependencies() {
    }

    @Override
    public String toString() {
        return "Dependencies{" +
                "dependency=" + dependency +
                '}';
    }

    public ArrayList<Dependency> getDependency() {
        return dependency;
    }

    public void setDependency(ArrayList<Dependency> dependency) {
        this.dependency = dependency;
    }
}
