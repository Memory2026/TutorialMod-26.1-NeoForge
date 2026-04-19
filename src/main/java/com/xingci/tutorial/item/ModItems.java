package com.xingci.tutorial.item;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.TutorialModClient;
import com.xingci.tutorial.item.custom.ModFuelItem;
import com.xingci.tutorial.item.custom.ProspectorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> ICE_ETHER =
            ITEMS.registerSimpleItem("ice_ether");
    public static final DeferredItem<Item> RAW_ICE_ETHER =
            ITEMS.registerSimpleItem("raw_ice_ether");

    public static final DeferredItem<Item> ANTHRACITE =
            ITEMS.registerItem("anthracite", p -> new ModFuelItem(p, 3600));
    public static final DeferredItem<Item> ANTHRACITE2 =
            ITEMS.registerSimpleItem("anthracite2");

    public static final DeferredItem<Item> PROSPECTOR =
            ITEMS.registerItem("prospector",
                    p -> new ProspectorItem(p.durability(512)));

    public static final DeferredItem<Item> CARDBOARD =
            ITEMS.registerSimpleItem("material/cardboard");

    public static final DeferredItem<Item> CORN =
            ITEMS.registerSimpleItem("corn",
                    () -> new Item.Properties().food(ModFoods.CORN));
    public static final DeferredItem<Item> STRAWBERRY =
            ITEMS.registerSimpleItem("strawberry",
                    () -> new Item.Properties().food(ModFoods.STRAWBERRY, ModConsumables.STRAWBERRY));
    public static final DeferredItem<Item> CHEESE =
            ITEMS.registerSimpleItem("cheese",
                    () -> new Item.Properties().food(ModFoods.CHEESE, ModConsumables.CHEESE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        TutorialMod.LOGGER.info("registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
