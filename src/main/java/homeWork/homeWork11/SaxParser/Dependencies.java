package homeWork.homeWork11.SaxParser;

import java.util.ArrayList;

public class Dependencies {
    private ArrayList<Dependency> dependency;

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
