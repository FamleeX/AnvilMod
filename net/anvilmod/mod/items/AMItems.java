package net.anvilmod.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.anvilmod.mod.AnvilMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class AMItems extends Item {
	
	public AMItems() {
		this.setCreativeTab(AnvilMod.anvilModTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(AnvilMod.modid + ":" + getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
	}
	
    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
       return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
