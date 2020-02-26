package homeWork.homeWork11.SaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxParser extends DefaultHandler {
    private Project project;
    private String elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "project":
                project = new Project();
                project.setId(new ArrayList<>());
                for (int i = 0; i < attributes.getLength(); i++)
                    project.getId().add(attributes.getQName(i) + "=" + attributes.getValue(i));
                break;
            case "build":
                project.setBuild(new Build());
                break;

            case "plugins":
                project.getBuild().setPlugins(new Plugins());
                project.getBuild().getPlugins().setPlugin(new ArrayList<>());
                break;

            case "plugin":
                project.getBuild().getPlugins().getPlugin().add(new Plugin());
                break;

            case "configuration":
                project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).setConfiguration(new Configuration());
                break;

            case "dependencies":
                project.setDependencies(new Dependencies());
                project.getDependencies().setDependency(new ArrayList<>());
                break;

            case "dependency":
                project.getDependencies().getDependency().add(new Dependency());
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {

            case "modelVersion":
                if (project.getModelVersion() == null) {
                    project.setModelVersion(elementValue);
                }
                break;

            case "groupId":
                if (project.getGroupId() == null) {
                    project.setGroupId(elementValue);
                    break;
                } else if (project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).getGroupId() == null) {
                    project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).setGroupId(elementValue);
                    break;
                } else if (project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).getGroupId() == null) {
                    project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).setGroupId(elementValue);
                    break;
                }
                break;

            case "artifactId":
                if (project.getArtifactId() == null) {
                    project.setArtifactId(elementValue);
                    break;
                } else if (project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).getArtifactId() == null) {
                    project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).setArtifactId(elementValue);
                    break;
                } else if (project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).getArtifactId() == null) {
                    project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).setArtifactId(elementValue);
                    break;
                }
                break;

            case "version":
                if (project.getVersion() == null) {
                    project.setVersion(elementValue);
                } else if (project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).getVersion() == null) {
                    project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).setVersion(elementValue);
                    break;
                }
                break;

            case "source":
                if (project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).getConfiguration().getSource() == null) {
                    project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).getConfiguration().setSource(elementValue);
                }
                break;

            case "target":
                if (project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).getConfiguration().getTarget() == null) {
                    project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).getConfiguration().setTarget(elementValue);
                }
                break;
        }

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("START DOC");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(project);
        System.out.println("END DOC");
    }
}
