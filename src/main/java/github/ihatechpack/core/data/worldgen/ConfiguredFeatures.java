package github.ihatechpack.core.data.worldgen;

import github.ihatechpack.core.Res;
import github.ihatechpack.core.common.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 17:09
 */
public class ConfiguredFeatures {
    // 矿石
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD = registerKey("xray_ore_overworld");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // 替换规则
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // 矿石目标列表
        List<OreConfiguration.TargetBlockState> overworldOres = List.of(OreConfiguration.target(stoneReplaceable, ModBlocks.XrayBlock.get().defaultBlockState()));

        // 注册
        register(context, OVERWORLD, Feature.ORE, new OreConfiguration(overworldOres, 16)); // 9 = 矿脉大小
    }

    // methods helper

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Res.rl(name));
    }

    private static <FC extends net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

