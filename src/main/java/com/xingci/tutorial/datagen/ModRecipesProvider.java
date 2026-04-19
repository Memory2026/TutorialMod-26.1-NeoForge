package com.xingci.tutorial.datagen;

import com.xingci.tutorial.TutorialMod;
import com.xingci.tutorial.block.ModBlocks;
import com.xingci.tutorial.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider {
    protected ModRecipesProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    private static final List<ItemLike> ICE_ETHER_LIST =
            List.of(ModItems.RAW_ICE_ETHER, ModBlocks.ICE_ETHER_ORE);

    @Override
    protected void buildRecipes() {
        oreSmelting(ICE_ETHER_LIST, RecipeCategory.MISC, CookingBookCategory.MISC,
                ModItems.ICE_ETHER, 0.7f, 200, "ice_ether");
        oreBlasting(ICE_ETHER_LIST, RecipeCategory.MISC, CookingBookCategory.MISC,
                ModItems.ICE_ETHER, 0.7f, 100, "ice_ether");

        nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.ICE_ETHER, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.ICE_ETHER_BLOCK);

        shaped(RecipeCategory.FOOD, Items.SUGAR, 3)
                .pattern("###")
                .define('#', Items.BEETROOT)
                .unlockedBy("has_beetroot", has(Items.BEETROOT))
                .save(output, TutorialMod.MOD_ID + ":sugar_from_beetroot");
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_ORE)
                .requires(ModItems.RAW_ICE_ETHER)
                .requires(Items.STONE)
                .unlockedBy("has_raw_ice_ether", has(ModItems.RAW_ICE_ETHER))
                .unlockedBy("has_stone", has(Items.STONE))
                .save(output);

        simpleCookingRecipe("campfire_cooking", CampfireCookingRecipe::new, 600,
                ModItems.RAW_ICE_ETHER, ModItems.ICE_ETHER, 0.75f);
    }

    protected <T extends AbstractCookingRecipe> void simpleCookingRecipe(
            String source, AbstractCookingRecipe.Factory<T> factory, int cookingTime, ItemLike base, ItemLike result, float experience
    ) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(base), RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, cookingTime, factory)
                .unlockedBy(getHasName(base), this.has(base))
                .save(this.output, TutorialMod.MOD_ID + ":" +  getItemName(result) + "_from_" + source);
    }

    protected void nineBlockStorageRecipes(RecipeCategory unpackedFormCategory, ItemLike unpackedForm, RecipeCategory packedFormCategory, ItemLike packedForm) {
        this.nineBlockStorageRecipes(
                unpackedFormCategory, unpackedForm, packedFormCategory, packedForm, getSimpleRecipeName(packedForm), null, getSimpleRecipeName(unpackedForm), null
        );
    }

    protected void nineBlockStorageRecipes(
            RecipeCategory unpackedFormCategory,
            ItemLike unpackedForm,
            RecipeCategory packedFormCategory,
            ItemLike packedForm,
            String packingRecipeId,
            @Nullable String packingRecipeGroup,
            String unpackingRecipeId,
            @Nullable String unpackingRecipeGroup
    ) {
        this.shapeless(unpackedFormCategory, unpackedForm, 9)
                .requires(packedForm)
                .group(unpackingRecipeGroup)
                .unlockedBy(getHasName(packedForm), this.has(packedForm))
                .save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, unpackingRecipeId)));
        this.shaped(packedFormCategory, packedForm)
                .define('#', unpackedForm)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(packingRecipeGroup)
                .unlockedBy(getHasName(unpackedForm), this.has(unpackedForm))
                .save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, packingRecipeId)));
    }

    protected void oreSmelting(
            List<ItemLike> smeltables,
            RecipeCategory craftingCategory,
            CookingBookCategory cookingCategory,
            ItemLike result,
            float experience,
            int cookingTime,
            String group
    ) {
        this.oreCooking(SmeltingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_smelting");
    }

    protected void oreBlasting(
            List<ItemLike> smeltables,
            RecipeCategory craftingCategory,
            CookingBookCategory cookingCategory,
            ItemLike result,
            float experience,
            int cookingTime,
            String group
    ) {
        this.oreCooking(BlastingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(
            AbstractCookingRecipe.Factory<T> factory,
            List<ItemLike> smeltables,
            RecipeCategory craftingCategory,
            CookingBookCategory cookingCategory,
            ItemLike result,
            float experience,
            int cookingTime,
            String group,
            String fromDesc
    ) {
        for (ItemLike item : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory)
                    .group(group)
                    .unlockedBy(getHasName(item), this.has(item))
                    .save(this.output, TutorialMod.MOD_ID + ":" +  getItemName(result) + fromDesc + "_" + getItemName(item));
        }
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipesProvider(registries, output);
        }

        @Override
        public String getName() {
            return "recipe gen";
        }
    }
}
