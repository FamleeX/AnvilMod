package net.anvilmod.mod.handler;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if (fuel.getItem() == Items.coal) return 1600;
		
		
		return 0;
	}
	
	
	
}
