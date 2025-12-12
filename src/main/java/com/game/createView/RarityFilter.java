package com.game.createView;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

public class RarityFilter {
    
    public RarityFilter() {
        
    }

     public static ImageView applyRarityTint(ImageView imageView, int rarity) {
            ColorAdjust colorAdjust = new ColorAdjust();
            
            // Set brightness and saturation based on rarity
            switch (rarity) {
                case 0: // Common - Gray
                    break;
                case 1: // Uncommon - White
                    colorAdjust.setHue(0.33);
                    colorAdjust.setBrightness(0.1);
                    colorAdjust.setSaturation(-0.2);
                    break;
                case 2: // Rare - brown 
                    colorAdjust.setHue(0.15); // Purple hue
                    colorAdjust.setSaturation(1);
                    break;
                case 3: // red
                    colorAdjust.setHue(0.05); // Yellow/Gold hue
                    colorAdjust.setSaturation(1);
                    colorAdjust.setBrightness(0.2);
                    break;
                case 4: // blue
                    colorAdjust.setHue(1.); // Blue hue
                    colorAdjust.setSaturation(1.0);
                    break;
                default:
                    // No tint for unknown rarities
            }
            
            imageView.setEffect(colorAdjust);
            return imageView;
        }
}
