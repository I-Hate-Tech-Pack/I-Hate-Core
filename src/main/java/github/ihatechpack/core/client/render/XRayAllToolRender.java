package github.ihatechpack.core.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import github.ihatechpack.core.IHateCore;
import github.ihatechpack.core.Res;
import github.ihatechpack.core.client.model.XRayAllToolModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/2/1 13:54
 */
public class XRayAllToolRender extends BlockEntityWithoutLevelRenderer {

    private final XRayAllToolModel model;
    private final ResourceLocation TEXTURE = Res.rl("textures/item/3d/xray_all_tool.png");

    public XRayAllToolRender(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
        this.model = new XRayAllToolModel(pEntityModelSet.bakeLayer(XRayAllToolModel.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        VertexConsumer solidConsumer = buffer.getBuffer(RenderType.entitySolid(TEXTURE));
        model.renderToBuffer(poseStack, solidConsumer, packedLight, packedOverlay, 0xFFFFFFFF);
        VertexConsumer bladeConsumer = buffer.getBuffer(RenderType.entityTranslucent(TEXTURE));
        model.renderBlade(poseStack, bladeConsumer, LightTexture.FULL_BRIGHT, packedOverlay, 0xBFFFFFFF);
        poseStack.popPose();
    }
}
