package fluke.dreamtree.block;

import fluke.dreamtree.DreamTree;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFireBug extends BlockBugBase
{
	
	public static final String REG_NAME = "firebug";
	
	public BlockFireBug()
	{
		super();
        this.setLightLevel(0.2F);
        setUnlocalizedName(DreamTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
