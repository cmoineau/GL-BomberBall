package com.glhf.bomberball.gameobject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.glhf.bomberball.Textures;
import com.glhf.bomberball.maze.Maze;

public class Bomb extends GameObject {
    // attributes
    private int damage;
    private int range;

    public Bomb()
    {
        this.appearance = Textures.get("Bomb");
    }

    //constructor
    public Bomb(int position_x, int position_y, int range) {
        super(position_x, position_y, 1);
        // initially, bomb inflict 1 damage
        this.damage=1;
        this.range=range;
        this.appearance = Textures.get("Bomb");
    }

    //method explode
    public void explode(Maze map){
        int i=1;
        GameObject object;
        //UP
        while(i<=range){
            object=map.getGameObjectAt(position_x,position_y-i);
            if(object instanceof Wall){
               i=range;
            }
            object.getDamage(damage);
            i++;
        }
        i=1;
        //DOWN
        while(i<=range){
            object=map.getGameObjectAt(position_x,position_y+i);
            if(object instanceof Wall){
                i=range;
            }
            object.getDamage(damage);
            i++;
        }
        i=1;
        //RIGHT
        while(i<=range){
            object=map.getGameObjectAt(position_x+i,position_y);
            if(object instanceof Wall){
                i=range;
            }
            object.getDamage(damage);
            i++;
        }
        i=1;
        //LEFT
        while(i<=range){
            object=map.getGameObjectAt(position_x-i,position_y);
            if(object instanceof Wall){
                i=range;
            }
            object.getDamage(damage);
            i++;
        }
        //version avec Coord (un Vector2 avec des int)
        /*
        for(Coord dir : Coords.directions){//Coords.directions est une variable statique constante avec les 4 vecteurs (0,1),(1,0),(1,0),(1,1)
            for(int i=i; i<=range && !(object instanceof Wall); i++){
                object=map.getGameObjectAt(position.add(dir));
                object.getDamage(damage);
            }
        }
        */
        map.handleDestruction();
    }
}
