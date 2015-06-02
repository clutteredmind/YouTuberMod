package com.clutteredmind.amberthepeng.entities.youtuber;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderYouTuber extends RenderLiving
{
	private static ResourceLocation youTuberTexture;

	public RenderYouTuber(ResourceLocation resourceLocation, RenderManager renderManager, ModelBase model, float shadowSize)
	{
		super(renderManager, model, shadowSize);
		this.youTuberTexture = resourceLocation;
	}

	protected ResourceLocation func_180572_a(EntityYouTuber entity)
	{
		return youTuberTexture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.func_180572_a((EntityYouTuber)entity);
	}
}
