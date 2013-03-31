package com.volumetricpixels.mcsquared.api.energy;

import org.spout.api.geo.discrete.Point;
import org.spout.api.material.block.BlockFace;


/**
 * Represents a member of an energy network
 */
public interface IEnergyNetworkMember {
	/**
	 * Gets the basic type of energy member this member is
	 * 
	 * @return This energy network member's basic type
	 */
	EnergyNetworkMemberType getBasicType();

	/**
	 * Gets the position of this energy network member
	 * 
	 * @return A Point representing the position of this network member
	 */
	Point getPosition();

	/**
	 * Gets the network this energy network member is a part of
	 * 
	 * @return The energy network this member is a part of
	 */
	IEnergyNetwork getNetwork();

	/**
	 * Gets an array of adjacent network members to this one
	 * 
	 * @param update Whether to update the adjacent members
	 * @return An array of energy network members adjacent to this one
	 */
	IEnergyNetworkMember[] getAdjacentMembers(boolean update);

	/**
	 * Returns whether this network member can connect to the adjacent block in
	 * the direction of the given BlockFace
	 * 
	 * @param face The BlockFace facing the block to check
	 * @return Whether this network member can connect to block in given
	 *         direction
	 */
	boolean canConnect(BlockFace face);

	/**
	 * Contains all basic types of energy network member
	 * 
	 * All complex types extend a basic concept (e.g transmitter extends the
	 * concept of consumer, receiver extends the concept of producer)
	 */
	public static enum EnergyNetworkMemberType {
		/**
		 * A producer of energy
		 */
		PRODUCER(0, "Producer"),
		/**
		 * A consumer of energy
		 */
		CONSUMER(1, "Consumer"),
		/**
		 * A producer and consumer of energy
		 */
		PRODUCER_AND_CONSUMER(2, "Producer & Consumer"),
		/**
		 * A conductor of energy
		 */
		CONDUCTOR(3, "Conductor");

		/** The ID of the member type */
		private final int id;
		/** The name of the member type */
		private final String name;

		/**
		 * Constructs a new energy network member type
		 * 
		 * @param id The ID of the member type
		 * @param name The name of the member type
		 */
		private EnergyNetworkMemberType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		/**
		 * Gets the ID of the member type
		 * 
		 * @return The ID of this member type
		 */
		public int getId() {
			return id;
		}

		/**
		 * Gets the name of the member type
		 * 
		 * @return The name of this member type
		 */
		public String getName() {
			return name;
		}
	}
}
