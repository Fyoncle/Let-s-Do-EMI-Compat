package com.pandaismyname1.emiletsdocompat.vinery;

import com.pandaismyname1.emiletsdocompat.IEmiModCompat;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.satisfy.vinery.Vinery;
import net.satisfy.vinery.registry.ObjectRegistry;
import net.satisfy.vinery.registry.RecipeTypesRegistry;

public class VineryCompat implements IEmiModCompat {
    @Override
    public void init(EmiRegistry registry, RecipeManager manager) throws NoSuchFieldException {
        try {
            var recipeCategory = new EmiRecipeCategory(new ResourceLocation(Vinery.MOD_ID, "fermentation"),
                    EmiStack.of(ObjectRegistry.FERMENTATION_BARREL.get()));
            registerRecipeType(registry, manager,
                    recipeCategory,
                    (recipe) -> {registry.addRecipe(new FermentationRecipe(recipeCategory, (net.satisfy.vinery.recipe.FermentationBarrelRecipe) recipe));},
                    RecipeTypesRegistry.FERMENTATION_BARREL_RECIPE_TYPE.get(),
                    EmiStack.of(ObjectRegistry.FERMENTATION_BARREL.get()));
        } catch (NoSuchFieldError | NoSuchFieldException | ClassNotFoundException e) {
        }

        try {
            var recipeCategory = new EmiRecipeCategory(new ResourceLocation(Vinery.MOD_ID, "apple_mashing"),
                    EmiStack.of(ObjectRegistry.APPLE_PRESS.get()));
            registerRecipeType(registry, manager,
                    recipeCategory,
                    (recipe) -> {registry.addRecipe(new ApplePressingRecipe(recipeCategory, (net.satisfy.vinery.recipe.ApplePressRecipe) recipe));},
                    RecipeTypesRegistry.APPLE_PRESS_RECIPE_TYPE.get(),
                    EmiStack.of(ObjectRegistry.APPLE_PRESS.get()));
        } catch (NoSuchFieldError | NoSuchFieldException | ClassNotFoundException e) {
        }
    }
}
