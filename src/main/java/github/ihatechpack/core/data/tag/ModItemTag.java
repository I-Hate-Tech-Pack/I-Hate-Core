package github.ihatechpack.core.data.tag;

import github.ihatechpack.core.Res;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:20
 */
public class ModItemTag {
    public static final TagKey<Item> WRENCH_TAG_1 = ItemTags.create(Res.rl("c", "wrenches"));
    public static final TagKey<Item> WRENCH_TAG_2 = ItemTags.create(Res.rl("c", "tools/wrench"));

    public static final TagKey<Item> TOOLS_TAG = ItemTags.create(Res.rl("c", "tools"));

}
