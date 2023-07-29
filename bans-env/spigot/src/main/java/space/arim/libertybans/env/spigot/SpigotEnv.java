/*
 * LibertyBans
 * Copyright © 2023 Anand Beh
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

package space.arim.libertybans.env.spigot;

import jakarta.inject.Inject;
import jakarta.inject.Provider;
import space.arim.libertybans.core.commands.Commands;
import space.arim.libertybans.core.env.Environment;
import space.arim.libertybans.core.env.PlatformListener;

import java.util.Set;

public final class SpigotEnv implements Environment {

	private final Provider<ConnectionListener> connectionListener;
	private final Provider<ChatListener> chatListener;
	private final CommandHandler.CommandHelper commandHelper;
	private final ChannelRegistration channelRegistration;

	@Inject
	public SpigotEnv(Provider<ConnectionListener> connectionListener, Provider<ChatListener> chatListener,
					 CommandHandler.CommandHelper commandHelper, ChannelRegistration channelRegistration) {
		this.connectionListener = connectionListener;
		this.chatListener = chatListener;
		this.commandHelper = commandHelper;
		this.channelRegistration = channelRegistration;
	}

	@Override
	public Set<PlatformListener> createListeners() {
		return Set.of(
				connectionListener.get(),
				chatListener.get(),
				new CommandHandler(commandHelper, Commands.BASE_COMMAND_NAME, false),
				channelRegistration
		);
	}

	@Override
	public PlatformListener createAliasCommand(String command) {
		return new CommandHandler(commandHelper, command, true);
	}
	
}
