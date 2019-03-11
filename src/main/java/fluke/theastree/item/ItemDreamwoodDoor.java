package fluke.theastree.item;

import fluke.theastree.TheasTree;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDreamwoodDoor extends ItemDoor
{
	
	public static final String REG_NAME = "dreamwooddoor_item";

	public ItemDreamwoodDoor(Block block)
	{
		super(block);
		setUnlocalizedName(TheasTree.MODID + "." + REG_NAME); 
		setRegistryName(REG_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
