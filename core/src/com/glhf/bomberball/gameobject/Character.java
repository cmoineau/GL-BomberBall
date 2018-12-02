package com.glhf.bomberball.gameobject;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.glhf.bomberball.Constants;
import com.glhf.bomberball.Graphics;

public abstract class Character extends GameObject {

    protected int initial_moves = 5;

    protected transient int moves_remaining;

    protected transient Animation<TextureAtlas.AtlasRegion> animation;

    public Character(String skin, int life, int initial_moves) {
        super(life);
        this.initial_moves = initial_moves;
        this.moves_remaining = initial_moves;
        setAnimation(skin + "/idle");
    }

    public void setInitialMoves(int initial_moves) {
        this.initial_moves = initial_moves;
    }

    /**
     * set the animation of the character
     * @param animation_name animation name
     */
    protected void setAnimation(String animation_name)
    {
        animation = new Animation<TextureAtlas.AtlasRegion>(0.15f, Graphics.Anims.get(animation_name), Animation.PlayMode.LOOP);
    }

    /**
     * Initiate attribute number_move_remaining at the beginning of a turn
     */
    public void initiateTurn() {
        moves_remaining = initial_moves;
    }
}
