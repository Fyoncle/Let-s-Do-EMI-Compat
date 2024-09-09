package com.pandaismyname1.emiletsdocompat.herbalbrews;

import com.pandaismyname1.emiletsdocompat.utils.DisplayUtils;
import dev.architectury.utils.EnvExecutor;
import dev.architectury.utils.GameInstance;
import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.core.RegistryAccess;

import java.util.function.Supplier;

public class TeaKettleBrewingRecipe extends BasicEmiRecipe {
    protected static final Supplier<RegistryAccess> REGISTRY_ACCESS =
            EnvExecutor.getEnvSpecific(() -> () -> () -> GameInstance.getClient().player.level().registryAccess(),
                    () -> () -> () -> GameInstance.getServer().registryAccess());

    public TeaKettleBrewingRecipe(EmiRecipeCategory category, satisfy.herbalbrews.recipe.TeaKettleRecipe recipe) {
        super(category, recipe.getId(), 70, 18);
        var ingredients = recipe.getIngredients();
        for (var ingredient : ingredients) {
            this.inputs.add(EmiIngredient.of(ingredient));
        }
        this.outputs.add(EmiStack.of(recipe.getResultItem(REGISTRY_ACCESS.get())));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        DisplayUtils.CreateWidget(this, widgets, this.inputs, this.outputs);
    }

    @Override
    public int getDisplayHeight() {
        return 40;
    }

    @Override
    public int getDisplayWidth() {
        return 140;
    }
}