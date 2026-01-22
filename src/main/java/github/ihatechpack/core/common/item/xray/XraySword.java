package github.ihatechpack.core.common.item.xray;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 16:23
 */
public class XraySword extends SwordItem {
    public XraySword() {
        super(XrayTier.TIER, new Item.Properties().stacksTo(1).attributes(SwordItem.createAttributes(XrayTier.TIER, 3, -2.4f)));
    }
}
