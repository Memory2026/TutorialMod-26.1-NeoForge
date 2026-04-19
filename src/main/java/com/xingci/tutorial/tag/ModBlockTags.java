package com.xingci.tutorial.tag;

import com.xingci.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> ORE_TAGS = create("ore_tags");

    private static TagKey<net.minecraft.world.level.block.Block> create(String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
