package fr.qilby.qilby_core.mixin.gtceu;

import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import vazkii.botania.api.block.WandBindable;

@Debug(export = true)
@Mixin(value = MetaMachineBlockEntity.class, remap = false)
public class MetaMachineBlockEntityMixin implements WandBindable {
    @Override
    public boolean canSelect(Player player, ItemStack wand, BlockPos pos, Direction side) {
        MetaMachineBlockEntity self = (MetaMachineBlockEntity) (Object) this;
        if (self.getMetaMachine() instanceof WandBindable wb) {
            return wb.canSelect(player, wand, pos, side);
        }
        return false;
    }

    @Override
    public boolean bindTo(Player player, ItemStack wand, BlockPos pos, Direction side) {
        MetaMachineBlockEntity self = (MetaMachineBlockEntity) (Object) this;
        if (self.getMetaMachine() instanceof WandBindable wb) {
            return wb.bindTo(player, wand, pos, side);
        }
        return false;
    }

    @Override
    public @Nullable BlockPos getBinding() {
        MetaMachineBlockEntity self = (MetaMachineBlockEntity) (Object) this;
        if (self.getMetaMachine() instanceof WandBindable wb) {
            return wb.getBinding();
        }
        return null;
    }
}
