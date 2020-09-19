package dev.eeasee.player_tracker.utils;

import dev.eeasee.player_tracker.data.PlayerTrackedData;
import dev.eeasee.player_tracker.fakes.IServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.dimension.DimensionType;

public class PlayerTrackedDataOperator {

    public static ChunkPos getLastEnteredChunkPos(PlayerTrackedData data) {
        return (data.chunkVisited.size() == 0) ?
                null : data.chunkVisited.get(data.chunkVisited.size() - 1).getRight();
    }

    public static DimensionType getLastEnteredDim(PlayerTrackedData data) {
        return (data.dimensionVisited.size() == 0) ?
                null : data.dimensionVisited.get(data.dimensionVisited.size() - 1).getRight();
    }

    public static PlayerTrackedData getFromPlayer(ServerPlayerEntity player) {
        return ((IServerPlayNetworkHandler)player.networkHandler).getPlayerTrackedData();
    }
}
