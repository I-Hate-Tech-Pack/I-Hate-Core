package github.ihatechpack.core.common.item.xray;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 16:23
 */
public class XrayShovel extends ShovelItem {
    public XrayShovel() {
        super(XrayTier.TIER, new Item.Properties().stacksTo(1).attributes(PickaxeItem.createAttributes(XrayTier.TIER, 1.5f, -3.5f)));
    }
}
