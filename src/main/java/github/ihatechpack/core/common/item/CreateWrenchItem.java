package github.ihatechpack.core.common.item;

import github.ihatechpack.core.common.registry.ModItems;
import net.minecraft.world.item.Item;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:13
 */
public class CreateWrenchItem extends Item {

    public CreateWrenchItem(){
        super(new Item.Properties().stacksTo(1));
        // ModItems.ITEMS.add(this);
    }
}
