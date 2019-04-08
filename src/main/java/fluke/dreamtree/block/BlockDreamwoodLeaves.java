package fluke.dreamtree.block;

import fluke.dreamtree.DreamTree;

public class BlockDreamwoodLeaves extends BlockDreamwoodLeavesBase
{
	public static final String REG_NAME = "dreamwoodleaves";
	
	public BlockDreamwoodLeaves()
    {
        super();
        setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
    }
}
