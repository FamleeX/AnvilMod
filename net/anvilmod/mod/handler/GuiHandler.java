package net.anvilmod.mod.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.anvilmod.mod.AnvilMod;
import net.anvilmod.mod.container.ContainerAnvil;
import net.anvilmod.mod.container.ContainerForge;
import net.anvilmod.mod.gui.GuiAnvil;
import net.anvilmod.mod.gui.GuiForge;
import net.anvilmod.mod.tileentity.TileEntityForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case AnvilMod.guiIDForge:
				if (entity instanceof TileEntityForge) {
					return new ContainerForge(player.inventory, (TileEntityForge) entity);
				}
				return null;

			}

			if(ID == AnvilMod.guiIDAnvil) {
				return ID == AnvilMod.guiIDAnvil && world.getBlock(x, y, z) == AnvilMod.blockAnvil ? new ContainerAnvil(player.inventory, world, x, y, z) : null;
			}
		}
		return null;

	}


	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case AnvilMod.guiIDForge:
				if (entity instanceof TileEntityForge) {
					return new GuiForge(player.inventory, (TileEntityForge) entity);
				}
				return null;
			}


			if(ID == AnvilMod.guiIDAnvil) {
				return ID == AnvilMod.guiIDAnvil && world.getBlock(x, y, z) == AnvilMod.blockAnvil ? new GuiAnvil(player.inventory, world, x, y, z) : null;
			}
		}
		return null;
	}
}