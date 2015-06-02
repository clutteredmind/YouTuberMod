package com.clutteredmind.amberthepeng.proxy;

import com.clutteredmind.amberthepeng.init.YouTuberModBlocks;
import com.clutteredmind.amberthepeng.init.YouTuberModEntities;
import com.clutteredmind.amberthepeng.init.YouTuberModItems;

public class ClientProxy
{
	public void registerRenders()
	{
		// TODO: register all renders here
		YouTuberModEntities.registerRenders();
		YouTuberModBlocks.registerRenders();
		YouTuberModItems.registerRenders();
	}
}
