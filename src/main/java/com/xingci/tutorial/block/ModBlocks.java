package com.xingci.tutorial.block;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> ICE_ETHER_BLOCK =
            registerBlock("ice_ether_block", Block::new,
                    () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE),true);
    public static final DeferredBlock<Block> RAW_ICE_ETHER_BLOCK =
            registerBlock("raw_ice_ether_block",
                    properties -> new Block(properties.strength(1.0F, 3.0F)),true);

    public static final DeferredBlock<Block> ICE_ETHER_ORE =
            registerBlock("ice_ether_ore",
                    properties -> new Block(properties.strength(1.0F, 3.0F)
                            .requiresCorrectToolForDrops()),true);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, Supplier<BlockBehaviour.Properties> properties, boolean shouldRegisterItem) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, func, properties);
        if (shouldRegisterItem) {
            ModItems.ITEMS.registerSimpleBlockItem(block);
        }
        return block;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, boolean shouldRegisterItem) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, func);
        if (shouldRegisterItem) {
            ModItems.ITEMS.registerSimpleBlockItem(block);
        }
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
    }
}
