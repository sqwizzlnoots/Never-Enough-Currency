package com.zundrel.currency.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.zundrel.currency.client.render.tiles.TileEntityRenderDisplay;
import com.zundrel.currency.common.CommonProxy;
import com.zundrel.currency.common.blocks.tiles.TileEntityDisplay;
import com.zundrel.currency.common.info.ModInfo;


public class ClientProxy extends CommonProxy
{
	@Override
	public void preInitRenderers() {
		
	}
	
	@Override
	public void initRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplay.class, new TileEntityRenderDisplay());
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx)
    {
      return ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx);
    }
	
	@Override
	public void registerItemRenderer(Item i, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(i, meta,
				new ModelResourceLocation(ModInfo.MODID + ":"
						+ id, "inventory"));
	}
}