# TpCentre

A Paper plugin that snaps you to the centre of the block you're standing on and turns you to face straight along the nearest compass direction.

It's built for map making. When you set a waypoint where you're standing, it lands wherever you happened to stop walking. Run `/tpc` first and every waypoint sits dead centre on its block, facing a clean direction.

## Features

- Centres you on your block horizontally, so `x 12.83, z -4.1` becomes `x 12.5, z -4.5`.
- Keeps your height, so it works on slabs, stairs and carpet.
- Turns you to whichever of north, east, south or west you're facing most, and levels your view.
- Refuses while you're riding a mount or vehicle.
- No config file and nothing to set up.

## Requirements

- Paper version 26.1 or newer

## Installation

1. Download the latest `tpcentre-<version>.jar` from [Releases](../../releases).
2. Put it in your server's `plugins/` folder.
3. Restart the server.

## Commands and permissions

| Command | Alias | Description | Permission | Default |
|---|---|---|---|---|
| `/tpcentre` | `/tpc` | Centre yourself on your block and face the nearest direction | `tpcentre.use` | op |

The command is for players only and can't be run from the console.

## Building from source

You'll need JDK 25.

```sh
git clone https://github.com/Big-Guns/tpcentre.git
cd tpcentre
./gradlew build
```

The jar is written to `build/libs/`.

## Contributing

Bug reports and pull requests are welcome on the [issue tracker](../../issues).

## Licence

[MIT](LICENSE)
