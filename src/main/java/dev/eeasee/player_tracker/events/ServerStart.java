package dev.eeasee.player_tracker.events;

import dev.eeasee.player_tracker.command.CommandPlayerTracker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class ServerStart implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerTickEvents.END_SERVER_TICK.register(ServerTick::trackPlayers);
        CommandRegistrationCallback.EVENT.register(CommandPlayerTracker::register);
    }
}
