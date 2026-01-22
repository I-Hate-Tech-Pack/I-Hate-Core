package github.ihatechpack.core.common.item.xray;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;


/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 16:23
 */
public class XrayPickaxe extends PickaxeItem {
    public XrayPickaxe() {
        super(XrayTier.TIER, new Item.Properties().stacksTo(1).attributes(PickaxeItem.createAttributes(XrayTier.TIER, 1.0f, -2.8f)));
    }
}
