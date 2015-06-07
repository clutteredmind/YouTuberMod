package com.clutteredmind.amberthepeng.tools;

import net.minecraft.item.ItemSpade;
import net.minecraftforge.common.util.EnumHelper;

public class ItemHoleDigger extends ItemSpade
{
   public static final ToolMaterial HoleDiggerMaterial = EnumHelper.addToolMaterial ("HOLE_DIGGER", 3, 1000, 15.0f, 4.0f, 30);

   public ItemHoleDigger ()
   {
      super (HoleDiggerMaterial);
   }

}
