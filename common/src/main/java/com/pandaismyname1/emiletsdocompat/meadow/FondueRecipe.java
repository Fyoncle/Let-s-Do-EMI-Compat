package com.pandaismyname1.emiletsdocompat.meadow;

import dev.architectury.utils.EnvExecutor;
import dev.architectury.utils.GameInstance;
import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class FondueRecipe extends BasicEmiRecipe {
    protected static final Supplier<RegistryAccess> REGISTRY_ACCESS =
            EnvExecutor.getEnvSpecific(() -> () -> () -> GameInstance.getClient().player.level().registryAccess(),
                    () -> () -> () -> GameInstance.getServer().registryAccess());
    public static final ResourceLocation TEXTURE = new ResourceLocation("meadow", "textures/gui/fondue_gui.png");
    private final Ingredient BREAD;
    private final Ingredient FUEL;

    public FondueRecipe(EmiRecipeCategory category, net.satisfy.meadow.recipes.FondueRecipe recipe) {
        super(category, recipe.getId(), 70, 18);
        BREAD = recipe.getBread();
        FUEL = recipe.getFuel();
        var ingredients = recipe.getIngredients();
        for (var ingredient : ingredients) {
            this.inputs.add(EmiIngredient.of(ingredient));
        }
        this.outputs.add(EmiStack.of(recipe.getResultItem(REGISTRY_ACCESS.get())));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(TEXTURE, 0,0,  124, 60, 26, 6);
        widgets.addAnimatedTexture(TEXTURE, 61,18, 19, 29, 176, 16, 5000, true, false, false);


        var breadS = widgets.addSlot(EmiIngredient.of(BREAD), 14, 2);
        breadS.drawBack(false);

        var cheeseS = widgets.addSlot(EmiIngredient.of(FUEL), 14, 26);
        cheeseS.drawBack(false);

        if (!this.outputs.isEmpty()) {
            var s = widgets.addSlot(this.outputs.get(0), 93, 18);
            s.drawBack(false);
        }
    }

    @Override
    public int getDisplayHeight() {
        return 60;
    }

    @Override
    public int getDisplayWidth() {
        return 124;
    }
}