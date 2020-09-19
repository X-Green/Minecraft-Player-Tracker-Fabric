package dev.eeasee.player_tracker.mixin;

import dev.eeasee.player_tracker.data.PlayerTrackedData;
import dev.eeasee.player_tracker.fakes.IServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin implements IServerPlayNetworkHandler {
    private final PlayerTrackedData playerTrackedData = new PlayerTrackedData();

    @Override
    public PlayerTrackedData getPlayerTrackedData() {
        return playerTrackedData;
    }
}
