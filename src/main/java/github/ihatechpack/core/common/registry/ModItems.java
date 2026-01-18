package github.ihatechpack.core.common.registry;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.common.item.CreateWrenchItem;
import github.ihatechpack.core.common.item.ProjecteTransformTableItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
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
    public static final List<DeferredHolder<Item, Item>> ITEMS = new LinkedList<>();
    public static final List<DeferredHolder<Item, Item>> DEFAULT_ITEMS = new LinkedList<>();

    public static final DeferredHolder<Item, Item> I_HATE_CORE = regDefault("ihatecore", ()->new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> WRENCH_ITEM = regSpecialWithlModel("wrench", CreateWrenchItem::new);
    public static final DeferredHolder<Item, Item> TRANSFORM_TABLE = regDefault("projecte_transform_table", ProjecteTransformTableItem::new);

    public static void register(IEventBus mod) {
        REGISTER.register(mod);
    }

    private static DeferredHolder<Item, Item> regDefault(String name, Supplier<Item> sup) {
        return AddToList(REGISTER.register(name, sup),DEFAULT_ITEMS,ITEMS);
    }

    private static DeferredHolder<Item, Item> regSpecialWithlModel(String name, Supplier<Item> sup) {
        return AddToList(REGISTER.register(name, sup),ITEMS);
    }

    @SafeVarargs
    private static DeferredHolder<Item, Item> AddToList(DeferredHolder<Item, Item> item, List<DeferredHolder<Item, Item>> ...holders) {
        Arrays.stream(holders).iterator().forEachRemaining(list->{
            list.add(item);
        });
        return item;
    }
}
