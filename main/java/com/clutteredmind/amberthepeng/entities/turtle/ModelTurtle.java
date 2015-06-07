package com.clutteredmind.amberthepeng.entities.turtle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTurtle extends ModelBase
{
   public ModelRenderer head;
   public ModelRenderer body;
   public ModelRenderer leg1;
   public ModelRenderer leg2;
   public ModelRenderer leg3;
   public ModelRenderer leg4;

   public ModelTurtle ()
   {
      textureWidth = 64;
      textureHeight = 64;

      this.head = new ModelRenderer (this, 1, 1);
      this.head.addBox (-2f, -2f, -5f, 4, 4, 5);
      this.head.setRotationPoint (0f, 19f, -8f);

      this.body = new ModelRenderer (this, 1, 20);
      this.body.addBox (-6f, -10f, -3f, 12, 18, 2);
      this.body.setRotationPoint (0f, 17f, 2f);
      this.body.setTextureOffset (20, 1).addBox (-5f, -9f, -1f, 10, 16, 1);
      this.body.setTextureOffset (43, 1).addBox (-4f, -8f, 0f, 8, 14, 1);
      this.body.setTextureOffset (1, 42).addBox (-3f, -7f, 1f, 6, 12, 1);

      this.leg1 = new ModelRenderer (this, 1, 11);
      this.leg1.addBox (-3f, 0f, -2f, 3, 4, 3);
      this.leg1.setRotationPoint (-3f, 20f, 9f);

      this.leg2 = new ModelRenderer (this, 1, 11);
      this.leg2.addBox (-1f, 0f, -2f, 3, 4, 3);
      this.leg2.setRotationPoint (4f, 20f, 9f);

      this.leg3 = new ModelRenderer (this, 1, 11);
      this.leg3.addBox (-3f, 0f, -3f, 3, 4, 3);
      this.leg3.setRotationPoint (-3f, 20f, -5f);

      this.leg4 = new ModelRenderer (this, 1, 11);
      this.leg4.addBox (-1f, 0f, -3f, 3, 4, 3);
      this.leg4.setRotationPoint (4f, 20f, -5f);
   }

   @Override
   public void render (Entity entity, float time, float limbSwingDistance, float p_78088_4_, float headYRot,
         float headXRot, float Ytrans)
   {
      this.setRotationAngles (time, limbSwingDistance, p_78088_4_, headYRot, headXRot, Ytrans, entity);

      if (this.isChild)
      {
         float div = 2.0f;
         GlStateManager.pushMatrix ();
         GlStateManager.scale (1.0f / div, 1.0f / div, 1.0f / div);
         GlStateManager.translate (0.0f, 24.0f * Ytrans, 0.0f);
         this.head.render (Ytrans);
         this.body.render (Ytrans);
         this.leg1.render (Ytrans);
         this.leg2.render (Ytrans);
         this.leg3.render (Ytrans);
         this.leg4.render (Ytrans);
         GlStateManager.popMatrix ();
      }
      else
      {
         this.head.render (Ytrans);
         this.body.render (Ytrans);
         this.leg1.render (Ytrans);
         this.leg2.render (Ytrans);
         this.leg3.render (Ytrans);
         this.leg4.render (Ytrans);
      }
   }

   @Override
   public void setRotationAngles (float time, float limbSwingDistance, float p_78087_3_, float headYRot,
         float headXRot, float p_78087_6_, Entity entity)
   {
      this.head.rotateAngleX = headXRot / (180f / (float) Math.PI);
      this.head.rotateAngleY = headYRot / (180f / (float) Math.PI);

      this.body.rotateAngleX = ((float) Math.PI / 2f);

      this.leg1.rotateAngleX = MathHelper.cos (time * 0.6662f) * 1.4F * limbSwingDistance;
      this.leg2.rotateAngleX = MathHelper.cos (time * 0.6662f + (float) Math.PI) * 1.4f * limbSwingDistance;
      this.leg3.rotateAngleX = MathHelper.cos (time * 0.6662f + (float) Math.PI) * 1.4f * limbSwingDistance;
      this.leg4.rotateAngleX = MathHelper.cos (time * 0.6662f) * 1.4f * limbSwingDistance;
   }
}
