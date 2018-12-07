package com.glhf.bomberball.menu.listener;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.glhf.bomberball.menu.StateMultiMenu;

public class ChangePreviewListener extends ChangeListener {
    private int incrementation;
    private StateMultiMenu state;
    public ChangePreviewListener (int incr, StateMultiMenu state)
    {
        this.incrementation=incr;
        this.state=state;
    }
    @Override
    public void changed(ChangeEvent event, Actor actor) {
        int newMapNumber=state.getPreviewMapNumber() + incrementation;
        if (newMapNumber==-1)
        {
            newMapNumber=state.getMaxMaze();
            state.setPreviewMapNumber(newMapNumber);
            state.setPreviewFile("maze_"+newMapNumber);
        }
        else if(newMapNumber>state.getMaxMaze())
        {
            newMapNumber=0;
            state.setPreviewMapNumber(newMapNumber);
            state.setPreviewFile("maze_"+newMapNumber);
        }
        else
        {
            state.setPreviewMapNumber(newMapNumber);
            state.setPreviewFile("maze_"+newMapNumber);
        }
        state.showPreview();
    }
}