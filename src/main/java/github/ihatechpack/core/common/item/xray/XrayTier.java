package github.ihatechpack.core.common.item.xray;

import github.ihatechpack.core.common.registry.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 16:26
 */
public enum XrayTier implements Tier {
    // base on (int)5, (int)12500, (float)50.0f, (float)15.0f, (int)125

    TIER(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,  // 需要的工具等级
            12500,      // 耐久度
            50.0F,     // 挖掘速度
            15.0F,      // 攻击伤害加成
            125,        // 附魔能力
            () -> Ingredient.of(ModItems.XRAY_INGOT.get())),  // 修复

    ALL_TOOL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            12500,
            30.0F,
            17.0F,
            25,
            () -> Ingredient.of(ModItems.XRAY_INGOT.get()));

    private final net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final java.util.function.Supplier<Ingredient> repairIngredient;

    XrayTier(net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block> incorrectBlocksForDrops, int uses, float speed, float attackDamageBonus, int enchantmentValue, java.util.function.Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
