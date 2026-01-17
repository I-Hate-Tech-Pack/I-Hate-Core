package github.ihatechpack.core;

import net.minecraft.resources.ResourceLocation;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:22
 */
public class Res {
    public static ResourceLocation rl(String reg){
        return ResourceLocation.fromNamespaceAndPath(IHateCore.MOD_ID,reg);
    }

    public static ResourceLocation rl(String id,String reg){
        return ResourceLocation.fromNamespaceAndPath(id,reg);
    }
}
