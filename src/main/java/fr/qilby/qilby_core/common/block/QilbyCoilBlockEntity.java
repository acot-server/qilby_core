package fr.qilby.qilby_core.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class QilbyCoilBlockEntity extends BlockEntity {
    public QilbyCoilBlockEntity (BlockEntityType<?> type, BlockPos pos, BlockState blockState){
        super(type,pos,blockState);
    }
}
