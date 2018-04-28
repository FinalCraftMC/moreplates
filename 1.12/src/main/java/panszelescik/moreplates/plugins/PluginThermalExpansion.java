package panszelescik.moreplates.plugins;

import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.util.managers.machine.CompactorManager;
import cofh.thermalexpansion.util.managers.machine.CompactorManager.Mode;
import panszelescik.moreplates.helpers.Helper;

import static panszelescik.moreplates.ModChecker.*;
import static panszelescik.moreplates.config.Config.*;
import static panszelescik.moreplates.helpers.Strings.*;

public class PluginThermalExpansion {
	
	private static int energy = energyCompactor;

	public static void postInit() {
		if (isAppliedEnergisticsLoaded & loadAppliedEnergistics2) {
			String id = "appliedenergistics2";	
			add(CERTUS_QUARTZ, CRYSTAL + CERTUS_QUARTZ);
			add(CERTUS_QUARTZ, PURE_CERTUS_QUARTZ_NAME, id, PURE_CERTUS_QUARTZ_META);
			add(FLUIX, CRYSTAL + FLUIX);
			add(FLUIX, CRYSTAL + PURE_FLUIX);
		}
		if (isBotaniaLoaded & loadBotania) {
			addGaia(GAIA_SPIRIT, GAIA_SPIRIT + "Ingot");
		}
		if (isCalculatorLoaded & loadCalculator) {
			String id = "calculator";
			add(REDSTONE, REDSTONE_NAME, id);
			add(REINFORCED_IRON, REINFORCED_IRON_NAME, id);
		}
		if (isExtraUtilitiesLoaded & loadExtraUtilities) {
			String id = "extrautils2";
			add(DEMON, EXU2_NAME, id, DEMON_META);
			add(ENCHANTED, EXU2_NAME, id, ENCHANTED_META);
			add(EVIL_INFUSED_IRON, EXU2_NAME, id, EVIL_INFUSED_IRON_META);
		}
		if (isProjectELoaded & loadProjectE) {
			String id = "projecte";
			add(DARK_MATTER, DARK_MATTER_NAME, id, DARK_MATTER_META);
			add(RED_MATTER, RED_MATTER_NAME, id, RED_MATTER_META);
		}
		if (isRefinedStorageLoaded & loadRefinedStorage) {
			String id = "refinedstorage";
			add(QUARTZ_ENRICHED_IRON, QUARTZ_ENRICHED_IRON_NAME, id);
		}
		if (ItemHelper.oreNameExists(ITEM + SILICON)) {
			add(SILICON, ITEM + SILICON);
		}
	}
	private static void add(String output, String input) {
		CompactorManager.addRecipe(energy, ItemHelper.getOre(input, 4), ItemHelper.getOre(GEAR + output), Mode.GEAR);
		CompactorManager.addRecipe(energy, ItemHelper.getOre(input), ItemHelper.getOre(PLATE + output), Mode.PLATE);
	}
	private static void add(String output, String input, String id) {
		CompactorManager.addRecipe(energy, Helper.getItemStack(id, input, 4), ItemHelper.getOre(GEAR + output), Mode.GEAR);
		CompactorManager.addRecipe(energy, Helper.getItemStack(id, input), ItemHelper.getOre(PLATE + output), Mode.PLATE);
	}
	private static void add(String output, String input, String id, int meta) {
		CompactorManager.addRecipe(energy, Helper.getItemStack(id, input, 4, meta), ItemHelper.getOre(GEAR + output), Mode.GEAR);
		CompactorManager.addRecipe(energy, Helper.getItemStack(id, input, 1, meta), ItemHelper.getOre(PLATE + output), Mode.PLATE);
	}
	private static void addGaia(String output, String input) {
		CompactorManager.addRecipe(energy, ItemHelper.getOre(input, 4), ItemHelper.getOre(output + "Gear"), Mode.GEAR);
		CompactorManager.addRecipe(energy, ItemHelper.getOre(input), ItemHelper.getOre(output + "Plate"), Mode.PLATE);
	}
}