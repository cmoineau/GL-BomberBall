package com.glhf.bomberball.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.glhf.bomberball.Graphics;
import com.glhf.bomberball.InputHandler.Action;
import com.glhf.bomberball.Translator;
import com.glhf.bomberball.config.InputsConfig;
import com.glhf.bomberball.utils.Constants;

public class WelcomingMenuUI extends Table {

    public WelcomingMenuUI() {
        super();
        this.setFillParent(true);
        TextureRegionDrawable texture = new TextureRegionDrawable(new TextureRegion(new Texture(Constants.PATH_GRAPHICS + "/background/welcomingScreen.jpg")));
        this.setBackground(texture);
        InputsConfig config = InputsConfig.get();
        Label label = new Label(Translator.translate("Press [%s] to play", config.getInputName(Action.NEXT_SCREEN)),Graphics.GUI.getSkin());
        this.add(label);
    }



}
