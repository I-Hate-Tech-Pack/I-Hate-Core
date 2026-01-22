package github.ihatechpack.core.data.worldgen;

import github.ihatechpack.core.Res;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 17:14
 */
public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> OVERWORLD = registerKey("add_custom_ore_overworld");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // 在主世界所有生物群系
        context.register(OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),  // 所有主世界生物群系
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OVERWORLD)), GenerationStep.Decoration.UNDERGROUND_ORES  // 地下矿石生成阶段
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Res.rl(name));
    }
}
