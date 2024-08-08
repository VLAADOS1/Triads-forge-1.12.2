//package com.yourname.modid;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.Gui;
//import net.minecraft.client.gui.ScaledResolution;
//import net.minecraftforge.client.event.RenderGameOverlayEvent;
//import net.minecraftforge.fml.common.eventhandler.EventPriority;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.InputEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import static com.yourname.modid.Example.toggleBind;
//import static net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType.TEXT;
//
//public class Trids {
//    @SubscribeEvent
//    public void onDrawBar(RenderGameOverlayEvent.Post event) {
//
//        if (Example.on) {
//            if (event.getType() == TEXT) {
//
//                ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
//
//                int w = sr.getScaledWidth() / 3;
//                int h = sr.getScaledHeight() / 3;
//                for (int i = 1; i < 3; i++) {
//                    Gui.drawRect(w * i, 0, w * i + 1, sr.getScaledHeight(), -1);
//                    Gui.drawRect(0, h * i, sr.getScaledWidth(), h * i + 1, -1);
//                }
//            }
//        }
//
//    }
//
//}
