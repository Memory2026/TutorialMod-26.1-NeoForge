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
        add(ModItems.FIRE_ETHER.get(), "火之精气");
        add(ModItems.RAW_ICE_ETHER.get(), "冰魄精粹");

        add(ModItems.ANTHRACITE.get(), "无烟煤");
        add(ModItems.ANTHRACITE2.get(), "无烟煤2");

        add(ModItems.PROSPECTOR.get(), "探矿师");

        add(ModItems.FIRE_ETHER_AXE.get(), "灵火战斧");
        add(ModItems.FIRE_ETHER_SWORD.get(), "灵火剑");
        add(ModItems.FIRE_ETHER_SHOVEL.get(), "玄火铲");
        add(ModItems.FIRE_ETHER_HOE.get(), "烈焰以太锄");
        add(ModItems.FIRE_ETHER_PICKAXE.get(), "烈焰虚空镐");

        add(ModBlocks.ICE_ETHER_WALL.get(), "极冻能量墙");
        add(ModBlocks.ICE_ETHER_DOOR.get(),  "寒冰虚空之门");
        add(ModBlocks.ICE_ETHER_SLAB.get(),  "冰晶以太石板");
        add(ModBlocks.ICE_ETHER_FENCE.get(),  "冰之以太篱笆");
        add(ModBlocks.ICE_ETHER_STAIRS.get(),  "瑶台冰阶");
        add(ModBlocks.ICE_ETHER_BUTTON.get(),  "冰晶能量开关");
        add(ModBlocks.ICE_ETHER_TRAPDOOR.get(),  "寒霜能量暗门");
        add(ModBlocks.ICE_ETHER_FENCE_GATE.get(),  "冰晶结界门");
        add(ModBlocks.ICE_ETHER_PRESSURE_PLATE.get(),  "乙醚冰压板");

        add(ModItems.CARDBOARD.get(), "硬纸板");

        add(ModItems.CORN.get(), "玉米");
        add(ModItems.CHEESE.get(), "奶酪");
        add(ModItems.STRAWBERRY.get(), "草莓");

        add(ModBlocks.ICE_ETHER_ORE.get(), "极光冰元素结晶");

        add(ModBlocks.ICE_ETHER_BLOCK.get(), "冰以太块");
        add(ModBlocks.RAW_ICE_ETHER_BLOCK.get(), "天然冰晶能量块");

        add("itemGroup.raw_ice_ether", "冰魄精粹材料");
    }
}
