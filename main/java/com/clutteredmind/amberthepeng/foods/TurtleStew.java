package com.clutteredmind.amberthepeng.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class TurtleStew extends ItemFood
{
	public TurtleStew(String unlocalizedName)
	{
		// initialize the base class to restore 5 hunger, 0.6 saturation, and not to be wolf food
		super(5, 0.6f, false);
		// save name
		this.setUnlocalizedName(unlocalizedName);
		// make this food always edible
		this.setAlwaysEdible();
		// add self to the "food" tab in creative
		this.setCreativeTab(CreativeTabs.tabFood);
	}

}
