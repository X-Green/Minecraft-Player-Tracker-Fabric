package dev.eeasee.player_tracker.events;

import dev.eeasee.player_tracker.data.PlayerTrackedData;
import dev.eeasee.player_tracker.fakes.IServerPlayNetworkHandler;
import dev.eeasee.player_tracker.utils.Pair;
import dev.eeasee.player_tracker.utils.TrackedDataUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.dimension.DimensionType;

class ServerTick {
    static void trackPlayers(MinecraftServer server) {
        PlayerManager playerManager = server.getPlayerManager();
        for (ServerPlayerEntity player : playerManager.getPlayerList()) {
            checkChunkMovement(player);
        }
    }

    private static void checkChunkMovement(ServerPlayerEntity player) {
        PlayerTrackedData trackedData = ((IServerPlayNetworkHandler)player.networkHandler).getPlayerTrackedData();
        DimensionType dimension = player.getServerWorld().getDimension();
        ChunkPos chunkPos = new ChunkPos(player.chunkX, player.chunkZ);
        Long time = System.currentTimeMillis();

        if (dimension != TrackedDataUtils.getLastEnteredDim(trackedData)) {
            trackedData.dimensionVisited.add(new Pair<>(time, dimension));
            trackedData.chunkVisited.add(new Pair<>(time, chunkPos));
        } else if (!chunkPos.equals(TrackedDataUtils.getLastEnteredChunkPos(trackedData))) {
            trackedData.chunkVisited.add(new Pair<>(time, chunkPos));
        }
    }

}
