package com.pandaismyname1.emiletsdocompat;

import com.pandaismyname1.emiletsdocompat.bakery.BakingStationRecipe;
import com.pandaismyname1.emiletsdocompat.bakery.CraftingBowlRecipe;
import com.pandaismyname1.emiletsdocompat.bakery.PotCookingRecipe;
import com.pandaismyname1.emiletsdocompat.bakery.StoveRecipe;
import com.pandaismyname1.emiletsdocompat.beachparty.MiniFridgeMixingRecipe;
import com.pandaismyname1.emiletsdocompat.beachparty.TikiBarMixingRecipe;
import com.pandaismyname1.emiletsdocompat.brewery.BrewingRecipe;
import com.pandaismyname1.emiletsdocompat.brewery.DryingRecipe;
import com.pandaismyname1.emiletsdocompat.vinery.ApplePressingRecipe;
import com.pandaismyname1.emiletsdocompat.vinery.FermentationRecipe;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.satisfy.bakery.Bakery;
import net.satisfy.bakery.registry.ObjectRegistry;
import net.satisfy.brewery.Brewery;
import net.satisfy.brewery.registry.RecipeTypeRegistry;
import net.satisfy.candlelight.Candlelight;
import net.satisfy.meadow.Meadow;
import net.satisfy.vinery.Vinery;
import net.satisfy.vinery.registry.RecipeTypesRegistry;
import satisfy.beachparty.Beachparty;
import satisfy.beachparty.registry.RecipeRegistry;
import satisfy.herbalbrews.HerbalBrews;

@EmiEntrypoint
public class Emi_letsdo_compat implements EmiPlugin {
    public static final String MOD_ID = "emi_letsdo_compat";
    /*
    fermentation
    apple press

    baking station
    crafting bowl
    stove
    pot cooking

    mini fridge mixing
    tiki bar mixing

    brewing
    drying

    pan cooking
    pot cooking

    cauldron brewing
    tea kettle brewing

    cheese forming
    cooking cauldron
    fondue
    woodcutting
     */

    // Textures
    public static final ResourceLocation FERMENTATION_TEXTURE = new ResourceLocation("vinery", "textures/item/apple_juice.png");
    public static final ResourceLocation APPLE_PRESS_TEXTURE = new ResourceLocation("vinery", "textures/item/apple_wine.png");
    public static final ResourceLocation BAKING_STATION_TEXTURE = new ResourceLocation("bakery", "textures/item/strawberry_cake.png");
    public static final ResourceLocation CRAFTING_BOWL_TEXTURE = new ResourceLocation("bakery", "textures/item/dough.png");
    public static final ResourceLocation STOVE_TEXTURE = new ResourceLocation("bakery", "textures/item/baguette.png");
    public static final ResourceLocation BAKERY_POT_COOKING_TEXTURE = new ResourceLocation("bakery", "textures/item/small_pot_cooking.png");
    public static final ResourceLocation MINI_FRIDGE_MIXING_TEXTURE = new ResourceLocation("beachparty", "textures/item/mini_fridge.png");
    public static final ResourceLocation TIKI_BAR_MIXING_TEXTURE = new ResourceLocation("beachparty", "textures/item/melon_cocktail.png");
    public static final ResourceLocation BREWING_TEXTURE = new ResourceLocation("brewery", "textures/item/beer_mug.png");
    public static final ResourceLocation DRYING_TEXTURE = new ResourceLocation("brewery", "textures/item/silo_wood.png");
    public static final ResourceLocation PAN_COOKING_TEXTURE = new ResourceLocation("candlelight", "textures/item/cooking_pan.png");
    public static final ResourceLocation CANDLELIGHT_POT_COOKING_TEXTURE = new ResourceLocation("candlelight", "textures/item/cooking_pot.png");
    public static final ResourceLocation CAULDRON_BREWING_TEXTURE = new ResourceLocation("herbalbrews", "textures/item/cauldron.png");
    public static final ResourceLocation TEA_KETTLE_BREWING_TEXTURE = new ResourceLocation("herbalbrews", "textures/item/tea_kettle.png");
    public static final ResourceLocation CHEESE_FORMING_TEXTURE = new ResourceLocation("meadow", "textures/item/cheese_form.png");
    public static final ResourceLocation COOKING_CAULDRON_TEXTURE = new ResourceLocation("meadow", "textures/item/cooking_cauldron.png");
    public static final ResourceLocation FONDUE_TEXTURE = new ResourceLocation("meadow", "textures/item/fondue.png");
    public static final ResourceLocation WOODCUTTING_TEXTURE = new ResourceLocation("meadow", "textures/item/woodcutter.png");

