package net.anvilmod.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.anvilmod.mod.AnvilMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class OreBlock extends Block {

	public OreBlock(Material material, String oreName) {
		super(material);
		this.setBlockName(oreName);
		this.setBlockTextureName(AnvilMod.modid + ":" + oreName);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(AnvilMod.anvilModTab);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcon(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AnvilMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
