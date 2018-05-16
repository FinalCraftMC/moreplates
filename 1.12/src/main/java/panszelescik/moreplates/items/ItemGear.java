package panszelescik.moreplates.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import panszelescik.moreplates.Reference;

import static panszelescik.moreplates.helpers.Strings.*;

public class ItemGear extends Item {
	
	public ItemGear(String name) {
		name += "_gear";
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(Reference.MODID, name));
	}
}