package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.capability.ElectricItem;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import fr.qilby.qilby_core.QilbyCore;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import fr.qilby.qilby_core.common.registry.QilbyRegistration;
import net.minecraft.world.item.Item;
import com.gregtechceu.gtceu.common.data.models.GTModels;

import static com.gregtechceu.gtceu.common.data.GTItems.attach;
import static com.gregtechceu.gtceu.common.data.models.GTModels.overrideModel;
import static fr.qilby.qilby_core.common.registry.QilbyRegistration.REGISTRATE;

public class QilbyItems {
    static{
        REGISTRATE.creativeModeTab(() -> QilbyCreativeTab.MAIN);}


    public static ItemEntry<ComponentItem> DARK_MATTER_CAPACITOR = REGISTRATE
            .item("dark_matter_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(100_000_000, GTValues.UHV)))
            .register();
    public static ItemEntry<ComponentItem> DARK_ENERGY_CAPACITOR = REGISTRATE
            .item("dark_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(400_000_000, GTValues.UEV)))
            .register();
    public static ItemEntry<ComponentItem> RUNIC_ENERGY_CAPACITOR = REGISTRATE
            .item("runic_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(2_000_000_000, GTValues.UIV)))
            .register();
    public static ItemEntry<ComponentItem> STELLAR_ENERGY_CAPACITOR = REGISTRATE
            .item("stellar_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(8_000_000_000L, GTValues.UXV)))
            .register();
    public static ItemEntry<ComponentItem> GALACTIC_ENERGY_CAPACITOR = REGISTRATE
            .item("galactic_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(40_000_000_000L, GTValues.OpV)))
            .register();
    public static ItemEntry<ComponentItem> UNIVERSE_ENERGY_CAPACITOR = REGISTRATE
            .item("univese_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(100_000_000_000L, GTValues.MAX)))
            .register();
    public static ItemEntry<ComponentItem> DOFUS_ENERGY_CAPACITOR = REGISTRATE
            .item("dofus_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"),8))
            .onRegister(attach(ElectricStats.createRechargeableBattery(9_000_000_000_000_000_000L, GTValues.MAX)))
            .register();

}
