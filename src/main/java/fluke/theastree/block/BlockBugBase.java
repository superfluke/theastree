package fluke.theastree.block;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBugBase extends BlockTorch 
{
	protected static final AxisAlignedBB STANDING_AABB = new AxisAlignedBB(0.35D, 0.0D, 0.2D, 0.65D, 0.15D, 0.75D);
    protected static final AxisAlignedBB BUG_NORTH_AABB = new AxisAlignedBB(0.35D, 0.2D, 0.85D, 0.65D, 0.75D, 1.0D);
    protected static final AxisAlignedBB BUG_SOUTH_AABB = new AxisAlignedBB(0.35D, 0.2D, 0.0D, 0.65D, 0.75D, 0.15D);
    protected static final AxisAlignedBB BUG_WEST_AABB = new AxisAlignedBB(0.85D, 0.2D, 0.35D, 1.0D, 0.75D, 0.65D);
    protected static final AxisAlignedBB BUG_EAST_AABB = new AxisAlignedBB(0.0D, 0.2D, 0.35D, 0.15D, 0.75D, 0.65D);
    
    public BlockBugBase()
	{
		super();
        this.setCreativeTab(CreativeTabs.MISC);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
	}
    
    @Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                return BUG_EAST_AABB;
            case WEST:
                return BUG_WEST_AABB;
            case SOUTH:
                return BUG_SOUTH_AABB;
            case NORTH:
                return BUG_NORTH_AABB;
            default:
                return STANDING_AABB;
        }
    }
    
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
    }

}