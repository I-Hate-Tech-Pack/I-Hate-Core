package github.ihatechpack.core.common.registry;

import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.Res;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/18 11:02
 */
public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IHateCore.MOD_ID);
    private static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = REGISTER.register(IHateCore.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group.ihatecore.name"))
            .icon(() -> BuiltInRegistries.ITEM.get(Res.rl("ihatecore")).getDefaultInstance())
            .displayItems((par, output) -> {
                ModItems.ITEMS.forEach(itemDeferredHolder -> {
                    output.accept(itemDeferredHolder.get());
                });
            }).build());
}
