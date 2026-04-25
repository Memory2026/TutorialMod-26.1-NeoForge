package com.xingci.tutorial.item;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RAW_ICE_ETHER_TAB =
            CREATIVE_MODE_TABS.register("raw_ice_ether_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.raw_ice_ether"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> new ItemStack(ModItems.ICE_ETHER.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ICE_ETHER);
                        output.accept(ModItems.RAW_ICE_ETHER);

                        output.accept(ModItems.ANTHRACITE);
                        output.accept(ModItems.ANTHRACITE2);

                        output.accept(ModItems.PROSPECTOR);

                        output.accept(ModItems.CARDBOARD);

                        output.accept(ModItems.CORN);
                        output.accept(ModItems.CHEESE);
                        output.accept(ModItems.STRAWBERRY);

                        output.accept(ModBlocks.ICE_ETHER_ORE);

                        output.accept(ModBlocks.ICE_ETHER_BLOCK);
                        output.accept(ModBlocks.RAW_ICE_ETHER_BLOCK);

                        output.accept(ModBlocks.ICE_ETHER_STAIRS);
                        output.accept(ModBlocks.ICE_ETHER_SLAB);
                        output.accept(ModBlocks.ICE_ETHER_BUTTON);
                        output.accept(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
                        output.accept(ModBlocks.ICE_ETHER_FENCE);
                        output.accept(ModBlocks.ICE_ETHER_FENCE_GATE);
                        output.accept(ModBlocks.ICE_ETHER_WALL);
                        output.accept(ModBlocks.ICE_ETHER_DOOR);
                        output.accept(ModBlocks.ICE_ETHER_TRAPDOOR);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        TutorialMod.LOGGER.info("Registering Mod Creative Mode Tabs for " + TutorialMod.MOD_ID);
    }
}
