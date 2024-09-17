/*
 * LibertyBans
 * Copyright © 2021 Anand Beh
 *
 * LibertyBans is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * LibertyBans is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */

package space.arim.libertybans.core.commands.extra;

import space.arim.libertybans.api.Victim;
import space.arim.libertybans.core.commands.CommandPackage;
import space.arim.libertybans.core.config.Configs;

/**
 * Use the composite-by-default config option together with command line options
 * to determine whether to parse a composite victim.
 *
 */
public final class ParsePlayerVictimDynamicallyComposite implements ParseVictim {

	private final Configs configs;
	private final CommandPackage command;

	public ParsePlayerVictimDynamicallyComposite(Configs configs, CommandPackage command) {
		this.configs = configs;
		this.command = command;
	}

	@Override
	public Victim.VictimType preferredType() {
		boolean compositeByDefault = configs.getMainConfig().commands().useCompositeVictimsByDefault();
		boolean useComposite = compositeByDefault ? !command.findHiddenArgument("uuid-only") : command.findHiddenArgument("both");
		return useComposite ? Victim.VictimType.COMPOSITE : Victim.VictimType.PLAYER;
	}

	@Override
	public String toString() {
		return "ParsePlayerVictimDynamicallyComposite{" +
				"configs=" + configs +
				", command=" + command +
				'}';
	}
}
