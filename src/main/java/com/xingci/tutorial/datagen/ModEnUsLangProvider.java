package com.xingci.tutorial.datagen;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.block.ModBlocks;
import com.xingci.tutorial.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ICE_ETHER.get(), "Ice Ether");
        add(ModItems.RAW_ICE_ETHER.get(), "raw Ice ether");
        add(ModItems.CARDBOARD.get(), "Cardboard");

        add(ModBlocks.ICE_ETHER_ORE.get(), "Ice Ether Ore");

        add(ModBlocks.ICE_ETHER_BLOCK.get(), "Ice Ether Block");
        add(ModBlocks.RAW_ICE_ETHER_BLOCK.get(), "Raw Ice Ether Block");

        add("itemGroup.raw_ice_ether", "Raw Ice Ether Tab");
    }
}
