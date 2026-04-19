package com.xingci.tutorial.datagen;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.block.ModBlocks;
import com.xingci.tutorial.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModModelsProvider extends ModelProvider {
    public ModModelsProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.ICE_ETHER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_ICE_ETHER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.ANTHRACITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ANTHRACITE2.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.PROSPECTOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.CARDBOARD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.CORN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHEESE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STRAWBERRY.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.ICE_ETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.ICE_ETHER_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.RAW_ICE_ETHER_BLOCK.get());
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }
}
