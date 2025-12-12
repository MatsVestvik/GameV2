package com.game.logic;

import javafx.scene.image.Image;

public class MakeImage {
    
    public static Image createImage(String path) {
        try {
            Image img = new Image(path);
            return img;
        } catch (Exception e) {
            System.out.println("Error loading image: " + path);
            return null;
        }
    }
}
