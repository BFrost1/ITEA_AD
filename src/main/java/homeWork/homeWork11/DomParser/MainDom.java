package homeWork.homeWork11.DomParser;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MainDom {
    public static void main(String[] args) {
        Project project = new Project();
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("pom.xml"));
            NodeList nodeList = document.getElementsByTagNameNS("*", "*");


            for (int i = 0; i < nodeList.getLength(); i++) {
                if(nodeList.item(i).getNodeName().equals("project")){
                    for (int p = 0; p < nodeList.item(i).getAttributes().getLength(); p++){
                        project.getId().add(nodeList.item(i).getAttributes().item(p).getTextContent());
                    }
                }
                if (project.getModelVersion() == null & nodeList.item(i).getNodeName().equals("modelVersion")) {
                    project.setModelVersion(nodeList.item(i).getTextContent());
                }
                if (project.getGroupId() == null & nodeList.item(i).getNodeName().equals("groupId")) {
                    project.setGroupId(nodeList.item(i).getTextContent());
                }
                if (project.getArtifactId() == null & nodeList.item(i).getNodeName().equals("artifactId")) {
                    project.setArtifactId(nodeList.item(i).getTextContent());
                }
                if (project.getVersion() == null & nodeList.item(i).getNodeName().equals("version")) {
                    project.setVersion(nodeList.item(i).getTextContent());
                }
                if (nodeList.item(i).getNodeName().equals("plugin")) {
                    project.getBuild().getPlugins().getPlugin().add(new Plugin());
                    for (int e = 0; e < nodeList.item(i).getChildNodes().getLength(); e++) {
                        if (nodeList.item(i).getChildNodes().item(e).getNodeName().equals("groupId")) {
                            project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).setGroupId(nodeList.item(i).getChildNodes().item(e).getTextContent());
                        } else if (nodeList.item(i).getChildNodes().item(e).getNodeName().equals("artifactId")) {
                            project.getBuild().getPlugins().getPlugin().get(project.getBuild().getPlugins().getPlugin().size() - 1).setArtifactId(nodeList.item(i).getChildNodes().item(e).getTextContent());
                        }
                    }
                }

                if (nodeList.item(i).getNodeName().equals("configuration")) {
                    for (int r = 0; r < project.getBuild().getPlugins().getPlugin().size(); r++) {
                        project.getBuild().getPlugins().getPlugin().get(r).setConfiguration(new Configuration());
                        for (int t = 0; t < nodeList.item(i).getChildNodes().getLength(); t++) {
                            if (nodeList.item(i).getChildNodes().item(t).getNodeName().equals("source")) {
                                project.getBuild().getPlugins().getPlugin().get(0).getConfiguration().setSource(nodeList.item(i).getChildNodes().item(t).getTextContent());
                            } else if (nodeList.item(i).getChildNodes().item(t).getNodeName().equals("target")) {
                                project.getBuild().getPlugins().getPlugin().get(0).getConfiguration().setTarget(nodeList.item(i).getChildNodes().item(t).getTextContent());
                            }
                        }
                    }
                }
                if (nodeList.item(i).getNodeName().equals("dependency")) {
                    project.getDependencies().getDependency().add(new Dependency());
                    for (int q = 0; q < nodeList.item(i).getChildNodes().getLength(); q++) {
                        if (nodeList.item(i).getChildNodes().item(q).getNodeName().equals("groupId")) {
                            project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).setGroupId(nodeList.item(i).getChildNodes().item(q).getTextContent());
                        } else if (nodeList.item(i).getChildNodes().item(q).getNodeName().equals("artifactId")) {
                            project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).setArtifactId(nodeList.item(i).getChildNodes().item(q).getTextContent());
                        } else if (nodeList.item(i).getChildNodes().item(q).getNodeName().equals("version")) {
                            project.getDependencies().getDependency().get(project.getDependencies().getDependency().size() - 1).setVersion(nodeList.item(i).getChildNodes().item(q).getTextContent());
                        }
                    }
                }
            }
            System.out.println(project);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
