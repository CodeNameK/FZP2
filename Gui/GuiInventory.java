package FizzyClubMods.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FizzyClubMods.Gui.Con.InventoryContainer;
import FizzyClubMods.Gui.Inv.MinelifeInv;

public class GuiInventory extends GuiContainer
{
  private float xSize_lo;
  private float ySize_lo;

  public GuiInventory(EntityPlayer entity, MinelifeInv inv)
  {
    super(new InventoryContainer(entity, inv));
  }

  public void drawScreen(int par1, int par2, float par3) {
    super.drawScreen(par1, par2, par3);
    this.xSize_lo = par1;
    this.ySize_lo = par2;
  }

  protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.renderEngine.bindTexture(new ResourceLocation("minelife:textures/gui/cosplayinv.png"));
    int var4 = this.height;
    int var5 = this.width;
    int var6 = (this.width - this.xSize) / 2;
    int var7 = (this.height - this.ySize) / 2;
    drawTexturedModalRect(var6, var7, 0, 0, 256, 256);
    renderPlayerinInv(this.mc, var6 + 45, var7 + 70, 30, var6 + 51 - this.xSize_lo, var7 + 75 - 50 - this.ySize_lo);
  }

  public static void renderPlayerinInv(Minecraft var0, int var1, int var2, int var3, float var4, float var5) {
    GL11.glEnable(2903);
    GL11.glPushMatrix();
    GL11.glTranslatef(var1, var2, 50.0F);
    GL11.glScalef(-var3, var3, var3);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    float var6 = var0.thePlayer.renderYawOffset;
    float var7 = var0.thePlayer.rotationYaw;
    float var8 = var0.thePlayer.rotationPitch;
    GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
    RenderHelper.enableStandardItemLighting();
    GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(-(float)Math.atan(var5 / 40.0F) * 20.0F, 1.0F, 0.0F, 0.0F);
    var0.thePlayer.renderYawOffset = ((float)Math.atan(var4 / 40.0F) * 20.0F);
    var0.thePlayer.rotationYaw = ((float)Math.atan(var4 / 40.0F) * 40.0F);
    var0.thePlayer.rotationPitch = (-(float)Math.atan(var5 / 40.0F) * 20.0F);
    var0.thePlayer.rotationYawHead = var0.thePlayer.rotationYaw;
    GL11.glTranslatef(0.0F, var0.thePlayer.yOffset, 0.0F);
    RenderManager.instance.playerViewY = 180.0F;
    RenderManager.instance.renderEntityWithPosYaw(var0.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
    var0.thePlayer.renderYawOffset = var6;
    var0.thePlayer.rotationYaw = var7;
    var0.thePlayer.rotationPitch = var8;
    GL11.glPopMatrix();
    RenderHelper.disableStandardItemLighting();
    GL11.glDisable(32826);
    OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
    GL11.glDisable(3553);
    OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
  }

  public void initGui() {
    super.initGui();
    this.buttonList.clear();
  }

  public boolean doesGuiPauseGame() {
    return false;
  }

  public void actionPerformed(GuiButton var1)
  {
  }
}