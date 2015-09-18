package net.anvilmod.mod.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.anvilmod.mod.AnvilMod;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AnvilCraftingManager {
    /** The static instance of this class */
    private static final AnvilCraftingManager instance = new AnvilCraftingManager();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";

    /**
     * Returns the static instance of this class
     */
    public static final AnvilCraftingManager getInstance() {
        return instance;
    }

    private AnvilCraftingManager() {
        recipes = new ArrayList();
        
        this.addRecipe(new ItemStack(AnvilMod.itemToolRod), new Object[]{"I", "I", 'I', Items.iron_ingot});
        
        this.addRecipe(new ItemStack(Items.iron_pickaxe, 1), new Object[]{"III", " T ", " T ", 'I', Items.iron_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.iron_axe, 1), new Object[]{" II", " TI", " T ", 'I', Items.iron_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.iron_hoe, 1), new Object[]{" II", " T ", " T ", 'I', Items.iron_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.iron_sword, 1), new Object[]{" I ", " I ", " T ", 'I', Items.iron_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.iron_shovel, 1), new Object[]{" I ", " T ", " T ", 'I', Items.iron_ingot, 'T', AnvilMod.itemToolRod});
        
        this.addRecipe(new ItemStack(Items.golden_pickaxe, 1), new Object[]{"III", " T ", " T ", 'I', Items.gold_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.golden_axe, 1), new Object[]{" II", " TI", " T ", 'I', Items.gold_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.golden_hoe, 1), new Object[]{" II", " T ", " T ", 'I', Items.gold_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.golden_sword, 1), new Object[]{" I ", " I ", " T ", 'I', Items.gold_ingot, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.golden_shovel, 1), new Object[]{" I ", " T ", " T ", 'I', Items.gold_ingot, 'T', AnvilMod.itemToolRod});
        
        this.addRecipe(new ItemStack(Items.diamond_pickaxe, 1), new Object[]{"III", " T ", " T ", 'I', Items.diamond, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.diamond_axe, 1), new Object[]{" II", " TI", " T ", 'I', Items.diamond, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.diamond_hoe, 1), new Object[]{" II", " T ", " T ", 'I', Items.diamond, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.diamond_sword, 1), new Object[]{" I ", " I ", " T ", 'I', Items.diamond, 'T', AnvilMod.itemToolRod});
        this.addRecipe(new ItemStack(Items.diamond_shovel, 1), new Object[]{" I ", " T ", " T ", 'I', Items.diamond, 'T', AnvilMod.itemToolRod});
    	
    	Collections.sort(this.recipes, new AnvilRecipeSorter(this){});
    }

    AnvilShapedRecipes addRecipe(ItemStack p_92103_1_, Object ... p_92103_2_) {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (p_92103_2_[var4] instanceof String[]) {
            String[] var7 = (String[])((String[])p_92103_2_[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8) {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else {
            while (p_92103_2_[var4] instanceof String) {
                String var11 = (String)p_92103_2_[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < p_92103_2_.length; var4 += 2) {
            Character var13 = (Character)p_92103_2_[var4];
            ItemStack var15 = null;

            if (p_92103_2_[var4 + 1] instanceof Item) {
                var15 = new ItemStack((Item)p_92103_2_[var4 + 1]);
            }
            else if (p_92103_2_[var4 + 1] instanceof Block) {
                var15 = new ItemStack((Block)p_92103_2_[var4 + 1], 1, 32767);
            }
            else if (p_92103_2_[var4 + 1] instanceof ItemStack) {
                var15 = (ItemStack)p_92103_2_[var4 + 1];
            }

            var12.put(var13, var15);
        }

        ItemStack[] var14 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16) {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10))) {
                var14[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
            }
            else {
                var14[var16] = null;
            }
        }

        AnvilShapedRecipes var17 = new AnvilShapedRecipes(var5, var6, var14, p_92103_1_);
        this.recipes.add(var17);
        return var17;
    }

    void addShapelessRecipe(ItemStack p_77596_1_, Object ... p_77596_2_) {
        ArrayList var3 = new ArrayList();
        Object[] var4 = p_77596_2_;
        int var5 = p_77596_2_.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];

            if (var7 instanceof ItemStack) {
                var3.add(((ItemStack)var7).copy());
            }
            else if (var7 instanceof Item) {
                var3.add(new ItemStack((Item)var7));
            }
            else {
                if (!(var7 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.recipes.add(new AnvilShapelessRecipes(p_77596_1_, var3));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting p_82787_1_, World p_82787_2_) {
        int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;

        for (var6 = 0; var6 < p_82787_1_.getSizeInventory(); ++var6) {
            ItemStack var7 = p_82787_1_.getStackInSlot(var6);

            if (var7 != null) {
                if (var3 == 0) {
                    var4 = var7;
                }

                if (var3 == 1) {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.getItem() == var5.getItem() && var4.stackSize == 1 && var5.stackSize == 1 && var4.getItem().isDamageable()) {
            Item var11 = var4.getItem();
            int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
            int var10 = var11.getMaxDamage() - var9;

            if (var10 < 0)
            {
                var10 = 0;
            }

            return new ItemStack(var4.getItem(), 1, var10);
        }
        else {
            for (var6 = 0; var6 < this.recipes.size(); ++var6) {
                IRecipe var12 = (IRecipe)this.recipes.get(var6);

                if (var12.matches(p_82787_1_, p_82787_2_)) {
                    return var12.getCraftingResult(p_82787_1_);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList() {
        return this.recipes;
    }
}
