package fluke.theastree.block;

import java.util.Random;

import fluke.theastree.TheasTree;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLightBug extends BlockTorch
{
	
	public static final String REG_NAME = "lightbug";
    protected static final AxisAlignedBB STANDING_AABB = new AxisAlignedBB(0.35D, 0.0D, 0.2D, 0.65D, 0.15D, 0.75D);
    protected static final AxisAlignedBB BUG_NORTH_AABB = new AxisAlignedBB(0.35D, 0.2D, 0.85D, 0.65D, 0.75D, 1.0D);
    protected static final AxisAlignedBB BUG_SOUTH_AABB = new AxisAlignedBB(0.35D, 0.2D, 0.0D, 0.65D, 0.75D, 0.15D);
    protected static final AxisAlignedBB BUG_WEST_AABB = new AxisAlignedBB(0.85D, 0.2D, 0.35D, 1.0D, 0.75D, 0.65D);
    protected static final AxisAlignedBB BUG_EAST_AABB = new AxisAlignedBB(0.0D, 0.2D, 0.35D, 0.15D, 0.75D, 0.65D);

	
	public BlockLightBug()
	{
		super();
        this.setCreativeTab(CreativeTabs.MISC);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.setLightLevel(0.8F);
        setUnlocalizedName(TheasTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
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
	
	@SideOnly(Side.CLIENT)
	public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
    }

}
