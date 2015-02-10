package FizzyClubMods.Proxy;

import java.util.Iterator;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import FizzyClubMods.Gui.KeyHandler.InventoryKeyHandler;
import FizzyClubMods.entity.render.RenderCustomPlayer;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class FizzyclubClient extends FizzyclubServer{

	
	  public void renderPlayer()
	  {
	    RenderCustomPlayer var1 = new RenderCustomPlayer(new ModelBiped());
	    Map var2 = RenderManager.instance.entityRenderMap;
	    Iterator var3 = var2.entrySet().iterator();

	    while (var3.hasNext())
	    {
	      Map.Entry var4 = (Map.Entry)var3.next();

	      if (EntityPlayer.class.isAssignableFrom((Class)var4.getKey()))
	      {
	        Class var5 = ((Render)var4.getValue()).getClass();
	        RenderCustomPlayer.defaultPlayerRender.put(var4.getKey(), var4.getValue());
	        RenderingRegistry.registerEntityRenderingHandler((Class)var4.getKey(), var1);
	      }
	    }
	  }

	  public void registerKeyhandler() {
	    KeyBindingRegistry.registerKeyBinding(new InventoryKeyHandler());
	  }
	}