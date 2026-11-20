package dev.superepic.tpcentre;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

final class TpCentreCommand {
    private TpCentreCommand() {
    }

    static LiteralCommandNode<CommandSourceStack> node() {
        return Commands.literal("tpcentre")
                .requires(source -> source.getSender().hasPermission("tpcentre.use"))
                .executes(ctx -> run(ctx.getSource().getSender()))
                .build();
    }

    private static int run(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendPlainMessage("Only players can use this command.");
        } else if (player.isInsideVehicle()) {
            player.sendPlainMessage("Get off your mount or vehicle first.");
        } else {
            Location loc = player.getLocation();
            loc.setX(Centre.of(loc.getX()));
            loc.setZ(Centre.of(loc.getZ()));
            Facing facing = Facing.nearest(loc.getYaw());
            loc.setYaw(facing.yaw());
            loc.setPitch(0f);
            if (player.teleport(loc, TeleportCause.COMMAND)) {
                player.sendPlainMessage("Centred, facing " + facing.displayName() + ".");
            } else {
                player.sendPlainMessage("Couldn't centre you, something went wrong.");
            }
        }
        return Command.SINGLE_SUCCESS;
    }
}
