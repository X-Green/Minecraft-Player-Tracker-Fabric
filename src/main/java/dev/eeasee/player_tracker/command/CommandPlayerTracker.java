package dev.eeasee.player_tracker.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.eeasee.player_tracker.data.PlayerTrackedData;
import dev.eeasee.player_tracker.utils.TrackedDataUtils;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandPlayerTracker {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        LiteralArgumentBuilder<ServerCommandSource> argumentBuilder = literal("player-tracker");
        argumentBuilder = argumentBuilder.executes(CommandPlayerTracker::test);

        dispatcher.register(argumentBuilder);
    }

    private static int test(CommandContext<ServerCommandSource> commandContext) throws CommandSyntaxException {
        ServerPlayerEntity playerEntity =  commandContext.getSource().getPlayer();
        PlayerTrackedData data = TrackedDataUtils.getFromPlayer(playerEntity);
        System.out.println(data);
        return 1;
    }
}
