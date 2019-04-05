package fluke.dreamtree.block;

import fluke.dreamtree.DreamTree;

public class BlockDoubleDreamwoodSlab extends BlockDreamwoodSlab
{
	public static final String REG_NAME = "dreamwoodslab_double";
	
	public BlockDoubleDreamwoodSlab()
	{
		super();
		setUnlocalizedName(DreamTree.MODID + ".dreamwoodslab"); 
		setRegistryName(REG_NAME);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}

}
