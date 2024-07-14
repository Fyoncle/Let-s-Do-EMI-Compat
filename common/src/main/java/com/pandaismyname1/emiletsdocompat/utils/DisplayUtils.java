package com.pandaismyname1.emiletsdocompat.utils;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;

import java.util.List;

public class DisplayUtils {
    public static void CreateWidget(BasicEmiRecipe recipe, WidgetHolder display, List<EmiIngredient> inputs, List<EmiStack> outputs) {
        var inputCount = inputs.size();
        var outputCount = outputs.size();
        var inputCols = inputCount > 1 ? 2 : 1;
        var outputCols = outputCount > 1 ? 2 : 1;
        var inputX = 0;
        var inputY = 0;
        var itemSize = 20;
        var spacing = 2;
        for (var i = 0; i < inputCount; i++) {
            var input = inputs.get(i);
            display.addSlot(input, inputX, inputY);
            inputX += itemSize + spacing;
            if (inputX >= itemSize * inputCols) {
                inputX = 0;
                inputY += itemSize + spacing;
            }
        }

        // Add an arrow texture to indicate processing
        display.addTexture(EmiTexture.EMPTY_ARROW, 60, 10);

        var outputX = 140 - (itemSize * outputCols) - (spacing * (outputCols - 1));
        var outputY = 0;
        for (var i = 0; i < outputCount; i++) {
            var output = outputs.get(i);
            display.addSlot(output, outputX, outputY).recipeContext(recipe);
            outputX += itemSize + spacing;
            if (outputX >= itemSize * outputCols) {
                outputX = inputX + 30;
                outputY += itemSize + spacing;
            }
        }

    }
}
