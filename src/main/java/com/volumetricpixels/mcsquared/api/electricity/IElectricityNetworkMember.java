package com.volumetricpixels.mcsquared.api.electricity;

import org.spout.api.geo.discrete.Point;
import org.spout.api.material.block.BlockFace;

/**
 * Represents a member of an electricity network
 */
public interface IElectricityNetworkMember {
	/**
	 * Gets the basic type of electricity member this member is
	 * 
	 * @return This electricity network member's basic type
	 */
	ElectricityNetworkMemberType getBasicType();

	/**
	 * Gets the position of this electricity network member
	 * 
	 * @return A Point representing the position of this network member
	 */
	Point getPosition();

	/**
	 * Gets the network this electricity network member is a part of
	 * 
	 * @return The electricity network this member is a part of
	 */
	IElectricityNetwork getNetwork();

	/**
	 * Gets an array of adjacent network members to this one
	 * 
	 * @param update Whether to update the adjacent members
	 * @return An array of electricity network members adjacent to this one
	 */
	IElectricityNetworkMember[] getAdjacentMembers(boolean update);

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
	 * Contains all basic types of electricity network member
	 * 
	 * All complex types extend a basic concept (e.g transmitter extends the
	 * concept of consumer, receiver extends the concept of producer)
	 */
	public static enum ElectricityNetworkMemberType {
		/**
		 * A producer of electricity
		 */
		PRODUCER(0, "Producer"),
		/**
		 * A consumer of electricity
		 */
		CONSUMER(1, "Consumer"),
		/**
		 * A producer and consumer of electricity
		 */
		PRODUCER_AND_CONSUMER(2, "Producer & Consumer"),
		/**
		 * A conductor of electricity
		 */
		CONDUCTOR(3, "Conductor");

		/** The ID of the member type */
		private final int id;
		/** The name of the member type */
		private final String name;

		/**
		 * Constructs a new electricity network member type
		 * 
		 * @param id The ID of the member type
		 * @param name The name of the member type
		 */
		private ElectricityNetworkMemberType(int id, String name) {
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
