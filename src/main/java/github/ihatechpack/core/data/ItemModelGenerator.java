package github.ihatechpack.core.data;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/18 10:42
 */
public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IHateCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModItems.DEFAULT_ITEMS.forEach(item->{
            basicItem(item.get());
        });
    }
}
