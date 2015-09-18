package net.anvilmod.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class AnvilRecipeSorter implements Comparator  {
	
	final AnvilCraftingManager anvil;
	
	public AnvilRecipeSorter(AnvilCraftingManager anvilCraftingManager) {
		this.anvil = anvilCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof AnvilShapelessRecipes && irecipe2 instanceof AnvilShapedRecipes ? 1: (irecipe2 instanceof AnvilShapelessRecipes && irecipe1 instanceof AnvilShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
