package github.ihatechpack.core.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import github.ihatechpack.core.Res;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class XRayAllToolModel extends Model {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Res.rl("xray_all_tool"), "main");

    private final ModelPart root;

    private final List<ModelPart> normalParts = new ArrayList<>();
    private final List<ModelPart> bladeParts = new ArrayList<>();

    public XRayAllToolModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.root = root;

        normalParts.add(root.getChild("handle"));
        normalParts.add(root.getChild("handle_top"));
        normalParts.add(root.getChild("head"));
        normalParts.add(root.getChild("neck"));
        normalParts.add(root.getChild("rear_bar"));
        normalParts.add(root.getChild("neck_angled"));
        normalParts.add(root.getChild("blade_holder_back"));
        normalParts.add(root.getChild("blade_holder_main"));
        normalParts.add(root.getChild("blade_holder_front"));
        normalParts.add(root.getChild("handle_base"));
        normalParts.add(root.getChild("handle_top_back"));

        bladeParts.add(root.getChild("blade_front_connector"));
        bladeParts.add(root.getChild("blade_back"));
        bladeParts.add(root.getChild("blade_front_upper"));
        bladeParts.add(root.getChild("blade_front_lower"));
        bladeParts.add(root.getChild("blade_back_small"));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Handle
        partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -1.0F, -3.0F, 1.0F, 16.0F, 1.0F), PartPose.ZERO);

        // Handle Top
        partdefinition.addOrReplaceChild("handle_top", CubeListBuilder.create().texOffs(34, 9).addBox(-0.5F, -3.5F, -3.5F, 2.0F, 5.0F, 2.0F), PartPose.ZERO);

        // Blade Back
        partdefinition.addOrReplaceChild("blade_back", CubeListBuilder.create().texOffs(42, 0).addBox(0.0F, -4.0F, -4.0F, 1.0F, 2.0F, 10.0F), PartPose.ZERO);

        // Head (Rotated)
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -5.7F, -5.5F, 3.0F, 3.0F, 6.0F), PartPose.rotation(0.0F, 0.0F, 0.7853982F)); // 45 degrees Z

        // Neck
        partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0) // 假设默认，原代码未指定neck的texOffs，请根据实际贴图修正
                .addBox(-0.5F, -6.0F, -7.0F, 2.0F, 2.0F, 8.0F), PartPose.ZERO);

        // Blade Front Upper (Rotated)
        partdefinition.addOrReplaceChild("blade_front_upper", CubeListBuilder.create().texOffs(60, 0).addBox(0.0F, -0.5333334F, -9.6F, 1.0F, 3.0F, 1.0F), PartPose.rotation(-0.7853982F, 0.0F, 0.0F));

        // Blade Front Lower (Rotated + Deformation)
        partdefinition.addOrReplaceChild("blade_front_lower", CubeListBuilder.create().texOffs(58, 0).addBox(0.0F, -9.58F, -4.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.rotation(0.7853982F, 0.0F, 0.0F));

        // Neck Angled (Rotated)
        partdefinition.addOrReplaceChild("neck_angled", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -8.2F, -2.5F, 2.0F, 1.0F, 1.0F), PartPose.rotation(0.7853982F, 0.0F, 0.0F));

        // Blade Front Connector
        partdefinition.addOrReplaceChild("blade_front_connector", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, -2.44F, -6.07F, 1.0F, 2.0F, 3.0F), PartPose.ZERO);

        // Blade Holder Back
        partdefinition.addOrReplaceChild("blade_holder_back", CubeListBuilder.create().texOffs(42, 14).addBox(-0.5F, -4.5F, 3.5F, 2.0F, 1.0F, 1.0F), PartPose.ZERO);

        // Blade Holder Main
        partdefinition.addOrReplaceChild("blade_holder_main", CubeListBuilder.create().texOffs(30, 16).addBox(-0.5F, -3.5F, -1.5F, 2.0F, 1.0F, 4.0F), PartPose.ZERO);

        // Blade Holder Front
        partdefinition.addOrReplaceChild("blade_holder_front", CubeListBuilder.create().texOffs(42, 12).addBox(-0.5F, -4.5F, 1.5F, 2.0F, 1.0F, 1.0F), PartPose.ZERO);

        // Rear Bar
        partdefinition.addOrReplaceChild("rear_bar", CubeListBuilder.create().texOffs(4, 10).addBox(0.0F, -5.3F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.ZERO);

        // Blade Back Small
        partdefinition.addOrReplaceChild("blade_back_small", CubeListBuilder.create().texOffs(60, 0).addBox(0.0F, -4.0F, 6.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);

        // Handle Base
        partdefinition.addOrReplaceChild("handle_base", CubeListBuilder.create().texOffs(26, 9).addBox(-0.5F, 15.0F, -3.5F, 2.0F, 4.0F, 2.0F), PartPose.ZERO);

        // Handle Top Back
        partdefinition.addOrReplaceChild("handle_top_back", CubeListBuilder.create().texOffs(37, 0).addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 1.0F), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int light, int overlay, int color) {
        for (ModelPart part : normalParts) {
            part.render(poseStack, vertexConsumer, light, overlay, color);
        }
    }

    public void renderBlade(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int light, int overlay, int color) {
        for (ModelPart part : bladeParts) {
            part.render(poseStack, vertexConsumer, light, overlay, color);
        }
    }
}