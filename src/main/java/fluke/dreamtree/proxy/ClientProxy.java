package fluke.dreamtree.proxy;

import fluke.dreamtree.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy 
{
	@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) 
	{
        ModBlocks.initModels();
    }
	
	@Override
    public boolean fancyGraphicsEnabled()
    {
        return Minecraft.getMinecraft().gameSettings.fancyGraphics;
    }
}
