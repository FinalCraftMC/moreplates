package panszelescik.moreplates.plugins;

import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import cofh.core.util.helpers.ItemHelper;
import net.minecraft.item.ItemStack;
import panszelescik.moreplates.MorePlates;
import panszelescik.moreplates.helpers.Helper;

import static panszelescik.moreplates.ModChecker.*;
import static panszelescik.moreplates.config.Config.*;
import static panszelescik.moreplates.helpers.Strings.*;

public class PluginImmersiveEngineering {
	
	private static int energy = energyMetalPress;

	private static ItemStack mold_gear = Helper.getItemStack(IMMERSIVE_MODID, "mold", 1, 1);
	private static ItemStack mold_plate = Helper.getItemStack(IMMERSIVE_MODID, "mold", 1, 0);
	
	public static void postInit() {
		if (isAppliedEnergisticsLoaded & loadAppliedEnergistics2) {	
			String id = AE2_MODID;
			add(CERTUS_QUARTZ, CRYSTAL + CERTUS_QUARTZ);
			add(CERTUS_QUARTZ, PURE_CERTUS_QUARTZ_NAME, id, PURE_CERTUS_QUARTZ_META);
			add(FLUIX, CRYSTAL + FLUIX);
			add(FLUIX, CRYSTAL + PURE_FLUIX);
		}
		if (isBotaniaLoaded & loadBotania) {
			add(ELEMENTIUM, INGOT + ELEMENTIUM);
			addGaia(GAIA_SPIRIT, GAIA_SPIRIT + "Ingot");
			add(MANASTEEL, INGOT + MANASTEEL);
			add(TERRASTEEL, INGOT + TERRASTEEL);
		}
		if (isCalculatorLoaded & loadCalculator) {
			String id = CALCULATOR_MODID;
			add(AMETHYST, GEM + AMETHYST);
			add(ENRICHED_GOLD, INGOT + ENRICHED_GOLD);
			add(REDSTONE, REDSTONE_NAME, id);
			add(REINFORCED_IRON, REINFORCED_IRON_NAME, id);
			add(TANZANITE, GEM + TANZANITE);
		}
		if (isDraconicEvolutionLoaded & loadDraconicEvolution) {
			add(AWAKENED_DRACONIUM, INGOT + AWAKENED_DRACONIUM);
			add(DRACONIUM, INGOT + DRACONIUM);
		}
		if (isEnderIOLoaded & loadEnderIO) {
			add(CONDUCTIVE_IRON, INGOT + CONDUCTIVE_IRON);
			add(DARK_STEEL, INGOT + DARK_STEEL);
			add(ELECTRICAL_STEEL, INGOT + ELECTRICAL_STEEL);
			add(END_STEEL, INGOT + END_STEEL);
			add(ENERGETIC_ALLOY, INGOT + ENERGETIC_ALLOY);
			add(PULSATING_IRON, INGOT + PULSATING_IRON);
			add(REDSTONE_ALLOY, INGOT + REDSTONE_ALLOY);
			add(SOULARIUM, INGOT + SOULARIUM);
			add(VIBRANT_ALLOY, INGOT + VIBRANT_ALLOY);
		}
		if (isExtraUtilitiesLoaded & loadExtraUtilities) {
			String id = EXTRA_UTILITIES_MODID;
			add(DEMON, EXU2_NAME, id, DEMON_META);
			add(ENCHANTED, EXU2_NAME, id, ENCHANTED_META);
			add(EVIL_INFUSED_IRON, EXU2_NAME, id, EVIL_INFUSED_IRON_META);
		}
		if (isMekanismLoaded & loadMekanism) {
			add(GLOWSTONE, INGOT + GLOWSTONE);
			add(OSMIUM, INGOT + OSMIUM);
			add(REFINED_OBSIDIAN, INGOT + REFINED_OBSIDIAN);
		}
		if (isMysticalAgradditionsLoaded & loadMysticalAgradditions) {
			add(INSANIUM, INGOT + INSANIUM);
		}
		if (isMysticalAgricultureLoaded & loadMysticalAgriculture) {
			add(INFERIUM, INGOT + INFERIUM);
			add(INTERMEDIUM, INGOT + INTERMEDIUM);
			add(PRUDENTIUM, INGOT + PRUDENTIUM);
			add(SOULIUM, INGOT + SOULIUM);
			add(SUPERIUM, INGOT + SUPERIUM);
			add(SUPREMIUM, INGOT + SUPREMIUM);
		}
		if (isProjectELoaded & loadProjectE) {
			String id = PROJECTE_MODID;
			add(DARK_MATTER, DARK_MATTER_NAME, id, DARK_MATTER_META);
			add(RED_MATTER, RED_MATTER_NAME, id, RED_MATTER_META);
		}
		if (isProjectRedLoaded & loadProjectRed) {
			add(ELECTROTINE, INGOT + ELECTROTINE);
			add(RED_ALLOY, INGOT + RED_ALLOY);
		}
		if (isRefinedStorageLoaded & loadRefinedStorage) {
			String id = REFINED_STORAGE_MODID;
			add(QUARTZ_ENRICHED_IRON, QUARTZ_ENRICHED_IRON_NAME, id);
		}
		if (isTinkersConstructLoaded & loadTinkersConstruct) {
			add(ARDITE, INGOT + ARDITE);
			add(COBALT, INGOT + COBALT);
			add(KNIGHTSLIME, INGOT + KNIGHTSLIME);
			add(MANYULLYN, INGOT + MANYULLYN);
			add(PIG_IRON, INGOT + PIG_IRON);
		}
		if (ItemHelper.oreNameExists(ITEM + SILICON)) {
			add(SILICON, ITEM + SILICON);
		}
	}
	private static void add(String output, String input) {
		MetalPressRecipe.addRecipe(ItemHelper.getOre(GEAR + output), ItemHelper.getOre(input, 4), mold_gear, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(GEAR + output)) + INFO_3 + Helper.getItemName(ItemHelper.getOre(input)) + " x4");
		MetalPressRecipe.addRecipe(ItemHelper.getOre(PLATE + output), input, mold_plate, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(PLATE + output)) + INFO_3 + Helper.getItemName(ItemHelper.getOre(input)));
	}
	private static void add(String output, String input, String id) {
		MetalPressRecipe.addRecipe(ItemHelper.getOre(GEAR + output), Helper.getItemStack(id, input, 4), mold_gear, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(GEAR + output)) + INFO_3 + Helper.getItemName(Helper.getItemStack(id, input)) + " x4");
		MetalPressRecipe.addRecipe(ItemHelper.getOre(PLATE + output), Helper.getItemStack(id, input), mold_plate, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(PLATE + output)) + INFO_3 + Helper.getItemName(Helper.getItemStack(id, input)));
	}
	private static void add(String output, String input, String id, int meta) {
		MetalPressRecipe.addRecipe(ItemHelper.getOre(GEAR + output), Helper.getItemStack(id, input, 4, meta), mold_gear, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(GEAR + output)) + INFO_3 + Helper.getItemName(Helper.getItemStack(id, input, 1, meta)) + " x4");
		MetalPressRecipe.addRecipe(ItemHelper.getOre(PLATE + output), Helper.getItemStack(id, input, 1, meta), mold_plate, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(PLATE + output)) + INFO_3 + Helper.getItemName(Helper.getItemStack(id, input, 1, meta)));
	}
	//Special for Gaia Spirit Gear and Plate
	private static void addGaia(String output, String input) {
		MetalPressRecipe.addRecipe(ItemHelper.getOre(output + "Gear"), ItemHelper.getOre(input, 4), mold_gear, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(output + "Gear")) + INFO_3 + Helper.getItemName(ItemHelper.getOre(input)) + " x4");
		MetalPressRecipe.addRecipe(ItemHelper.getOre(output + "Plate"), input, mold_plate, energy);
		MorePlates.logger.debug(INFO_IE + Helper.getItemName(ItemHelper.getOre(output + "Plate")) + INFO_3 + Helper.getItemName(ItemHelper.getOre(input)));
	}
}