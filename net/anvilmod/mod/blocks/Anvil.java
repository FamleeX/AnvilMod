package net.anvilmod.mod.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.anvilmod.mod.AnvilMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Anvil extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon anvilTop;
	
	public Anvil() {
		super(Material.anvil);
		this.setBlockName("Anvil");
		this.setHardness(5.0F);
		this.setResistance(2000.0F);
		this.setCreativeTab(AnvilMod.anvilModTab);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		return side == 1 ? this.anvilTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AnvilMod.modid + ":" + "AnvilSide");
		this.anvilTop = iconRegister.registerIcon(AnvilMod.modid + ":" + "AnvilTop");
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        /*if (world.isRemote) {
            return true;
        } else {
            player.openGui(AnvilMod.instance, AnvilMod.guiIDAnvil, world, x, y, z);
            return true;
        }*/
    	
    	if (!world.isRemote) {
    		FMLNetworkHandler.openGui(player, AnvilMod.instance, AnvilMod.guiIDAnvil, world, x, y, z);
    	}
    	return true;
    }
	

}