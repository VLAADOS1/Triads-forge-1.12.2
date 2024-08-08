package com.yourname.modid.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.charset.StandardCharsets;

@Mixin(NetworkManager.class)
public class MixinNetworkManagerMixin {

    boolean f = false;

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At(value = "HEAD"))
    public void render(Packet<?> p_179290_1_, CallbackInfo ci) {
        if (p_179290_1_ instanceof CPacketCustomPayload) {
            if (f) return;

            // Конвертируем строку в байты с использованием кодировки UTF-8, если необходимо
            String messageText = new String("Mod create by - ".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
            TextComponentString message = new TextComponentString(messageText);

            TextComponentString clickableLink = new TextComponentString("https://vk.com/mstresurs");
            clickableLink.setStyle(new Style().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/mstresurs"))
                    .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentTranslation("Click on link"))));

            message.appendSibling(clickableLink);

            Minecraft.getMinecraft().player.sendMessage(message);
            f = true;

            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                f = false;
            });
            thread.start();
        }
    }
}