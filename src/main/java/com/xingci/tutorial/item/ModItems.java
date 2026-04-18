package com.xingci.tutorial.item;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.TutorialModClient;
import net.minecraft.world.item.Item;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> ICE_Ether =
            ITEMS.registerSimpleItem("ice_ether");
    public static final DeferredItem<Item> Raw_Ice_Ether =
            ITEMS.registerSimpleItem("raw_ice_ether");

    public static final DeferredItem<Item> CARDBOARD =
            ITEMS.registerSimpleItem("material/cardboard");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        TutorialMod.LOGGER.info("registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
