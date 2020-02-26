package homeWork.homeWork11.DomParser;

public class Plugin {
    private String groupId;
    private String artifactId;
    private Configuration configuration = new Configuration();

    public Plugin() {
    }

    @Override
    public String toString() {
        return "Plugin{" +
                "groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", configuration=" + configuration +
                '}';
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
