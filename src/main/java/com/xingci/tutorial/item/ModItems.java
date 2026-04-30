package com.xingci.tutorial.item;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.TutorialModClient;
import com.xingci.tutorial.item.custom.ModFuelItem;
import com.xingci.tutorial.item.custom.ProspectorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;
import java.util.Properties;

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

    public static final DeferredItem<Item> FIRE_ETHER =
            ITEMS.registerSimpleItem("fire_ether");

    public static final DeferredItem<Item> FIRE_ETHER_SWORD =
            ITEMS.registerItem("fire_ether_sword",
                    p -> new Item(p.sword(ModToolMaterials.FIRE_ETHER,
                            3, -2.4F)));

    public static final DeferredItem<Item> FIRE_ETHER_PICKAXE =
            ITEMS.registerItem("fire_ether_pickaxe",
                    p -> new Item(p.pickaxe(ModToolMaterials.FIRE_ETHER,
                            1.0F, -2.8F)));

    public static final DeferredItem<Item> FIRE_ETHER_SHOVEL =
            ITEMS.registerItem("fire_ether_shovel",
                    p -> new ShovelItem(ModToolMaterials.FIRE_ETHER,
                            1.5F, -3.0F, p));

    public static final DeferredItem<Item> FIRE_ETHER_AXE =
            ITEMS.registerItem("fire_ether_axe",
                    p -> new AxeItem(ModToolMaterials.FIRE_ETHER,
                            5.0F, -3.0F, p));

    public static final DeferredItem<Item> FIRE_ETHER_HOE =
            ITEMS.registerItem("fire_ether_hoe",
                    p -> new HoeItem(ModToolMaterials.FIRE_ETHER,
                            -2, 0.0F, p));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        TutorialMod.LOGGER.info("registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
