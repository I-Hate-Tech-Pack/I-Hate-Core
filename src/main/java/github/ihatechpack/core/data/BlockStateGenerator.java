package github.ihatechpack.core.data;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.Res;
import github.ihatechpack.core.common.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 15:02
 */
public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IHateCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // it will generate the item models also
        simpleBlockWithItem(ModBlocks.XrayBlock.get(),models().getExistingFile(ModBlocks.XrayBlock.getId()));
    }
}
