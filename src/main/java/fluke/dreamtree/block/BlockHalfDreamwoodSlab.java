package fluke.dreamtree.block;

import fluke.dreamtree.DreamTree;

public class BlockHalfDreamwoodSlab extends BlockDreamwoodSlab
{
	public static final String REG_NAME = "dreamwoodslab";
	
	public BlockHalfDreamwoodSlab()
	{
		super();
		setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}

}
