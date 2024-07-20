package com.yourname.modid.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(RenderLivingBase.class)
public abstract class livingEntityMixin <T extends EntityLivingBase> extends Render<T> {

    @Shadow protected abstract float getDeathMaxRotation(T p_77037_1_);

    Minecraft mc = Minecraft.getMinecraft();

    protected livingEntityMixin(RenderManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Inject(method = {"applyRotations"}, at = {@At(value = "HEAD")}, cancellable = true)
//    public void ss(T p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_, CallbackInfo ci) {
//        if(mc.player != null || mc.world != null){
//                        ci.cancel();
//
//        }

    protected void applyRotations(T p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_, CallbackInfo ci) {

        ci.cancel();

        GlStateManager.rotate(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
        if (false) {
            float f = ((float)p_77043_1_.deathTime + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
            f = MathHelper.sqrt(f);
            if (f > 1.0F) {
                f = 1.0F;
            }

            GlStateManager.rotate(f * this.getDeathMaxRotation(p_77043_1_), 0.0F, 0.0F, 1.0F);
        } else {
            String s = TextFormatting.getTextWithoutFormattingCodes(p_77043_1_.getName());
            if (s != null && ("Dinnerbone".equals(s) || "Grumm".equals(s)) && (!(p_77043_1_ instanceof EntityPlayer) || ((EntityPlayer)p_77043_1_).isWearing(EnumPlayerModelParts.CAPE))) {
                GlStateManager.translate(0.0F, p_77043_1_.height + 0.1F, 0.0F);
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            }
        }

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(T t) {
        return null;
    }
}
