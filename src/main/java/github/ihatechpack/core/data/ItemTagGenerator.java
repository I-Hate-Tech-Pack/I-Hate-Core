package github.ihatechpack.core.data;

import github.ihatechpack.core.common.registry.ModItems;
import github.ihatechpack.core.data.tag.ModItemTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:31
 */
public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModItemTag.WRENCH_TAG_1).add(ModItems.WRENCH_ITEM.get());
        tag(ModItemTag.WRENCH_TAG_2).add(ModItems.WRENCH_ITEM.get());
        tag(ModItemTag.TOOLS_TAG).add(ModItems.WRENCH_ITEM.get());
    }
}
