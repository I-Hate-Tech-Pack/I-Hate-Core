package github.ihatechpack.core.common.item.xray;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 16:23
 */
public class XrayHoe extends HoeItem {
    public XrayHoe() {
        super(XrayTier.TIER, new Item.Properties().stacksTo(1).attributes(HoeItem.createAttributes(XrayTier.TIER, -3.0f, 0.0f)));
    }
}
