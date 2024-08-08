package com.yourname.modid.mixin;


import com.yourname.modid.Example;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType.TEXT;

@Mixin(EntityRenderer.class)
public abstract class MixinGameOverlay {
    @Shadow public abstract void setupOverlayRendering();

    @Inject(method = "updateCameraAndRender",
            at = @At(value = "INVOKE_STRING",
                    target = "Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V",
                    args = "ldc=gui"))
    public void ren(float p_181560_1_, long p_181560_2_, CallbackInfo ci) {

//        if( Minecraft.getMinecraft().currentScreen != null){
            if (Example.on) {
                GlStateManager.alphaFunc(516, 0.1F);
                this.setupOverlayRendering();
                    ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

                    int w = sr.getScaledWidth() / 3;
                    int h = sr.getScaledHeight() / 3;
                    for (int i = 1; i < 3; i++) {
                        Gui.drawRect(w * i, 0, w * i + 1, sr.getScaledHeight(), -1);
                        Gui.drawRect(0, h * i, sr.getScaledWidth(), h * i + 1, -1);
                    }
                }
//        }

    }
}
