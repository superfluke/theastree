package fluke.dreamtree.block;

import java.util.List;

import fluke.dreamtree.DreamTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDreamwoodLeavesFlowering extends BlockDreamwoodLeavesBase
{
public static final String REG_NAME = "dreamwoodleavesflowering";
	
	public BlockDreamwoodLeavesFlowering()
    {
        super();
        this.setLightLevel(0.34F);
        setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
    }
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, 0)); 
	}
	
	protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, 0);
    }
}
