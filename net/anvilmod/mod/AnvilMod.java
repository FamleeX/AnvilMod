package net.anvilmod.mod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.anvilmod.mod.blocks.Anvil;
import net.anvilmod.mod.blocks.CopperBlock;
import net.anvilmod.mod.blocks.CopperOre;
import net.anvilmod.mod.blocks.Forge;
import net.anvilmod.mod.blocks.OreBlock;
import net.anvilmod.mod.blocks.TinBlock;
import net.anvilmod.mod.blocks.TinOre;
import net.anvilmod.mod.crafting.RecipeRemover;
import net.anvilmod.mod.handler.FuelHandler;
import net.anvilmod.mod.handler.GuiHandler;
import net.anvilmod.mod.items.AMItems;
import net.anvilmod.mod.tileentity.TileEntityForge;
import net.anvilmod.mod.worldgen.AnvilModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nealecraft.mod.blocks.WorkSurface;

@Mod(modid=AnvilMod.modid, name=AnvilMod.modname, version=AnvilMod.version)
public class AnvilMod {
	
	public static final String modid = "anvilmod";
	public static final String modname = "Anvil Mod";
	public static final String version = "Alpha v0.1";
	
	AnvilModWorldGen eventWorldGen = new AnvilModWorldGen();
	
	public static CreativeTabs anvilModTab;
	
	@Instance(modid)
	public static AnvilMod instance;
	
	public static Item itemToolRod;
	
	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	
	public static Block oreCopperOre;
	public static Block oreTinOre;
	
	public static Block blockCopperBlock;
	public static Block blockTinBlock;
	
	public static Block blockAnvil;
	public static final int guiIDAnvil = 1;
	
	public static Block blockForgeIdle;
	public static Block blockForgeActive;
	public static Block blockAlloyForgeIdle;
	public static Block blockAlloyForgeActive;
	public static final int guiIDForge = 0;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {
		
		anvilModTab = new CreativeTabs("anvilmod") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(AnvilMod.oreCopperOre);
			}
		};
		
		//Items
		itemToolRod = new AMItems().setUnlocalizedName("Tool Rod");
		
		//Ingots
		itemCopperIngot = new AMItems().setUnlocalizedName("CopperIngot");
		itemTinIngot = new AMItems().setUnlocalizedName("TinIngot");
		
		//Ores
		oreCopperOre = new CopperOre(Material.rock);
		oreTinOre = new TinOre(Material.rock);
		
		//Blocks
		blockCopperBlock = new CopperBlock(Material.iron);
		blockTinBlock = new TinBlock(Material.iron);
		
		//Machines
		blockAnvil = new Anvil();
		
		blockForgeIdle = new Forge(false).setBlockName("ForgeIdle").setCreativeTab(anvilModTab);
		blockForgeActive = new Forge(true).setBlockName("ForgeActive").setLightLevel(0.625F);

		
		//Registers
		
		//Ingots
		GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
		GameRegistry.registerItem(itemTinIngot, "TinIngot");
		
		//Ores
		GameRegistry.registerBlock(oreCopperOre, "CopperOre");
		GameRegistry.registerBlock(oreTinOre, "TinOre");
		
		//Blocks
		GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
		GameRegistry.registerBlock(blockTinBlock, "TinBlock");
		
		//Machines
		GameRegistry.registerBlock(blockAnvil, "Anvil");
		
		GameRegistry.registerBlock(blockForgeIdle, "ForgeIdle");
		GameRegistry.registerBlock(blockForgeActive, "ForgeActive");
		
		//Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		GameRegistry.registerTileEntity(TileEntityForge.class, "Forge");
		
		//Recipes
		RecipeRemover.removeRecipe();
		
		//GameRegistry.addRecipe(new ItemStack(itemToolRod, 2), new Object[]{"   ", " I ", " I "});
		
		GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', itemCopperIngot});
		GameRegistry.addRecipe(new ItemStack(blockTinBlock), new Object[]{"TTT", "TTT", "TTT", 'T', itemTinIngot});
		
		
		
		//Smelting
		GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0.7F);
		GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0.7F);
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}