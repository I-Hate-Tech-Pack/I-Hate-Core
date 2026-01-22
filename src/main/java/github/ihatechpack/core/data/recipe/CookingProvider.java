package github.ihatechpack.core.data.recipe;

import github.ihatechpack.core.Res;
import github.ihatechpack.core.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.concurrent.CompletableFuture;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 17:34
 */
public class CookingProvider extends RecipeProvider {

    public CookingProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        build(getBlock("xray_block"), ModItems.XRAY_INGOT.get()).save(recipeOutput, Res.rl("xray_block"));
    }

    SimpleCookingRecipeBuilder build(DeferredHolder<Item, Item> in, ItemLike out) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(in.get()), // input
                RecipeCategory.MISC,           // category
                out,                           // output
                1.0f,                          // exp
                200                            // time consume
        ).unlockedBy("has_" + in.getId().getPath() + "_cooking", has(in.get()));
    }

    // only consume time when data gen
    DeferredHolder<Item, Item> getBlock(String registryName) {
        return ModItems.BLOCK_ITEMS.stream().filter(itemItemDeferredHolder -> itemItemDeferredHolder.getId().getPath().equals(registryName)).findFirst().get();
    }
}
