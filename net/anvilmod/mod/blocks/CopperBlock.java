package net.anvilmod.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.anvilmod.mod.AnvilMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class CopperBlock extends Block {

	public CopperBlock(Material material) {
		super(material);
		this.setBlockName("CopperBlock");
		this.setBlockTextureName(AnvilMod.modid + ":" + "CopperBlock");
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(AnvilMod.anvilModTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcon(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AnvilMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
