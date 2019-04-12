package fluke.dreamtree.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.config.Configs;
import fluke.dreamtree.util.BlockUtil;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDreamwoodInfestedLeaves extends BlockDreamwoodLeavesBase
{
	public static final String REG_NAME = "dreamwoodinfestedleaves";
	public static final PropertyBool INFESTED = PropertyBool.create("infested");
	private static final int INFEST_DELAY = Configs.general.infestationSpeed; // infects at a rate of ~ INFEST_DELAY mins
	private static List<Item> harvestTools;

	public BlockDreamwoodInfestedLeaves()
	{
		super();
		this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true)
				.withProperty(DECAYABLE, Configs.general.doLeavesDecay).withProperty(INFESTED, true));
		setUnlocalizedName(DreamTree.MODID + "." + REG_NAME);
		setRegistryName(REG_NAME);
	}
	
	public static void updateToolList()
	{
		harvestTools = new ArrayList<Item>();
		for(String s : Configs.general.infestedHarvestingTools)
		{
			harvestTools.add(BlockUtil.getItemStackFromString(s).getItem());
		}
	}

	public int getMetaFromState(IBlockState state)
	{
		int meta = ((Boolean) state.getValue(INFESTED)).booleanValue() ? 1 : 0;

		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue())
		{
			meta |= 4;
		}

		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue())
		{
			meta |= 8;
		}

		return meta;
	}

	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(INFESTED, (meta % 2) != 0)
				.withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0))
				.withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!(Boolean) state.getValue(INFESTED) && rand.nextInt(INFEST_DELAY) == 0)
		{
			state = state.withProperty(INFESTED, Boolean.valueOf(true));
			world.setBlockState(pos, state, 2);
		}
		super.updateTick(world, pos, state, rand);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE, INFESTED);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			if (harvestTools.contains(player.getHeldItem(hand).getItem()))
			{
				if ((Boolean) state.getValue(INFESTED))
				{
					world.setBlockState(pos, state.withProperty(INFESTED, false));
					EntityItem entity = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, Configs.weightedInfestedDrops.selectRandom());
					world.spawnEntity(entity);
					return true;
				}
			}
		}
		return false;
	}

}
