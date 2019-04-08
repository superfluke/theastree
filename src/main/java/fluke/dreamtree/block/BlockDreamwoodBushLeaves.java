package fluke.dreamtree.block;

import java.util.List;
import java.util.Random;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.config.Configs;
import fluke.dreamtree.util.BlockUtil;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDreamwoodBushLeaves extends BlockLeaves
{
	public static final String REG_NAME = "dreamwoodbushleaves";
	private static final IBlockState AIR = Blocks.AIR.getDefaultState();
	private static int growthDelay;
	
	public BlockDreamwoodBushLeaves()
    {
        super();
        this.setTickRandomly(true);
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, Configs.general.doLeavesDecay));
        setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
    }
	
	public static void setBushBlockConfigs()
	{
		growthDelay = Configs.general.bushGrowthSpeed;
	}
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		
		if(rand.nextInt(growthDelay) == 0)
		{	
			if(Configs.weightedBushBlockList != null)
			{
				IBlockState below = world.getBlockState(pos.down());
				if(below == AIR)
				{
					IBlockState bushy = Configs.weightedBushBlockList.selectRandom();
					world.setBlockState(pos.down(), bushy);
				}
			}
			
		}
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(ModBlocks.dwLeaves, 1, 0)); 
	}
	
	protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.dwLeaves), 1, 0);
    }

	@Override
	public EnumType getWoodType(int meta) 
	{
		return null;
	}
	
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }
	
	@SideOnly(Side.CLIENT) 
	public void initModel() 
	{
		IStateMapper mappy = (new StateMap.Builder()).ignore(new IProperty[] { CHECK_DECAY, DECAYABLE }).build();
		ModelLoader.setCustomStateMapper(this, mappy);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return Blocks.LEAVES.getBlockLayer();
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return Blocks.LEAVES.isOpaqueCube(state);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
    	worldIn.setBlockState(pos, this.getDefaultState());
    }
}
