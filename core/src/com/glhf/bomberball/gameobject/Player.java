package com.glhf.bomberball.gameobject;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.glhf.bomberball.Constants;
import com.glhf.bomberball.Game;
import com.glhf.bomberball.Graphics;

import java.util.Hashtable;

import static com.badlogic.gdx.graphics.g2d.Animation.*;

public class Player extends Character {
    //attributes
    private int number_bomb_remaining;
    private int number_initial_bombs;
    private int initial_bomb_range;
    //bonus owned
    private Hashtable<String, Integer> bonus_owned;

    private Animation<AtlasRegion> animation_idle;

    // constructor
    public Player(int position_x, int position_y) {
        super(position_x, position_y, Constants.config_file.getAttribute("player_life"));
        number_initial_bombs=1;
        initial_bomb_range = 3;
        animation_idle = new Animation<AtlasRegion>(0.15f, Graphics.Anims.get("knight_m_idle_anim"), PlayMode.LOOP);
    }

    @Override
    public AtlasRegion getSprite()
    {
        return animation_idle.getKeyFrame(Game.time_elapsed);
    }

    // this method initiate the begin of a new turn
    @Override
    public void initiateTurn(){
        number_bomb_remaining= number_initial_bombs+ bonus_owned.get("NumberBombBoost");
        number_move_remaining = number_initial_moves + bonus_owned.get("SpeedBoost");
    }

    // getters and setters
    public int getNumberBombRemaining() {
        return number_bomb_remaining;
    }

    public void setNumberBombRemaining(int number_bomb_remaining) {
        this.number_bomb_remaining = number_bomb_remaining;
    }

    // to use bombs
    public Bomb dropBomb(int drop_position_x, int drop_position_y){
        number_bomb_remaining-=1;
        return new Bomb(drop_position_x, drop_position_y, initial_bomb_range + bonus_owned.get("BombRangeBoost"));
    }
    //to loot bonus
    public void lootBonus(Bonus bonus) {
        if (this.bonus_owned.contains(bonus.getName())) {
            this.bonus_owned.put(bonus.getName(), bonus_owned.get(bonus.getName()) + 1);
        } else {
            this.bonus_owned.put(bonus.getName(), 1);
        }
    }
}
