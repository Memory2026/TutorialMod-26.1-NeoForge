package com.xingci.tutorial.datagen;

import com.xingci.tutorial.block.ModBlocks;
import com.xingci.tutorial.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public ModBlockLootTablesProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ICE_ETHER_BLOCK.get());
        dropSelf(ModBlocks.RAW_ICE_ETHER_BLOCK.get());

        dropSelf(ModBlocks.ICE_ETHER_STAIRS.get());

        dropSelf(ModBlocks.ICE_ETHER_BUTTON.get());

        dropSelf(ModBlocks.ICE_ETHER_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.ICE_ETHER_WALL.get());

        dropSelf(ModBlocks.ICE_ETHER_FENCE_GATE.get());

        dropSelf(ModBlocks.ICE_ETHER_FENCE.get());

        dropSelf(ModBlocks.ICE_ETHER_TRAPDOOR.get());

        add(ModBlocks.ICE_ETHER_DOOR.get(), createDoorTable(ModBlocks.ICE_ETHER_DOOR.get()));

        add(ModBlocks.ICE_ETHER_SLAB.get(), createSlabItemTable(ModBlocks.ICE_ETHER_SLAB.get()));

        add(ModBlocks.ICE_ETHER_ORE.get(), createCopperOreLikeDrops(ModBlocks.ICE_ETHER_ORE.get(), ModItems.RAW_ICE_ETHER.get()));
    }

    protected LootTable.Builder createCopperOreLikeDrops(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected  Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
