package fluke.dreamtree.world;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

public class ChunkGeneratorDreamTree implements IChunkGenerator
{
	private final World world;
	private static final IBlockState STONE = Blocks.STONE.getDefaultState();
	
	public ChunkGeneratorDreamTree(final World world)
	{
		this.world = world;
	}

	@Override
	public Chunk generateChunk(int x, int z)
	{
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.generateTerrain(x, z, chunkprimer);
		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
		chunk.generateSkylightMap();
		return chunk;
	}
	
	public void generateTerrain(final int chunkX, final int chunkZ, final ChunkPrimer primer)
    {
		if(Math.abs(chunkX) <= 1 && Math.abs(chunkZ) <= 1)
		{
			for(int x = 0; x < 16; x++)
				for(int z = 0; z < 16; z++)
					primer.setBlockState(x, 60, z, STONE);
		}
    }

	@Override
	public void populate(int x, int z)
	{
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z)
	{
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
	{
		// TODO can this be null?
		return null;
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
			boolean findUnexplored)
	{
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z)
	{		
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos)
	{
		return false;
	}
	

}
