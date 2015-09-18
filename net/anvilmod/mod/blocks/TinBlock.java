package net.anvilmod.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.anvilmod.mod.AnvilMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class TinBlock extends Block {

	public TinBlock(Material material) {
		super(material);
		this.setBlockName("TinBlock");
		this.setBlockTextureName(AnvilMod.modid + ":" + "TinBlock");
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(AnvilMod.anvilModTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcon(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AnvilMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
