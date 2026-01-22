package github.ihatechpack.core.common.registry;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.common.item.CreateWrenchItem;
import github.ihatechpack.core.common.item.ProjecteTransformTableItem;
import github.ihatechpack.core.common.item.xray.*;
import net.minecraft.world.item.BlockItem;
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
    public static final List<DeferredHolder<Item, Item>> BLOCK_ITEMS = new LinkedList<>();

    public static final DeferredHolder<Item, Item> I_HATE_CORE = regDefault("ihatecore", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> WRENCH_ITEM = regSpecialWithModel("wrench", CreateWrenchItem::new);
    public static final DeferredHolder<Item, Item> TRANSFORM_TABLE = regDefault("projecte_transform_table", ProjecteTransformTableItem::new);

    public static final DeferredHolder<Item, Item> XRAY_INGOT = regDefault("xray_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> XRAY_SWORD = regDefault("xray_sword", XraySword::new);
    public static final DeferredHolder<Item, Item> XRAY_PICKAXE = regDefault("xray_pickaxe", XrayPickaxe::new);
    public static final DeferredHolder<Item, Item> XRAY_AXE = regDefault("xray_axe", XrayAxe::new);
    public static final DeferredHolder<Item, Item> XRAY_SHOVEL = regDefault("xray_shovel", XrayShovel::new);
    public static final DeferredHolder<Item, Item> XRAY_HOE = regDefault("xray_hoe", XrayHoe::new);
    public static final DeferredHolder<Item, Item> XRAY_ALL_TOOL = regSpecialWithModel("xray_all_tool", XrayAllTool::new);


    // this should load after blocks
    public static void register(IEventBus mod) {
        REGISTER.register(mod);
        // register block items
        ModBlocks.BLOCKS.forEach(blockBlockDeferredHolder -> {
            regBlock(blockBlockDeferredHolder.getId().getPath(), () -> new BlockItem(blockBlockDeferredHolder.get(), new Item.Properties()));
        });
    }

    // for unspecial items
    private static DeferredHolder<Item, Item> regDefault(String name, Supplier<Item> sup) {
        return AddToList(REGISTER.register(name, sup), DEFAULT_ITEMS, ITEMS);
    }

    // for these have models
    private static DeferredHolder<Item, Item> regSpecialWithModel(String name, Supplier<Item> sup) {
        return AddToList(REGISTER.register(name, sup), ITEMS);
    }

    // for blocks
    private static void regBlock(String name, Supplier<Item> sup) {
        AddToList(REGISTER.register(name, sup), BLOCK_ITEMS, ITEMS);
    }

    @SafeVarargs
    private static DeferredHolder<Item, Item> AddToList(DeferredHolder<Item, Item> item, List<DeferredHolder<Item, Item>>... holders) {
        Arrays.stream(holders).iterator().forEachRemaining(list -> {
            list.add(item);
        });
        return item;
    }
}
