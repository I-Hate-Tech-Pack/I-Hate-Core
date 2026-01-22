package github.ihatechpack.core.data;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.common.registry.ModBlocks;
import github.ihatechpack.core.data.tag.ModBlockTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:33
 */
public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IHateCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // xray_ores tag
        tag(ModBlockTag.XRAY_ORE).add(ModBlocks.XrayBlock.get());
        // tool tag
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.XrayBlock.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.XrayBlock.get());
    }
}
