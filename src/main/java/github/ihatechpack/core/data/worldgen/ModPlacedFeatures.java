package github.ihatechpack.core.data.worldgen;

import github.ihatechpack.core.Res;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 17:12
 */
public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD = registerKey("xray_ore_overworld_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // 主世界矿石放置
        register(context, OVERWORLD, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD), commonOrePlacement(
                15,  // 每个区块尝试生成次数
                HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(0), // 完全还原的0-256
                        VerticalAnchor.absolute(256)
                )));
    }

    // 通用
    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }

    // 常见
    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier height) {
        return orePlacement(CountPlacement.of(count), height);
    }

    // 稀有=
    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier height) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), height);
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Res.rl(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
