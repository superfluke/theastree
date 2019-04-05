package fluke.dreamtree.block;

import fluke.dreamtree.DreamTree;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDreamwoodStairs extends BlockStairs
{
	public static final String REG_NAME = "dreamwoodstairs";
	
	public BlockDreamwoodStairs()
	{
		super(new BlockDreamwoodLog().getDefaultState());//ModBlocks.dwLog.getDefaultState());
		setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
