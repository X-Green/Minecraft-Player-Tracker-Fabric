package dev.eeasee.player_tracker.data;

import com.google.common.collect.Lists;
import dev.eeasee.player_tracker.utils.Pair;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.dimension.DimensionType;

import java.util.List;

public class PlayerTrackedData {
    public final List<Pair<Long, ChunkPos>> chunkVisited = Lists.newArrayList();

    public final List<Pair<Long, DimensionType>> dimensionVisited = Lists.newArrayList();

    @Override
    public String toString() {
        return String.valueOf(chunkVisited) +
                dimensionVisited;
    }
}
