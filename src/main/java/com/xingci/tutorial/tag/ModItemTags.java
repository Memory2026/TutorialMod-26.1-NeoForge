package com.xingci.tutorial.tag;

import com.xingci.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> SUGAR_TAG = bind("sugar_tag");
    public static final TagKey<Item> FIRE_ETHER_TOOL_MATERIALS = bind("fire_ether_tool_materials");

    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
