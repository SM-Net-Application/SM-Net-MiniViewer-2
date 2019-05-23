package net.sm.miniviewer;

import javafx.scene.image.Image;

import java.io.File;

public class Resources {

    public final static String RESOURCES_FOLDER_NAME = "resources";
    public final static Image ICON = new Image(Resources.class.getResourceAsStream(getResource("icon.png")));

    private static String getResource(String name) {
        return RESOURCES_FOLDER_NAME.concat(File.separator).concat(name);
    }
}
