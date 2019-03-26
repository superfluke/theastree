package fluke.dreamtree.block;

import java.util.Random;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.config.Configs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSapWood extends Block 
{
	public static final String REG_NAME = "sapwood";
	private static final int SAP_REGEN_SPEED = Configs.general.sapProductionSpeed; 
	private static final IBlockState AIR = Blocks.AIR.getDefaultState();
	
	public BlockSapWood()
	{
		super(Material.WOOD);
		this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
        setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
	}
	
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }
	
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if(rand.nextInt(SAP_REGEN_SPEED) == 0)
		{
			IBlockState below = world.getBlockState(pos.down());
			if(below == AIR)
			{
				//TODO change to sap fluid
				world.setBlockState(pos.down(), Blocks.FLOWING_WATER.getDefaultState());
			}
			
		}
	}
	
	@Override 
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos)
	{ 
		return true; 
	}
	
    @Override 
    public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos)
    { 
    	return true; 
    }

    @SideOnly(Side.CLIENT)
	public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
