package github.ihatechpack.core;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:22
 */
public class Res {
    public static ResourceLocation rl(String reg) {
        return ResourceLocation.fromNamespaceAndPath(IHateCore.MOD_ID, reg);
    }

    public static ResourceLocation rl(String id, String reg) {
        return ResourceLocation.fromNamespaceAndPath(id, reg);
    }

    public static Component tooltip(String inner) {
        return Component.translatable(IHateCore.MOD_ID + ".tooltip." + inner);
    }

    public static Component tooltipWithStyle(String inner, ChatFormatting style) {
        return Component.translatable(IHateCore.MOD_ID + ".tooltip." + inner).withStyle(style);
    }
}
