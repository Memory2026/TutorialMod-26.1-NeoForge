package com.xingci.tutorial.datagen;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.block.ModBlocks;
import com.xingci.tutorial.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ICE_ETHER.get(), "冰之精气");
        add(ModItems.RAW_ICE_ETHER.get(), "冰魄精粹");
        add(ModItems.CARDBOARD.get(), "硬纸板");

        add(ModBlocks.ICE_ETHER_ORE.get(), "极光冰元素结晶");

        add(ModBlocks.ICE_ETHER_BLOCK.get(), "冰以太块");
        add(ModBlocks.RAW_ICE_ETHER_BLOCK.get(), "天然冰晶能量块");

        add("itemGroup.raw_ice_ether", "冰魄精粹材料");
    }
}
