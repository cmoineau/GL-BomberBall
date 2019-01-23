package com.glhf.bomberball.ui;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.glhf.bomberball.Bomberball;
import com.glhf.bomberball.Graphics;
import com.glhf.bomberball.Translator;
import com.glhf.bomberball.audio.AudioButton;
import com.glhf.bomberball.gameobject.Score;
import com.glhf.bomberball.screens.MainMenuScreen;

public class EndInfiniteUI extends MenuUI {

    public EndInfiniteUI(){
        this.setFillParent(true);
        addButtons();
    }

    private void addButtons() {
        AnimationActor player_animation = new AnimationActor(new Animation<>(0.15f, Graphics.Anims.get("mort/idle"), Animation.PlayMode.LOOP));
        player_animation.mustMove(true);
        this.add(player_animation).grow().row();

        // Labels
        Label dead = new Label(Translator.translate("Wasted !"), Graphics.GUI.getSkin());
        this .add(dead).spaceBottom(Value.percentHeight(0.9f)).row();
        dead.setFontScale(2f,2f);
        dead.setColor(Color.RED);

        Label score = new Label("Score : " + Score.getINSTANCE().getScore() +"\nHighscore : " + 999, Graphics.GUI.getSkin());
        this .add(score).spaceBottom(Value.percentHeight(0.9f)).center().row();


        //Buttons
        TextButton back_story_menu = new AudioButton(Translator.translate("Back to main menu"), Graphics.GUI.getSkin());
        back_story_menu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Bomberball.changeScreen(new MainMenuScreen());
            }
        });
        this.add(back_story_menu).spaceTop(Value.percentHeight(0.9f)).row();

        TextButton ragequit = new AudioButton(Translator.translate("Quit"), Graphics.GUI.getSkin());
        ragequit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        this.add(ragequit).spaceTop(Value.percentHeight(0.9f)).row();

    }
}