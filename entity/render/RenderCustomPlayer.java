package FizzyClubMods.entity.render;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FizzyClubMods.Armor.Model.BuffModel;
import FizzyClubMods.Armor.Model.Wing1Model;
import FizzyClubMods.Gui.Funtion.INVFunction;
import FizzyClubMods.Gui.Inv.MinelifeInv;
import FizzyClubMods.Items.FizzyclubArmor;

public class RenderCustomPlayer extends RenderPlayer {
	
	
	public static Map defaultPlayerRender = new HashMap();
	private ModelBiped f;
	public static RenderCustomPlayer instance;
	private Minecraft mc;
	MinelifeInv inv;
	
	
	public ItemStack backpackstack;
	public ItemStack Buffstack;
	
	public Wing1Model wing1;
	public BuffModel Buff ;

	public RenderCustomPlayer(ModelBase modelbase) {
		instance = this;
		this.f = ((ModelBiped) this.mainModel);
		this.mc = Minecraft.getMinecraft();
		this.wing1 = new Wing1Model();
		this.Buff = new BuffModel();
	}

	protected void renderSpecials(
			AbstractClientPlayer par1AbstractClientPlayer, float par2) {
		Render(par1AbstractClientPlayer, par2);
	}

	protected void Render(EntityPlayer entityplayer, float var2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		
		this.f.heldItemLeft = 0;
		this.inv = INVFunction.getInventory(entityplayer.username);
		if (this.inv != null) {
			this.backpackstack = this.inv.getWing();

			this.Buffstack = this.inv.getBuff();
			
		}
		float var20 = 55.0F;

		if (this.backpackstack != null) {
			GL11.glPushAttrib(1048575);
			GL11.glPushMatrix();
			if (this.backpackstack.getItem() == FizzyclubArmor.Wing1) {
				this.mc.renderEngine.bindTexture(new ResourceLocation(
						"minelife:textures/armor/wing.png"));
				this.wing1.renderWing(0.0325F);
			}
			if (this.backpackstack.getItem() == FizzyclubArmor.Wing2) {
				this.mc.renderEngine.bindTexture(new ResourceLocation(
						"minelife:textures/armor/wing.png"));
				this.wing1.renderWing(0.0325F);
			}

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
			GL11.glPopAttrib();
		}
		if(this.Buffstack!=null){
			
			if(Buffstack.getItem()==FizzyclubArmor.Buff1){
				this.mc.renderEngine.bindTexture(new ResourceLocation(
						"minelife:textures/armor/buff.png"));
				this.Buff.render(0.0625F);
			}
			
//			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//			GL11.glPopMatrix();
//			GL11.glPopAttrib();
		}
	}

	public void doRender(Entity var1, double var2, double var4, double var6,
			float var8, float var9) {
		Field var10 = null;
		try {
			Field var11 = Field.class.getDeclaredField("modifiers");
			var11.setAccessible(true);
			Field[] var12 = RenderPlayer.class.getDeclaredFields();
			int var13 = var12.length;

			for (int var14 = 0; var14 < var13; var14++) {
				Field var15 = var12[var14];
				var15.setAccessible(true);
				try {
					if ((var15.getName().equals("modelBipedMain"))
							|| (var15.getName().equals("a"))
							|| (var15.getName().equals("modelBipedMain"))) {
						var10 = var15;
						var11.setInt(var15, var15.getModifiers() & 0xFFFFFFFD);
					}
				} catch (Exception var18) {
					var18.printStackTrace();
				}
			}
		} catch (Throwable var19) {
			var19.printStackTrace();
		}

		Class var20 = var1.getClass();

		for (Render var21 = (Render) defaultPlayerRender.get(var20); var21 == null; var21 = (Render) defaultPlayerRender
				.get(var20)) {
			var20 = var20.getSuperclass();
		}
		Render var21 = (Render) defaultPlayerRender.get(var20);
		var21.doRender(var1, var2, var4, var6, var8, var9);
		try {
			ModelBiped var22 = (ModelBiped) var10.get(var21);
			this.f = var22;
		} catch (Throwable var17) {
			var17.printStackTrace();
		}

		super.doRender((EntityPlayer) var1, var2, var4, var6, var8, var9);
	}
}