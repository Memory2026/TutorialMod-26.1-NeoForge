package com.xingci.tutorial.datagen;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.block.ModBlocks;
import com.xingci.tutorial.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ICE_ETHER_BLOCK.get())
                .add(ModBlocks.ICE_ETHER_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ICE_ETHER_ORE.get());

        tag(ModBlockTags.ORE_TAGS)
                .addTag(BlockTags.COAL_ORES)
                .addTag(BlockTags.IRON_ORES)
                .addTag(BlockTags.GOLD_ORES)
                .addTag(BlockTags.LAPIS_ORES)
                .addTag(BlockTags.COPPER_ORES)
                .addTag(BlockTags.DIAMOND_ORES)
                .addTag(BlockTags.EMERALD_ORES)
                .addTag(BlockTags.REDSTONE_ORES)
                .add(ModBlocks.ICE_ETHER_ORE.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.ICE_ETHER_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ICE_ETHER_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.ICE_ETHER_WALL.get());

        tag(ModBlockTags.PICKAXE_AXE_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE);
    }
}
