package github.ihatechpack.core;

import github.ihatechpack.core.common.registry.ModItems;
import github.ihatechpack.core.common.registry.ModTabs;
import github.ihatechpack.core.data.DataGenerators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:10
 */
@Mod(value = IHateCore.MOD_ID)
public class IHateCore {
    public static final String MOD_ID = "ihatecore";
    private static IHateCore instance;

    public IHateCore(IEventBus modBus){
        instance = this;

        // register Items
        ModItems.register(modBus);
        // register Tabs
        ModTabs.REGISTER.register(modBus);
        // data generator
        modBus.addListener(DataGenerators::gatherData);
    }

    public static IHateCore getInstance() {
        return instance;
    }
}
