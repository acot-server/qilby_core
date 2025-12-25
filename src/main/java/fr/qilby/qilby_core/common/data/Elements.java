package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class Elements {
    @SuppressWarnings("EmptyMethod")
    public static void init(){}

    public static final Element Wk = GTElements.createAndRegister(120,120,-1,null,"Wakfu","Wk",false);
    public static final Element Sts = GTElements.createAndRegister(120,120,-1,null,"Stasis","Wk-",false);
    public static final Element DMatter = GTElements.createAndRegister(0,0,-1,null,"Dark Matter","γ",false);
    public static final Element DEnergy = GTElements.createAndRegister(0,0,-1,null,"Dark Energy","Eγ",false);
    public static final Element Skyrium = GTElements.createAndRegister(59,69, -1, null, "Skyrium", "Sk", false);
}
