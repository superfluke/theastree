package fluke.dreamtree.proxy;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.world.BiomeAncientGarden;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class CommonProxy 
{
	public boolean fancyGraphicsEnabled()
    {
        return false;
    }
	
	@Mod.EventBusSubscriber(modid = DreamTree.MODID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<Biome> event)
        {
        	DreamTree.biomeGarden = (BiomeAncientGarden) new BiomeAncientGarden().setRegistryName(DreamTree.MODID, "ancient_garden");
            final IForgeRegistry<Biome> registry = event.getRegistry();            
            registry.register(DreamTree.biomeGarden);
        }
    }

	public void init()
	{
		BiomeDictionary.addTypes(DreamTree.biomeGarden, 
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.LUSH,
                BiomeDictionary.Type.MAGICAL
                );
		
	}
}
