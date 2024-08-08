package com.yourname.modid;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = Example.MOD_ID)
public class Example {
    public static final String MOD_ID = "example";

 public static boolean on = false;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("Hello world!");
    }

    public static KeyBinding toggleBind = new KeyBinding("Turn on the cross section", Keyboard.KEY_P, "Gold section");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
//        MinecraftForge.EVENT_BUS.register(new Trids());
        MinecraftForge.EVENT_BUS.register(new onEvent());

        ClientRegistry.registerKeyBinding(toggleBind);
    }



}
