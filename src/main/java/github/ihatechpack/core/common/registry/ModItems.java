package github.ihatechpack.core.common.registry;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.common.item.CreateWrenchItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:35
 */
public class ModItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.Items.createItems(IHateCore.MOD_ID);
    // for CreativeTabs
    public static final List<DeferredHolder<Item,Item>> ITEMS = new LinkedList<>();

    public static DeferredHolder<Item,Item> WRENCH_ITEM;

    public static void register(IEventBus mod){
        WRENCH_ITEM = reg("wrench",CreateWrenchItem::new);
        REGISTER.register(mod);
    }

    private static DeferredHolder<Item,Item> reg(String name, Supplier<Item> sup){
        return REGISTER.register(name,sup);
    }
}
