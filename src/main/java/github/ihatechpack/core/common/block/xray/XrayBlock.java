package github.ihatechpack.core.common.block.xray;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @description: TODO
 * @author: HowXu
 * @date: 2026/1/22 14:43
 */
public class XrayBlock extends Block {
    public XrayBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(10.0f)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 0) // 锁定为0
                .explosionResistance(2000.0f) // 2000 爆炸抗性?
                .sound(SoundType.METAL) // 金属声音
        );
    }

    @Override
    protected float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }
}
