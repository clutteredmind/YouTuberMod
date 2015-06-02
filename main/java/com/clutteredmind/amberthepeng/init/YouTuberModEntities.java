package com.clutteredmind.amberthepeng.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle;
import com.clutteredmind.amberthepeng.entities.turtle.ModelTurtle;
import com.clutteredmind.amberthepeng.entities.turtle.RenderTurtle;
import com.clutteredmind.amberthepeng.entities.youtuber.stampy.EntityYouTuberStampy;
import com.clutteredmind.amberthepeng.entities.youtuber.stampy.RenderYouTuberStampy;

public class YouTuberModEntities
{
	public static void register()
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityTurtle.class, "turtle", entityId, 210528, 65280);
		EntityRegistry.addSpawn(EntityTurtle.class, 40, 1, 5, EnumCreatureType.CREATURE, BiomeGenBase.beach);
		
		entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityYouTuberStampy.class, "stampy", entityId, 190528, 45280);
	}
	
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(Minecraft.getMinecraft().getRenderManager(), new ModelTurtle(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityYouTuberStampy.class, new RenderYouTuberStampy(new ResourceLocation("mod_youtubermod:textures/entity/stampyskin.png"), Minecraft.getMinecraft().getRenderManager(), new ModelPlayer(0.0f, true), 0.5F));
	}
}
