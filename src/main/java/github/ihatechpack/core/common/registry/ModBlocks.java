package github.ihatechpack.core.common.registry;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.common.block.xray.XrayBlock;
import net.minecraft.world.level.block.Block;
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
 * @date: 2026/1/22 15:02
 */
public class ModBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.Blocks.createBlocks(IHateCore.MOD_ID);
    // for CreativeTabs
    public static final List<DeferredHolder<Block, Block>> CUBE_BLOCKS = new LinkedList<>(); // this will have cubeAll Models in datagen
    public static final List<DeferredHolder<Block, Block>> BLOCKS = new LinkedList<>(); // should provide block model

    public static final DeferredHolder<Block, Block> XrayBlock = regDefault("xray_block", XrayBlock::new);

    public static void register(IEventBus mod) {
        REGISTER.register(mod);
    }

    private static DeferredHolder<Block, Block> regCube(String name, Supplier<Block> sup) {
        return AddToList(REGISTER.register(name, sup),CUBE_BLOCKS);
    }

    private static DeferredHolder<Block, Block> regDefault(String name, Supplier<Block> sup) {
        return AddToList(REGISTER.register(name, sup),BLOCKS);
    }

    @SafeVarargs
    private static DeferredHolder<Block, Block> AddToList(DeferredHolder<Block, Block> Block, List<DeferredHolder<Block, Block>> ...holders) {
        Arrays.stream(holders).iterator().forEachRemaining(list->{
            list.add(Block);
        });
        return Block;
    }
}
