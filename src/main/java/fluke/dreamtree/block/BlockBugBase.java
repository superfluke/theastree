package fluke.dreamtree.block;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBugBase extends BlockTorch 
{
	//TODO override getMetaFromState/getStateFromMeta
	public static final PropertyDirection FLOOR_FACING = PropertyDirection.create("floor_facing", new Predicate<EnumFacing>()
    {
        public boolean apply(@Nullable EnumFacing p_apply_1_)
        {
            return p_apply_1_ != EnumFacing.DOWN;
        }
    });
	protected static final AxisAlignedBB STANDING_NS_AABB = new AxisAlignedBB(0.35D, 0.0D, 0.2D, 0.65D, 0.15D, 0.75D);
	protected static final AxisAlignedBB STANDING_WE_AABB = new AxisAlignedBB(0.2D, 0.0D, 0.35D, 0.75D, 0.15D, 0.65D);
    protected static final AxisAlignedBB WALL_NORTH_AABB = new AxisAlignedBB(0.35D, 0.2D, 0.85D, 0.65D, 0.75D, 1.0D);
    protected static final AxisAlignedBB WALL_SOUTH_AABB = new AxisAlignedBB(0.35D, 0.2D, 0.0D, 0.65D, 0.75D, 0.15D);
    protected static final AxisAlignedBB WALL_WEST_AABB = new AxisAlignedBB(0.85D, 0.2D, 0.35D, 1.0D, 0.75D, 0.65D);
    protected static final AxisAlignedBB WALL_EAST_AABB = new AxisAlignedBB(0.0D, 0.2D, 0.35D, 0.15D, 0.75D, 0.65D);
    
    public BlockBugBase()
	{
		super();
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP).withProperty(FLOOR_FACING, EnumFacing.UP));
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
                return WALL_EAST_AABB;
            case WEST:
                return WALL_WEST_AABB;
            case SOUTH:
                return WALL_SOUTH_AABB;
            case NORTH:
                return WALL_NORTH_AABB;
            default:
            {
            	switch ((EnumFacing)state.getValue(FLOOR_FACING))
            	{
            		case EAST:
            		case WEST:
            			return STANDING_WE_AABB;
            		case SOUTH:
            		case NORTH:
        			default:
        				return STANDING_NS_AABB;
            	}
            }
        }
    }
    
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
    }
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		IBlockState placeState = null;
		
        if (this.canPlaceAt(worldIn, pos, facing))
        {
        	placeState = this.getDefaultState().withProperty(FACING, facing);
        }
        else
        {
            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (this.canPlaceAt(worldIn, pos, enumfacing))
                {
                	placeState = this.getDefaultState().withProperty(FACING, enumfacing);
                	break;
                }
            } 
        }
        
        if(placeState == null || (EnumFacing)placeState.getValue(FACING) == EnumFacing.UP)
        	placeState = this.getDefaultState().withProperty(FLOOR_FACING, placer.getHorizontalFacing());
        
        return placeState;
    }
	
	private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing)
    {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        IBlockState iblockstate = worldIn.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, facing);

        if (facing.equals(EnumFacing.UP) && this.canPlaceOn(worldIn, blockpos))
        {
            return true;
        }
        else if (facing != EnumFacing.UP && facing != EnumFacing.DOWN)
        {
            return !isExceptBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID;
        }
        else
        {
            return false;
        }
    }
	
	private boolean canPlaceOn(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);
        return state.getBlock().canPlaceTorchOnTop(state, worldIn, pos);
    }
	
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, FLOOR_FACING});
    }
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                i = i | 1;
                break;
            case WEST:
                i = i | 2;
                break;
            case SOUTH:
                i = i | 3;
                break;
            case NORTH:
                i = i | 4;
                break;
            case DOWN:
            case UP:
            default:
                i = i | 8;
        }
        
        switch ((EnumFacing)state.getValue(FLOOR_FACING))
        {
            case EAST:
                i = i | 1;
                break;
            case WEST:
                i = i | 2;
                break;
            case SOUTH:
                i = i | 3;
                break;
            case NORTH:
                i = i | 4;
                break;
            case DOWN:
            case UP:
            default:
        }

        return i;
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();
        
        if(meta > 8)
        {
        	int floorDir = meta % 8;
        	switch (floorDir)
        	{
	        	case 1:
	                iblockstate = iblockstate.withProperty(FLOOR_FACING, EnumFacing.EAST);
	                break;
	            case 2:
	                iblockstate = iblockstate.withProperty(FLOOR_FACING, EnumFacing.WEST);
	                break;
	            case 3:
	                iblockstate = iblockstate.withProperty(FLOOR_FACING, EnumFacing.SOUTH);
	                break;
	            case 4:
	                iblockstate = iblockstate.withProperty(FLOOR_FACING, EnumFacing.NORTH);
	                break;
	            case 5:
	            default:
        	}
        }else
        {

	        switch (meta)
	        {
	            case 1:
	                iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
	                break;
	            case 2:
	                iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
	                break;
	            case 3:
	                iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
	                break;
	            case 4:
	                iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
	                break;
	            case 5:
	            default:
	                iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
	        }
        }

        return iblockstate;
    }

}
