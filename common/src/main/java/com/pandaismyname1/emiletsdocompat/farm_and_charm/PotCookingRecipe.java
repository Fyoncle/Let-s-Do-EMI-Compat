package com.pandaismyname1.emiletsdocompat.farm_and_charm;


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
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class PotCookingRecipe extends BasicEmiRecipe {
    protected static final Supplier<RegistryAccess> REGISTRY_ACCESS =
            EnvExecutor.getEnvSpecific(() -> () -> () -> GameInstance.getClient().player.level().registryAccess(),
                    () -> () -> () -> GameInstance.getServer().registryAccess());
    public static final ResourceLocation TEXTURE = new ResourceLocation("farm_and_charm", "textures/gui/pot_gui.png");
    protected final ItemStack CONTAINER_ITEM;

    public PotCookingRecipe(EmiRecipeCategory category, net.satisfy.farm_and_charm.recipe.CookingPotRecipe recipe) {
        super(category, recipe.getId(), 70, 18);
        CONTAINER_ITEM = recipe.getContainer();
        var ingredients = recipe.getIngredients();
        for (var ingredient : ingredients) {
            this.inputs.add(EmiIngredient.of(ingredient));
        }
        this.outputs.add(EmiStack.of(recipe.getResultItem(REGISTRY_ACCESS.get())));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(TEXTURE, 0,0,  124, 60, 26, 12);
        widgets.addAnimatedTexture(TEXTURE, 67,3, 19, 29, 176, 16, 5000, true, false, false);
        widgets.addAnimatedTexture(TEXTURE, 98, 44, 16, 14, 176, 0, 5000, false, true, false);



        if (!this.inputs.isEmpty()) {
            var s = widgets.addSlot(this.inputs.get(0), 3, 4);
            s.drawBack(false);
        }

        if (this.inputs.size() > 1) {
            var s= widgets.addSlot(this.inputs.get(1), 21, 4);
            s.drawBack(false);
        }

        if (this.inputs.size() > 2) {
            var s= widgets.addSlot(this.inputs.get(1), 39, 4);
            s.drawBack(false);
        }

        if (this.inputs.size() > 3) {
            var s= widgets.addSlot(this.inputs.get(1), 3, 22);
            s.drawBack(false);
        }

        if (this.inputs.size() > 3) {
            var s= widgets.addSlot(this.inputs.get(1), 21, 22);
            s.drawBack(false);
        }

        if (this.inputs.size() > 3) {
            var s= widgets.addSlot(this.inputs.get(1), 39, 22);
            s.drawBack(false);
        }

        if (CONTAINER_ITEM != null) {
            var s = widgets.addSlot(EmiStack.of(CONTAINER_ITEM), 68, 43);
            s.drawBack(false);
        }

        if (!this.outputs.isEmpty()) {
            var s = widgets.addSlot(this.outputs.get(0), 97, 15);
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


