package com.glhf.bomberball.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.glhf.bomberball.Constants;
import com.glhf.bomberball.GUI.SkinButton;
import com.glhf.bomberball.Game;

public class TitleMenu extends State{

    //general attributes
    private Stage stage;
    private VerticalGroup verticalGroup;
    private  TextureAtlas button_atlas;
    private Skin skin;
    private BitmapFont font;

    //buttons
    private SkinButton solo_button, multi_button,map_editor_button,settings_button,quit_button;
    private TextButton.TextButtonStyle style;


    public TitleMenu(String name)
    {
        super(name);
        this.create();
    }


    public void create() {
        stage = new Stage();
        verticalGroup = new VerticalGroup();
        verticalGroup.setFillParent(true);
        verticalGroup.center();
        font = new BitmapFont();
        skin = new Skin();
        button_atlas = new TextureAtlas(Gdx.files.internal(Constants.PATH_ATLAS_GUI));
        skin.addRegions(button_atlas);
        style = new TextButton.TextButtonStyle();
        style.font = font;
        initializeButtons();
        addListeners();
        verticalGroup.addActor(solo_button);
        verticalGroup.addActor(multi_button);
        verticalGroup.addActor(map_editor_button);
        verticalGroup.addActor(settings_button);
        verticalGroup.addActor(quit_button);
        stage.addActor(verticalGroup);
    }

    @Override
    public void setInputProcessor() {
        Gdx.input.setInputProcessor(stage); //ne pas enlever
    }

    public void draw()
    {
        stage.draw();
    }

    public void initializeButtons(){
        Texture texture_up = new Texture(Gdx.files.internal("core/assets/graphics/gui/Solobutton.png"));
        Texture texture_down =  new Texture(Gdx.files.internal("core/assets/graphics/gui/Solobutton.png"));
        Texture texture_background =  new Texture(Gdx.files.internal("core/assets/graphics/gui/Solobutton.png"));
        solo_button = new SkinButton(texture_up,texture_down,texture_background);

        texture_up = new Texture(Gdx.files.internal("core/assets/graphics/gui/BoutonMulti.png"));
        texture_down =  new Texture(Gdx.files.internal("core/assets/graphics/gui/BoutonMulti.png"));
        texture_background =  new Texture(Gdx.files.internal("core/assets/graphics/gui/BoutonMulti.png"));
        multi_button = new SkinButton(texture_up,texture_down,texture_background);

        texture_up = new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonMap.png"));
        texture_down =  new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonMap.png"));
        texture_background =  new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonMap.png"));
        map_editor_button = new SkinButton(texture_up,texture_down,texture_background);

        texture_up = new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonParam.png"));
        texture_down =  new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonParam.png"));
        texture_background =  new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonParam.png"));
        settings_button = new SkinButton(texture_up,texture_down,texture_background);

        texture_up = new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonQuit.png"));
        texture_down =  new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonQuit.png"));
        texture_background =  new Texture(Gdx.files.internal("core/assets/graphics/gui/boutonQuit.png"));
        quit_button = new SkinButton(texture_up,texture_down,texture_background);
    }

    public void addListeners(){
        solo_button.addListener(new SetStateListener(new StateSoloMenu("Menu solo")));
        multi_button.addListener(new SetStateListener(new StateGameMulti("maze_0.json")));
        //map_editor_button.addListener(new SetStateListener(new StateEditor()));
        settings_button.addListener(new SetStateListener(new StateSettingsMenu("Menu paramètres")));
        quit_button.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) { Gdx.app.exit(); }
        });
    }


    public void resize(int width, int height){
        stage.getViewport().update(width,height,true);
    }

    public class SetStateListener extends ChangeListener {
        private State state;
        public SetStateListener(State state){
            this.state = state;
        }

        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Game.setState(state);
        }
    }

}
