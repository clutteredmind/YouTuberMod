package com.clutteredmind.amberthepeng.tools;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemFrostmourne extends ItemSword
{
   public static final ToolMaterial FrostmourneMaterial = EnumHelper.addToolMaterial ("FROSTMOURNE", 3, 1000, 8.0f, 4.0f, 30);

   public ItemFrostmourne ()
   {
      super (FrostmourneMaterial);
   }

}
