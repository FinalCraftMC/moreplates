package panszelescik.moreplates.plugins.helpers;

import panszelescik.moreplates.MorePlates;
import panszelescik.moreplates.config.Config;
import techreborn.api.recipe.Recipes;

import static panszelescik.moreplates.plugins.core.ItemInfo.Type.*;

public class TechRebornHelper extends PluginHelper {

    public static int CompressorRecipes = 0;

    public static void add(String output, String input, boolean plate) {
        if (oreNameExists(input) && plate && oreNameExists(PLATE + output)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + output) + " from: " + getItemName(input));
            Recipes.compressor.createRecipe().withInput(input).withOutput(get(PLATE + output)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    public static void add(String output, String input) {
        if (oreNameExists(input) && oreNameExists(PLATE + output)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + output) + " from: " + getItemName(input));
            Recipes.compressor.createRecipe().withInput(input).withOutput(get(PLATE + output)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    public static void add(String output, String input, String id, int meta) {
        if (notNull(id, input, meta)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + output) + " from: " + getItemName(id, input, 1, meta));
            Recipes.compressor.createRecipe().withInput(get(id, input, 1, meta)).withOutput(get(PLATE + output)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    public static void addBlock(String name, int amount, boolean plate) {
        if (oreNameExists(BLOCK + name) && plate && oreNameExists(PLATE + name)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + name) + " x" + amount + " from: " + getItemName(BLOCK + name));
            Recipes.compressor.createRecipe().withInput(BLOCK + name).withOutput(get(PLATE + name, amount)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    public static void addBlock(String name, int amount) {
        if (oreNameExists(BLOCK + name) && oreNameExists(PLATE + name)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + name) + " x" + amount + " from: " + getItemName(BLOCK + name));
            Recipes.compressor.createRecipe().withInput(BLOCK + name).withOutput(get(PLATE + name, amount)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    public static void addBlock(String output, String input, int amount, String id) {
        if (notNull(id, input) && oreNameExists(PLATE + output)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + output) + " x" + amount + " from: " + getItemName(id, input));
            Recipes.compressor.createRecipe().withInput(get(id, input)).withOutput(get(PLATE + output, amount)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    public static void addBlock(String output, String input, int amount, String id, int meta) {
        if (notNull(id, input, meta) && oreNameExists(PLATE + output)) {
            MorePlates.logger.debug("Adding Compressor recipe for: " + getItemName(PLATE + output) + " x" + amount + " from: " + getItemName(id, input, 1, meta));
            Recipes.compressor.createRecipe().withInput(get(id, input, 1, meta)).withOutput(get(PLATE + output, amount)).withEnergyCostPerTick(energyCompressor()).withOperationDuration(timeCompressor()).register();

            CompressorRecipes += 1;
        }
    }

    private static int energyCompressor() {
        return MorePlates.config.getInt("Energy in Compressor", Config.CATEGORY_TECHREBORN, 4, "Energy used to make some Plates in Compressor (in EU/t)");
    }

    private static int timeCompressor() {
        return MorePlates.config.getInt("Time in Compressor", Config.CATEGORY_TECHREBORN, 300, "Time in ticks to craft some Plates in Compressor");
    }
}