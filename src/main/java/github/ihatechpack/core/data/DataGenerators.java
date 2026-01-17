package github.ihatechpack.core.data;

import github.ihatechpack.core.IHateCore;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:30
 */
public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // 方块标签（需要先生成）
        BlockTagsProvider blockTagsProvider = new BlockTagGenerator(
                output, lookupProvider, existingFileHelper
        );
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // 物品标签
        generator.addProvider(event.includeServer(), new ItemTagGenerator(
                output,
                lookupProvider,
                blockTagsProvider.contentsGetter()
        ));
    }
}
