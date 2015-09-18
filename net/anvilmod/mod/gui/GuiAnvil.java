package net.anvilmod.mod.gui;

import org.lwjgl.opengl.GL11;

import net.anvilmod.mod.AnvilMod;
import net.anvilmod.mod.container.ContainerAnvil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiAnvil extends GuiContainer {
	
	private ResourceLocation bground = new ResourceLocation(AnvilMod.modid + ":" + "textures/gui/GuiAnvil.png");
	
	public GuiAnvil(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerAnvil(invPlayer, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 166;
		
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Anvil"), 100, 5, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bground);
        int var4 = (this.width - this.xSize) / 2;
        int var5 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.ySize);
		
	}

}
