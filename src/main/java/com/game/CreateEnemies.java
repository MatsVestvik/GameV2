package com.game;

import com.game.createView.ViewCharacter;
import com.game.logic.MakeImage;
import com.game.logic.Item;
import com.game.logic.Character;
import com.game.logic.CreateItems;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemies {
    private List<ViewCharacter> enemyCharacters;

    public CreateEnemies() {
        enemyCharacters = new ArrayList<>();
        Random random = new Random();
    
        for (int i = 0; i < 3; i++) {
            CreateItems itemCreator = new CreateItems();
            List<Item> equipmentSet = itemCreator.getItems();
            createEnemyCharacter(
                equipmentSet.get(0), // sword
                equipmentSet.get(1), // shield
                equipmentSet.get(2), // helmet
                equipmentSet.get(3), // chestplate
                equipmentSet.get(4), // leggings
                equipmentSet.get(5)  // boots
            );
        }
    }

    public List<ViewCharacter> getEnemyCharacters() {return enemyCharacters;}

    public void createEnemyCharacter(Item sword, Item shield, Item helmet, Item chestplate, Item leggings, Item boots) {
        Image villainAvatar = MakeImage.createImage("img/ninja/Ninja_Character.gif");
        Character villain = new Character("Villain", 100, 10, villainAvatar);
        villain.equipItem(sword);
        villain.equipItem(shield);
        villain.equipItem(helmet);
        villain.equipItem(chestplate);
        villain.equipItem(leggings);
        villain.equipItem(boots);
        ViewCharacter enemyView = new ViewCharacter(false, villainAvatar, villain);
        enemyView.addItemImageToPane(sword.getSprite(), sword.getRarity(), sword.getType());
        enemyView.addItemImageToPane(shield.getSprite(), shield.getRarity(), shield.getType());
        enemyView.addItemImageToPane(helmet.getSprite(), helmet.getRarity(), helmet.getType());
        enemyView.addItemImageToPane(chestplate.getSprite(), chestplate.getRarity(), chestplate.getType());
        enemyView.addItemImageToPane(leggings.getSprite(), leggings.getRarity(), leggings.getType());
        enemyView.addItemImageToPane(boots.getSprite(), boots.getRarity(), boots.getType());
        enemyCharacters.add(enemyView);
    }

    public ViewCharacter getEnemyView(int index) {
        if (index >= 0 && index < enemyCharacters.size()) {
            return enemyCharacters.get(index);
        }
        return null;
    }


}
