package github.ihatechpack.core.common.item.xray;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 16:23
 */
public class XrayAxe extends AxeItem {
    public XrayAxe() {
        super(XrayTier.TIER, new Item.Properties().stacksTo(1).attributes(AxeItem.createAttributes(XrayTier.TIER, 5.0f, -2.0f)));
    }
}
