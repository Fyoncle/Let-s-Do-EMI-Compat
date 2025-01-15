package com.pandaismyname1.emiletsdocompat.meadow;

import com.pandaismyname1.emiletsdocompat.utils.DisplayUtils;
import dev.architectury.utils.EnvExecutor;
import dev.architectury.utils.GameInstance;
import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class CheeseFormRecipe extends BasicEmiRecipe {
    protected static final Supplier<RegistryAccess> REGISTRY_ACCESS =
            EnvExecutor.getEnvSpecific(() -> () -> () -> GameInstance.getClient().player.level().registryAccess(),
                    () -> () -> () -> GameInstance.getServer().registryAccess());
    public static final ResourceLocation TEXTURE = new ResourceLocation("meadow", "textures/gui/cheese_form_gui.png");

    public CheeseFormRecipe(EmiRecipeCategory category, net.satisfy.meadow.recipes.CheeseFormRecipe recipe) {
        super(category, recipe.getId(), 70, 18);
        var ingredients = recipe.getIngredients();
        for (var ingredient : ingredients) {
            this.inputs.add(EmiIngredient.of(ingredient));
        }
        this.outputs.add(EmiStack.of(recipe.getResultItem(REGISTRY_ACCESS.get())));
    }
    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(TEXTURE, 0,0,  124, 60, 26, 6);
        widgets.addAnimatedTexture(TEXTURE, 51, 30,26,10, 175, 4, 5000, true, false, false);
        widgets.addAnimatedTexture(TEXTURE, 50, 2,26,32, 175, 22, 5000, false, true, false);


        if (!this.inputs.isEmpty()) {
            var s = widgets.addSlot(this.inputs.get(0), 6, 26);
            s.drawBack(false);
        }

        if (this.inputs.size() > 1) {
            var s= widgets.addSlot(this.inputs.get(1), 24, 26);
            s.drawBack(false);
        }

        if (!this.outputs.isEmpty()) {
            var s = widgets.addSlot(this.outputs.get(0), 96, 26);
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