package homeWork.homeWork11.SaxParser;

import java.util.ArrayList;

public class Plugins {
    private ArrayList<Plugin> plugin;

    public Plugins() {
    }

    @Override
    public String toString() {
        return "Plugins{" +
                "plugin=" + plugin +
                '}';
    }

    public ArrayList<Plugin> getPlugin() {
        return plugin;
    }

    public void setPlugin(ArrayList<Plugin> plugin) {
        this.plugin = plugin;
    }
}
