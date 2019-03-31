package fluke.dreamtree.block;

import java.util.Random;

import fluke.dreamtree.DreamTree;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDreamwoodTorch extends BlockTorch
{
	public static final String REG_NAME = "dreamwoodtorch";
	
	public BlockDreamwoodTorch()
	{
		super();
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.WOOD);
        this.setLightLevel(0.9375F);
        setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
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
