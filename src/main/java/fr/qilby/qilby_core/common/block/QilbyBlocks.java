package fr.qilby.qilby_core.common.block;

import static fr.qilby.qilby_core.common.registry.Registration.REGISTRATE;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;

public class QilbyBlocks {
    public static void init(){}

    public static final BlockEntry<CoilBlock> DARK_MATTER_COIL = createCoilBlock(QilbyCoilBlock.CoilType.DARK_MATTER_COIL);
    public static final BlockEntry<CoilBlock> DARK_ENERGY_COIL = createCoilBlock(QilbyCoilBlock.CoilType.DARK_ENERGY_COIL);
    public static final BlockEntry<CoilBlock> RUNIC_STELLARITE_COIL = createCoilBlock(QilbyCoilBlock.CoilType.RUNIC_STELLARITE_COIL);
    public static final BlockEntry<CoilBlock> STELLARITE_COIL = createCoilBlock(QilbyCoilBlock.CoilType.STELLARITE_COIL);
    public static final BlockEntry<CoilBlock> THETA_COIL = createCoilBlock(QilbyCoilBlock.CoilType.THETA_COIL);





    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType){
        var coilBlock = REGISTRATE
                .block("machine_coil_%s".formatted(coilType.getName()),p -> new CoilBlock(p,coilType))
                .initialProperties(()-> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((s,l,q,e) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createCoilModel(coilType))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH,CustomTags.TOOL_TIERS[1])
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }
}
