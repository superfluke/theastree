package fluke.dreamtree.world;

import fluke.dreamtree.DreamTree;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeDreamTree extends WorldType
{
	
	public WorldTypeDreamTree()
	{
		super("dreamtree");
	}
	
	@Override
	public IChunkGenerator getChunkGenerator(World world, String genOptions)
	{
		return new ChunkGeneratorDreamTree(world);
	}
	
	@Override
    public boolean isCustomizable()
    {
        return false;
    }
	
	public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderSingle(DreamTree.biomeGarden);        
    }
	
	@SideOnly(Side.CLIENT)
    public String getTranslationKey()
    {
        return "Dream Tree";
    }
	
	@Override
    public double getHorizon(World world) 
	{
        return 0;
    }

}