    /*
    Additiona Stoves:

    public static final RegistrySupplier<Block> COBBLESTONE_STOVE;
    public static final RegistrySupplier<Block> SANDSTONE_STOVE;
    public static final RegistrySupplier<Block> STONE_BRICKS_STOVE;
    public static final RegistrySupplier<Block> DEEPSLATE_STOVE;
    public static final RegistrySupplier<Block> GRANITE_STOVE;
    public static final RegistrySupplier<Block> END_STOVE;
    public static final RegistrySupplier<Block> MUD_STOVE;
    public static final RegistrySupplier<Block> QUARTZ_STOVE;
    public static final RegistrySupplier<Block> RED_NETHER_BRICKS_STOVE;
     */


    // Workstations
    public static final EmiStack FERMENTATION_WORKSTATION = EmiStack.of(net.satisfy.vinery.registry.ObjectRegistry.FERMENTATION_BARREL.get());
    public static final EmiStack APPLE_PRESS_WORKSTATION = EmiStack.of(net.satisfy.vinery.registry.ObjectRegistry.APPLE_PRESS.get());
    public static final EmiStack BAKING_STATION_WORKSTATION = EmiStack.of(ObjectRegistry.BAKER_STATION.get());
    public static final EmiStack CRAFTING_BOWL_WORKSTATION = EmiStack.of(net.satisfy.bakery.registry.ObjectRegistry.CRAFTING_BOWL.get());
    public static final EmiStack STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.BRICK_STOVE.get());
    public static final EmiStack COBBLE_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.COBBLESTONE_STOVE.get());
    public static final EmiStack SANDSTONE_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.SANDSTONE_STOVE.get());
    public static final EmiStack STONE_BRICKS_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.STONE_BRICKS_STOVE.get());
    public static final EmiStack DEEPSLATE_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.DEEPSLATE_STOVE.get());
    public static final EmiStack GRANITE_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.GRANITE_STOVE.get());
    public static final EmiStack END_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.END_STOVE.get());
    public static final EmiStack MUD_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.MUD_STOVE.get());
    public static final EmiStack QUARTZ_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.QUARTZ_STOVE.get());
    public static final EmiStack RED_NETHER_BRICKS_STOVE_WORKSTATION = EmiStack.of(ObjectRegistry.RED_NETHER_BRICKS_STOVE.get());
    public static final EmiStack BAKERY_POT_COOKING_WORKSTATION = EmiStack.of(ObjectRegistry.SMALL_COOKING_POT.get());
    public static final EmiStack MINI_FRIDGE_MIXING_WORKSTATION = EmiStack.of(satisfy.beachparty.registry.ObjectRegistry.MINI_FRIDGE.get());
    public static final EmiStack TIKI_BAR_MIXING_WORKSTATION = EmiStack.of(satisfy.beachparty.registry.ObjectRegistry.TIKI_BAR.get());
    public static final EmiStack BREWING_WORKSTATION = EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.WOODEN_BREWINGSTATION.get());
    public static final EmiStack COPPER_BREWING_WORKSTATION = EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.COPPER_BREWINGSTATION.get());
    public static final EmiStack NETHERITE_BREWING_WORKSTATION = EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.NETHERITE_BREWINGSTATION.get());
    public static final EmiStack DRYING_WORKSTATION = EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.SILO_WOOD.get());
    public static final EmiStack COPPER_DRYING_WORKSTATION = EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.SILO_COPPER.get());
    public static final EmiStack PAN_COOKING_WORKSTATION = EmiStack.of(net.satisfy.candlelight.registry.ObjectRegistry.COOKING_PAN.get());
    public static final EmiStack CANDLELIGHT_POT_COOKING_WORKSTATION = EmiStack.of(net.satisfy.candlelight.registry.ObjectRegistry.COOKING_POT.get());
    public static final EmiStack CAULDRON_BREWING_WORKSTATION = EmiStack.of(satisfy.herbalbrews.registry.ObjectRegistry.CAULDRON.get());
    public static final EmiStack TEA_KETTLE_BREWING_WORKSTATION = EmiStack.of(satisfy.herbalbrews.registry.ObjectRegistry.TEA_KETTLE.get());
    public static final EmiStack CHEESE_FORMING_WORKSTATION = EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.CHEESE_FORM.get());
    public static final EmiStack COOKING_CAULDRON_WORKSTATION = EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.COOKING_CAULDRON.get());
    public static final EmiStack FONDUE_WORKSTATION = EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.FONDUE.get());
    public static final EmiStack WOODCUTTING_WORKSTATION = EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.WOODCUTTER.get());

    // Categories
    public static final EmiRecipeCategory FERMENTATION
            = new EmiRecipeCategory(new ResourceLocation(Vinery.MOD_ID, "fermentation"), EmiStack.of(net.satisfy.vinery.registry.ObjectRegistry.FERMENTATION_BARREL.get()));
    public static final EmiRecipeCategory APPLE_PRESS
            = new EmiRecipeCategory(new ResourceLocation(Vinery.MOD_ID, "apple_mashing"), EmiStack.of(net.satisfy.vinery.registry.ObjectRegistry.APPLE_PRESS.get()));
    public static final EmiRecipeCategory BAKING_STATION
            = new EmiRecipeCategory(new ResourceLocation(Bakery.MOD_ID, "baking_station"), EmiStack.of(ObjectRegistry.BAKER_STATION.get()));
    public static final EmiRecipeCategory CRAFTING_BOWL
            = new EmiRecipeCategory(new ResourceLocation(Bakery.MOD_ID, "crafting_bowl"), EmiStack.of(net.satisfy.bakery.registry.ObjectRegistry.CRAFTING_BOWL.get()));
    public static final EmiRecipeCategory STOVE
            = new EmiRecipeCategory(new ResourceLocation(Bakery.MOD_ID, "stove"), EmiStack.of(ObjectRegistry.BRICK_STOVE.get()));
    public static final EmiRecipeCategory BAKERY_POT_COOKING
            = new EmiRecipeCategory(new ResourceLocation(Bakery.MOD_ID, "pot_cooking"), EmiStack.of(ObjectRegistry.SMALL_COOKING_POT.get()));
    public static final EmiRecipeCategory MINI_FRIDGE_MIXING
            = new EmiRecipeCategory(new ResourceLocation(Beachparty.MOD_ID, "mini_fridge_mixing"), EmiStack.of(satisfy.beachparty.registry.ObjectRegistry.MINI_FRIDGE.get()));
    public static final EmiRecipeCategory TIKI_BAR_MIXING
            = new EmiRecipeCategory(new ResourceLocation(Beachparty.MOD_ID, "tiki_bar_mixing"), EmiStack.of(satisfy.beachparty.registry.ObjectRegistry.TIKI_BAR.get()));
    public static final EmiRecipeCategory BREWING
            = new EmiRecipeCategory(new ResourceLocation(Brewery.MOD_ID, "brewing"), EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.WOODEN_BREWINGSTATION.get()));
    public static final EmiRecipeCategory DRYING
            = new EmiRecipeCategory(new ResourceLocation(Brewery.MOD_ID, "drying"), EmiStack.of(net.satisfy.brewery.registry.ObjectRegistry.SILO_WOOD.get()));
    public static final EmiRecipeCategory PAN_COOKING
            = new EmiRecipeCategory(new ResourceLocation(Candlelight.MOD_ID, "pan_cooking"), EmiStack.of(net.satisfy.candlelight.registry.ObjectRegistry.COOKING_PAN.get()));
    public static final EmiRecipeCategory CANDLELIGHT_POT_COOKING
            = new EmiRecipeCategory(new ResourceLocation(Candlelight.MOD_ID, "pot_cooking"), EmiStack.of(net.satisfy.candlelight.registry.ObjectRegistry.COOKING_POT.get()));
    public static final EmiRecipeCategory CAULDRON_BREWING
            = new EmiRecipeCategory(new ResourceLocation(HerbalBrews.MOD_ID, "cauldron_brewing"), EmiStack.of(satisfy.herbalbrews.registry.ObjectRegistry.CAULDRON.get()));
    public static final EmiRecipeCategory TEA_KETTLE_BREWING
            = new EmiRecipeCategory(new ResourceLocation(HerbalBrews.MOD_ID, "kettle_brewing"), EmiStack.of(satisfy.herbalbrews.registry.ObjectRegistry.TEA_KETTLE.get()));
    public static final EmiRecipeCategory CHEESE_FORMING
            = new EmiRecipeCategory(new ResourceLocation(Meadow.MOD_ID, "cheese"), EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.CHEESE_FORM.get()));
    public static final EmiRecipeCategory COOKING_CAULDRON
            = new EmiRecipeCategory(new ResourceLocation(Meadow.MOD_ID, "cooking"), EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.COOKING_CAULDRON.get()));
    public static final EmiRecipeCategory FONDUE
            = new EmiRecipeCategory(new ResourceLocation(Meadow.MOD_ID, "fondue"), EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.FONDUE.get()));
    public static final EmiRecipeCategory WOODCUTTING
            = new EmiRecipeCategory(new ResourceLocation(Meadow.MOD_ID, "woodcutting"), EmiStack.of(net.satisfy.meadow.registry.ObjectRegistry.WOODCUTTER.get()));

    @Override
    public void register(EmiRegistry registry) {
        // Tell EMI to add a tab for your category
        registry.addCategory(FERMENTATION);
        registry.addCategory(APPLE_PRESS);
        registry.addCategory(BAKING_STATION);
        registry.addCategory(CRAFTING_BOWL);
        registry.addCategory(STOVE);
        registry.addCategory(BAKERY_POT_COOKING);
        registry.addCategory(MINI_FRIDGE_MIXING);
        registry.addCategory(TIKI_BAR_MIXING);
        registry.addCategory(BREWING);
        registry.addCategory(DRYING);
        registry.addCategory(PAN_COOKING);
        registry.addCategory(CANDLELIGHT_POT_COOKING);
        registry.addCategory(CAULDRON_BREWING);
        registry.addCategory(TEA_KETTLE_BREWING);
        registry.addCategory(CHEESE_FORMING);
        registry.addCategory(COOKING_CAULDRON);
        registry.addCategory(FONDUE);
        registry.addCategory(WOODCUTTING);

        // Add all the workstations your category uses
        registry.addWorkstation(FERMENTATION, FERMENTATION_WORKSTATION);
        registry.addWorkstation(APPLE_PRESS, APPLE_PRESS_WORKSTATION);
        registry.addWorkstation(BAKING_STATION, BAKING_STATION_WORKSTATION);
        registry.addWorkstation(CRAFTING_BOWL, CRAFTING_BOWL_WORKSTATION);
        registry.addWorkstation(STOVE, STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, COBBLE_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, SANDSTONE_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, STONE_BRICKS_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, DEEPSLATE_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, GRANITE_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, END_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, MUD_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, QUARTZ_STOVE_WORKSTATION);
        registry.addWorkstation(STOVE, RED_NETHER_BRICKS_STOVE_WORKSTATION);
        registry.addWorkstation(BAKERY_POT_COOKING, BAKERY_POT_COOKING_WORKSTATION);
        registry.addWorkstation(MINI_FRIDGE_MIXING, MINI_FRIDGE_MIXING_WORKSTATION);
        registry.addWorkstation(TIKI_BAR_MIXING, TIKI_BAR_MIXING_WORKSTATION);
        registry.addWorkstation(BREWING, BREWING_WORKSTATION);
        registry.addWorkstation(BREWING, COPPER_BREWING_WORKSTATION);
        registry.addWorkstation(BREWING, NETHERITE_BREWING_WORKSTATION);
        registry.addWorkstation(DRYING, DRYING_WORKSTATION);
        registry.addWorkstation(DRYING, COPPER_DRYING_WORKSTATION);
        registry.addWorkstation(PAN_COOKING, PAN_COOKING_WORKSTATION);
        registry.addWorkstation(CANDLELIGHT_POT_COOKING, CANDLELIGHT_POT_COOKING_WORKSTATION);
        registry.addWorkstation(CAULDRON_BREWING, CAULDRON_BREWING_WORKSTATION);
        registry.addWorkstation(TEA_KETTLE_BREWING, TEA_KETTLE_BREWING_WORKSTATION);
        registry.addWorkstation(CHEESE_FORMING, CHEESE_FORMING_WORKSTATION);
        registry.addWorkstation(COOKING_CAULDRON, COOKING_CAULDRON_WORKSTATION);
        registry.addWorkstation(FONDUE, FONDUE_WORKSTATION);
        registry.addWorkstation(WOODCUTTING, WOODCUTTING_WORKSTATION);

        RecipeManager manager = registry.getRecipeManager();

        // Use vanilla's concept of your recipes and pass them to your EmiRecipe representation
        for (net.satisfy.vinery.recipe.FermentationBarrelRecipe recipe : manager.getAllRecipesFor(RecipeTypesRegistry.FERMENTATION_BARREL_RECIPE_TYPE.get())) {
            registry.addRecipe(new FermentationRecipe(recipe));
        }
        for (net.satisfy.vinery.recipe.ApplePressRecipe recipe : manager.getAllRecipesFor(RecipeTypesRegistry.APPLE_PRESS_RECIPE_TYPE.get())) {
            registry.addRecipe(new ApplePressingRecipe(recipe));
        }

        for (net.satisfy.bakery.recipe.BakingStationRecipe recipe : manager.getAllRecipesFor(net.satisfy.bakery.registry.RecipeTypeRegistry.BAKING_STATION_RECIPE_TYPE.get())) {
            registry.addRecipe(new BakingStationRecipe(recipe));
        }
        for (net.satisfy.bakery.recipe.CraftingBowlRecipe recipe : manager.getAllRecipesFor(net.satisfy.bakery.registry.RecipeTypeRegistry.CRAFTING_BOWL_RECIPE_TYPE.get())) {
            registry.addRecipe(new CraftingBowlRecipe(recipe));
        }
        for (net.satisfy.bakery.recipe.StoveRecipe recipe : manager.getAllRecipesFor(net.satisfy.bakery.registry.RecipeTypeRegistry.STOVE_RECIPE_TYPE.get())) {
            registry.addRecipe(new StoveRecipe(recipe));
        }
        for (net.satisfy.bakery.recipe.CookingPotRecipe recipe : manager.getAllRecipesFor(net.satisfy.bakery.registry.RecipeTypeRegistry.COOKING_POT_RECIPE_TYPE.get())) {
            registry.addRecipe(new PotCookingRecipe(recipe));
        }

        for (satisfy.beachparty.recipe.MiniFridgeRecipe recipe : manager.getAllRecipesFor(RecipeRegistry.MINI_FRIDGE_RECIPE_TYPE.get())) {
            registry.addRecipe(new MiniFridgeMixingRecipe(recipe));
        }
        for (satisfy.beachparty.recipe.TikiBarRecipe recipe : manager.getAllRecipesFor(RecipeRegistry.TIKI_BAR_RECIPE_TYPE.get())) {
            registry.addRecipe(new TikiBarMixingRecipe(recipe));
        }

        for (net.satisfy.brewery.recipe.BrewingRecipe recipe : manager.getAllRecipesFor(RecipeTypeRegistry.BREWING_RECIPE_TYPE.get())) {
            registry.addRecipe(new BrewingRecipe(recipe));
        }
        for (net.satisfy.brewery.recipe.SiloRecipe recipe : manager.getAllRecipesFor(RecipeTypeRegistry.SILO_RECIPE_TYPE.get())) {
            registry.addRecipe(new DryingRecipe(recipe));
        }

        for (net.satisfy.candlelight.recipe.CookingPanRecipe recipe : manager.getAllRecipesFor(net.satisfy.candlelight.registry.RecipeTypeRegistry.COOKING_PAN_RECIPE_TYPE.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.candlelight.PanCookingRecipe(recipe));
        }
        for (net.satisfy.candlelight.recipe.CookingPotRecipe recipe : manager.getAllRecipesFor(net.satisfy.candlelight.registry.RecipeTypeRegistry.COOKING_POT_RECIPE_TYPE.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.candlelight.PotCookingRecipe(recipe));
        }

        for (satisfy.herbalbrews.recipe.CauldronRecipe recipe : manager.getAllRecipesFor(satisfy.herbalbrews.registry.RecipeTypeRegistry.CAULDRON_RECIPE_TYPE.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.herbalbrews.CauldronBrewingRecipe(recipe));
        }
        for (satisfy.herbalbrews.recipe.TeaKettleRecipe recipe : manager.getAllRecipesFor(satisfy.herbalbrews.registry.RecipeTypeRegistry.TEA_KETTLE_RECIPE_TYPE.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.herbalbrews.TeaKettleBrewingRecipe(recipe));
        }

        for (net.satisfy.meadow.recipes.CheeseFormRecipe recipe : manager.getAllRecipesFor(net.satisfy.meadow.registry.RecipeRegistry.CHEESE.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.meadow.CheeseFormRecipe(recipe));
        }
        for (net.satisfy.meadow.recipes.CookingCauldronRecipe recipe : manager.getAllRecipesFor(net.satisfy.meadow.registry.RecipeRegistry.COOKING.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.meadow.CookingCauldronRecipe(recipe));
        }
        for (net.satisfy.meadow.recipes.FondueRecipe recipe : manager.getAllRecipesFor(net.satisfy.meadow.registry.RecipeRegistry.FONDUE.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.meadow.FondueRecipe(recipe));
        }
        for (net.satisfy.meadow.recipes.WoodcuttingRecipe recipe : manager.getAllRecipesFor(net.satisfy.meadow.registry.RecipeRegistry.WOODCUTTING.get())) {
            registry.addRecipe(new com.pandaismyname1.emiletsdocompat.meadow.WoodcuttingRecipe(recipe));
        }
    }
}
