package github.ihatechpack.core.common.item;

import com.mojang.blaze3d.platform.InputConstants;
import github.ihatechpack.core.Res;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/17 19:13
 */
public class CreateWrenchItem extends Item {

    public CreateWrenchItem(){
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(),InputConstants.KEY_W)){
            tooltipComponents.add(Res.tooltipWithStyle("congratulation_on_track", ChatFormatting.DARK_GRAY));
        }else{
            tooltipComponents.add(Res.tooltipWithStyle("create_wrench", ChatFormatting.GRAY));
        }
    }
}
