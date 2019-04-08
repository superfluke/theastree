package fluke.dreamtree.util;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.config.Configs;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class BlockUtil 
{
	//returns state from string with format of mod:block:meta with meta being optional
	//may return null
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

}
