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
                    .icon(() -> new ItemStack(ModItems.ICE_Ether.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ICE_Ether);
                        output.accept(ModItems.Raw_Ice_Ether);

                        output.accept(ModBlocks.ICE_ETHER_ORE);

                        output.accept(ModBlocks.ICE_ETHER_BLOCK);
                        output.accept(ModBlocks.RAW_ICE_ETHER_BLOCK);

                        output.accept(ModItems.CARDBOARD);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        TutorialMod.LOGGER.info("Registering Mod Creative Mode Tabs for " + TutorialMod.MOD_ID);
    }
}
