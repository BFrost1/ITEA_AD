package homeWork.homeWork11.DomParser;

public class Build {
    private Plugins plugins = new Plugins();

    public Build() {
    }

    @Override
    public String toString() {
        return "Build{" +
                "plugins=" + plugins +
                '}';
    }

    public Plugins getPlugins() {
        return plugins;
    }

    public void setPlugins(Plugins plugins) {
        this.plugins = plugins;
    }
}
