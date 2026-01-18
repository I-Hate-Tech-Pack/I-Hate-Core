package github.ihatechpack.core.common.item;

import github.ihatechpack.core.Res;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/18 10:28
 */
public class ProjecteTransformTableItem extends Item {
    public ProjecteTransformTableItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        // a message client only
        if (level.isClientSide){
            player.sendSystemMessage(Res.tooltip("ahh_no_projecte"));
        }
        return super.use(level,player,usedHand);
    }
}
