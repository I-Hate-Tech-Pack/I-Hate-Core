package github.ihatechpack.core.data;

import github.ihatechpack.core.data.recipe.CookingProvider;
import github.ihatechpack.core.data.worldgen.ModWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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

        // common block model
        generator.addProvider(event.includeClient(), new BlockStateGenerator(output, existingFileHelper));
        // common item model
        generator.addProvider(event.includeClient(), new ItemModelGenerator(output, existingFileHelper));

        // block tag first
        BlockTagsProvider blockTagsProvider = new BlockTagGenerator(
                output, lookupProvider, existingFileHelper
        );
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // item tag first
        generator.addProvider(event.includeServer(), new ItemTagGenerator(
                output,
                lookupProvider,
                blockTagsProvider.contentsGetter()
        ));

        // loot table
        generator.addProvider(event.includeServer(), new LootTableGenerator(output, lookupProvider));
        // world generation
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(output, lookupProvider));
        // recipe
        generator.addProvider(event.includeServer(), new CookingProvider(output, lookupProvider));
    }
}
