package github.ihatechpack.core.client;

import github.ihatechpack.core.common.registry.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 15:38
 */
@EventBusSubscriber
public class IHateCoreClient {
    // Some things for client render
    @SubscribeEvent
    public static void renderXrayBlockOverlay(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }
}
