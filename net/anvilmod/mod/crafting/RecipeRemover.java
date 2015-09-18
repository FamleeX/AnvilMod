package net.anvilmod.mod.crafting;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {
	
	public static void removeRecipe() {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
		while (remover.hasNext()) {
			ItemStack itemstack = remover.next().getRecipeOutput();
			if (itemstack != null && itemstack.getItem() == Items.iron_pickaxe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.iron_axe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.iron_hoe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.iron_shovel)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.iron_sword)
				remover.remove();
			
			else if (itemstack != null && itemstack.getItem() == Items.golden_pickaxe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.golden_axe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.golden_hoe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.golden_shovel)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.golden_sword)
				remover.remove();
			
			else if (itemstack != null && itemstack.getItem() == Items.diamond_pickaxe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.diamond_axe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.diamond_hoe)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.diamond_shovel)
				remover.remove();
			else if (itemstack != null && itemstack.getItem() == Items.diamond_sword)
				remover.remove();
		}
	}
	
}
