package fluke.theastree.block;

import java.util.List;
import java.util.Random;

import fluke.theastree.TheasTree;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
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

public class BlockDreamwoodInfectedLeaves extends BlockLeaves
{
	public static final String REG_NAME = "dreamwoodinfectedleaves";
	public static final PropertyBool INFECTED = PropertyBool.create("infected");
	private static final int INFECT_DELAY = 5; //infects at a rate of ~ INFECT_DELAY mins
	
	public BlockDreamwoodInfectedLeaves()
    {
        super();
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true).withProperty(INFECTED, false));
        setUnlocalizedName(TheasTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
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
        int meta = ((Boolean)state.getValue(INFECTED)).booleanValue() ? 1 : 0;

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            meta |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            meta |= 8;
        }

        return meta;
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(INFECTED, (meta % 2) != 0).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }
	
	@Override 
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if(!(Boolean)state.getValue(INFECTED) && rand.nextInt(INFECT_DELAY) == 0)
		{
			state = state.withProperty(INFECTED, Boolean.valueOf(true));
			world.setBlockState(pos, state, 2);
		}
		super.updateTick(world, pos, state, rand);
	}
	
	@SideOnly(Side.CLIENT) //TODO fix meeeeeeeeeeeeeeeeeeeeee
	public void initModel() 
	{
		IStateMapper mappy = (new StateMap.Builder()).ignore(new IProperty[] { CHECK_DECAY, DECAYABLE }).build();
		ModelLoader.setCustomStateMapper(this, mappy);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE, INFECTED);
    }
	
	//TODO why dont leaves darken like vanilla?
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

}
