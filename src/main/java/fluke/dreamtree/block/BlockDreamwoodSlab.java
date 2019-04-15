package fluke.dreamtree.block;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockDreamwoodSlab extends BlockSlab
{
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
	
	public BlockDreamwoodSlab()
	{
		super(Material.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
		IBlockState iblockstate  = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(iblockstate);
		this.useNeighborBrightness = !this.isDouble();
	}

	@Override
	public String getUnlocalizedName(int meta)
	{
		return this.getUnlocalizedName();
	}

	@Override
	public IProperty<?> getVariantProperty()
	{
		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack)
	{
		return Variant.DEFAULT;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(ModBlocks.dwSlabHalf);
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            meta |= 8;
        }

        return meta;
    }
    
    protected BlockStateContainer createBlockState()
    {
    	if(!this.isDouble())
    	{
			return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
		}
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
    
    @SideOnly(Side.CLIENT)
	public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
    
    public static enum Variant implements IStringSerializable
	{
		DEFAULT;

		@Override
		public String getName() {
			return "default";
		}
	
	}

}
