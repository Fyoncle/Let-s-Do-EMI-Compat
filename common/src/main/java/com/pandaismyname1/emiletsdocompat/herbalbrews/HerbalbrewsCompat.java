package com.pandaismyname1.emiletsdocompat.herbalbrews;

import com.pandaismyname1.emiletsdocompat.IEmiModCompat;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import satisfy.herbalbrews.HerbalBrews;
import satisfy.herbalbrews.registry.ObjectRegistry;

public class HerbalbrewsCompat implements IEmiModCompat {
    @Override
    public void init(EmiRegistry registry, RecipeManager manager) throws NoSuchFieldException {
        try {
            var recipeCategory = new EmiRecipeCategory(new ResourceLocation(HerbalBrews.MOD_ID, "cauldron_brewing"),
                    EmiStack.of(ObjectRegistry.CAULDRON.get()));
            registerRecipeType(registry, manager,
                    recipeCategory,
                    (recipe) -> {
                        registry.addRecipe(new CauldronBrewingRecipe(recipeCategory, (satisfy.herbalbrews.recipe.CauldronRecipe) recipe));
                    },
                    satisfy.herbalbrews.registry.RecipeTypeRegistry.CAULDRON_RECIPE_TYPE.get(),
                    EmiStack.of(ObjectRegistry.CAULDRON.get()));
        } catch (NoSuchFieldError | NoSuchFieldException | ClassNotFoundException e) {
        }

        try {
            var recipeCategory = new EmiRecipeCategory(new ResourceLocation(HerbalBrews.MOD_ID, "kettle_brewing"),
                    EmiStack.of(ObjectRegistry.TEA_KETTLE.get()));
            registerRecipeType(registry, manager,
                    recipeCategory,
                    (recipe) -> {
                        registry.addRecipe(new TeaKettleBrewingRecipe(recipeCategory, (satisfy.herbalbrews.recipe.TeaKettleRecipe) recipe));
                    },
                    satisfy.herbalbrews.registry.RecipeTypeRegistry.TEA_KETTLE_RECIPE_TYPE.get(),
                    EmiStack.of(ObjectRegistry.TEA_KETTLE.get()),
                    EmiStack.of(ObjectRegistry.COPPER_TEA_KETTLE.get()));
        } catch (NoSuchFieldError | NoSuchFieldException | ClassNotFoundException e) {
        }
    }
}
