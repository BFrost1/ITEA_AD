package homeWork.homeWork11.SaxParser;

public class Configuration {
    private String source;
    private String target;

    public Configuration() {
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
