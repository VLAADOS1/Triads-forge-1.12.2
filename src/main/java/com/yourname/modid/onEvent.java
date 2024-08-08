package com.yourname.modid;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.yourname.modid.Example.toggleBind;

public class onEvent {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (toggleBind.isPressed()) {
            Example.on = !Example.on;
        }
    }

}
