package github.ihatechpack.core.client;

import github.ihatechpack.core.client.model.XRayAllToolModel;
import github.ihatechpack.core.client.render.XRayAllToolRender;
import github.ihatechpack.core.common.registry.ModItems;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 15:38
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class IHateCoreClient {

    // Some things for client render
    @SubscribeEvent
    public static void renderItem(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(XRayAllToolModel.LAYER_LOCATION, XRayAllToolModel::createBodyLayer);
    }

    // This is client only
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registryRender(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new XRayAllToolRender(net.minecraft.client.Minecraft.getInstance().getBlockEntityRenderDispatcher(), net.minecraft.client.Minecraft.getInstance().getEntityModels());
            }
        }, ModItems.XRAY_ALL_TOOL);
    }
}
