package fluke.dreamtree.util;

import fluke.dreamtree.DreamTree;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockUtil 
{
	//returns state from string with format of mod:block:meta with meta being optional
	//may return null
	@SuppressWarnings("deprecation")
	public static IBlockState getStateFromString(String block)
	{
		String[] splitty = block.split(":");
		Block blocky;
		IBlockState out;
		if(splitty.length > 2)
		{
			blocky = Block.getBlockFromName(splitty[0] + ":" + splitty[1]);
			out = (blocky==null)? null : blocky.getStateFromMeta(Integer.valueOf(splitty[2]));
		}
		else
		{
			blocky = Block.getBlockFromName(block);
			out = (blocky==null)? null : blocky.getDefaultState();
		}
		
		if(out == null)
			DreamTree.logger.error("Cannot find block: " + block);
		return out;
	}
	
	public static ItemStack getItemStackFromString(String item)
	{
		String[] splitty = item.split(":");
		if(splitty.length > 2)
		{
			return GameRegistry.makeItemStack(splitty[0] + ":" + splitty[1], Integer.valueOf(splitty[2]), 1, "");
		}
		else
		{
			return GameRegistry.makeItemStack(item, 0, 1, ""); 
		}
	}

}
