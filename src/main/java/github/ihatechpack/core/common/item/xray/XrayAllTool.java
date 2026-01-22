package github.ihatechpack.core.common.item.xray;

import github.ihatechpack.core.Res;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 17:56
 */
public class XrayAllTool extends DiggerItem {
    public XrayAllTool() {
        super(XrayTier.ALL_TOOL, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties()
                .component(DataComponents.TOOL, createToolProperties(XrayTier.ALL_TOOL))
                .attributes(ItemAttributeModifiers.builder()
                        .add(Attributes.ATTACK_DAMAGE,
                                new AttributeModifier(Res.rl("xray_all_tool_damage"), 21.0, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND)
                        .add(Attributes.ATTACK_SPEED,
                                new AttributeModifier(Res.rl("xray_all_tool_speed"), 2.0, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND)
                        .add(Attributes.MINING_EFFICIENCY,
                                new AttributeModifier(Res.rl("xray_all_tool_mining"), 15, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND)
                        .build()));

    }

    private static Tool createToolProperties(Tier tier) {
        return new Tool(List.of(
                // axe
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, tier.getSpeed()),
                // pickaxe
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, tier.getSpeed()),
                // shovel
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_SHOVEL, tier.getSpeed()),
                // sword
                Tool.Rule.minesAndDrops(BlockTags.SWORD_EFFICIENT, tier.getSpeed())), 1.0F, 4);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_PICKAXE_ACTIONS.contains(itemAbility) || ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility) || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(itemAbility);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        // 检查方块是否可被镐、斧或锹挖掘
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            // 返回基础速度（可在属性中设置）乘以效率附魔加成
            return super.getDestroySpeed(stack, state) * 1.2f;
        }
        // 对于剑高效方块（非挖掘，如快速破坏蜘蛛网），也返回较高速度
        if (state.is(BlockTags.SWORD_EFFICIENT)) {
            return 15.0F;
        }
        return super.getDestroySpeed(stack, state);
    }
}
