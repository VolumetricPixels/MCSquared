package com.volumetricpixels.mcsquared.api.electricity;

import java.util.Map;
import java.util.Set;

import com.volumetricpixels.mcsquared.api.energy.IEnergyNetworkMember;


/**
 * Represents an network of consumers, producers, transmitters, receivers and
 * conductors of electricity, or an 'electricity network'
 */
public interface IElectricityNetwork {
	/**
	 * Causes the given electricity network member to start producing
	 * electricity for this electricity network. If member is null, or
	 * packet is null, an IllegalArgumentException is thrown
	 * 
	 * @param member The member to start producing electricity
	 * @param packet The amount of electricity to start producing
	 * @throws IllegalArgumentException If member or packet is null
	 */
	void startProduction(IEnergyNetworkMember member, IElectricityPacket packet);

	/**
	 * Causes the given electricity network member to start producing
	 * electricity for this electricity network. If member is null, an
	 * IllegalArgumentException is thrown
	 * 
	 * @param member The member to start producing electricity
	 * @param amps The amount of amps to start producing
	 * @param volts The amount of volts to start producing
	 * @throws IllegalArgumentException If member is null
	 */
	void startProduction(IEnergyNetworkMember member, double amps, double volts);

	/**
	 * Stops the given electricity network manager from producing
	 * electricity for this network. If member is null, an
	 * IllegalArgumentException is thrown
	 * 
	 * @param member The member to stop producing electricity
	 * @throws IllegalArgumentException If member is null
	 */
	void stopProduction(IEnergyNetworkMember member);

	/**
	 * Checks if the given electricity network member is currently producing
	 * electricity for this network. If member is null, an
	 * IllegalArgumentException is thrown
	 * 
	 * @param member The member to check for production from
	 * @return Whether the given member is producing electricity for this
	 *         network
	 * @throws IllegalArgumentException If member is null
	 */
	boolean isProducing(IEnergyNetworkMember member);

	/**
	 * Causes the given electricity network manager to start to consume the
	 * given amount of electricity in the form of an electricity packet from the
	 * electricity network. If packet is null or member is null, an
	 * IllegalArgumentException is thrown
	 * 
	 * @param member The member to start consumeing the network
	 * @param packet The amount of electricity to start consumeing
	 * @throws IllegalArgumentException If an argument is null
	 */
	void startConsumption(IEnergyNetworkMember member, IElectricityPacket packet);

	/**
	 * Causes the given electricity network manager to start to consume the
	 * given amount of electricity in the form of amps and volts from the
	 * electricity network. If member is null, an IllegalArgumentException
	 * is thrown
	 * 
	 * @param member The member to start consumeing the network
	 * @param amps The amount of amps to consume from the network
	 * @param volts The amount of volts to consume from the network
	 * @throws IllegalArgumentException If member is null
	 */
	void startConsumption(IEnergyNetworkMember member, double amps, double volts);

	/**
	 * Stops the given electricity network member from consumeing any more
	 * electricity from this particular electricity network only. If member is
	 * null, an IllegalArgumentException is thrown.
	 * 
	 * @param member The member to stop incoming consumes from
	 * @throws IllegalArgumentException If member is null
	 */
	void stopConsumption(IEnergyNetworkMember member);

	/**
	 * Checks if the given electricity network member is consumeing to received
	 * electricity from this electricity network. If member is null, a
	 * IllegalArgumentException is thrown
	 * 
	 * @param member The member to check for incoming consumes from
	 * @return Whether the given member is consumeing from this network
	 * @throws IllegalArgumentException If member is null
	 */
	boolean isConsuming(IEnergyNetworkMember member);

	/**
	 * Gets the amount of electricity produced by this electricity network,
	 * ignoring any electricity network members given in the only method
	 * argument. If the argument is null, this will function as normal and
	 * return the amount of electricity produced by the entire network, with no
	 * exclusions
	 * 
	 * @param excluded Electricity network members to exclude
	 * @return The amount of electricity this network produces minus that
	 *         produced by members contained in excluded
	 */
	IElectricityPacket getProduced(IEnergyNetworkMember... excluded);

	/**
	 * Gets the amount of electricity produced by the given members. If any of
	 * the given members are not members of this electricity network, an
	 * IllegalArgumentException is thrown. Likewise, if the list of members is
	 * null, an IllegalArgumentException is thrown
	 * 
	 * @param members The members to count electricity from
	 * @return The amount of electricity produced by given members
	 * @throws IllegalArgumentException If members is null or invalid
	 */
	IElectricityPacket getProducedBy(IEnergyNetworkMember... members);

	/**
	 * Gets the amount of electricity demanded by this electricity network,
	 * ignoring any electricity network members given in the ignored
	 * argument. If the argument is null, this will function as normal and
	 * return the amount of electricity demanded by the entire network, with no
	 * exclusions
	 * 
	 * @param excluded Electricity network members to exclude
	 * @return The amount of electricity this network demands minus that
	 *         demanded by members contained in excluded
	 */
	IElectricityPacket getDemand(IEnergyNetworkMember... ignored);

	IElectricityPacket onConsumption(IEnergyNetworkMember member);

	Map<IEnergyNetworkMember, IElectricityPacket> getProducers();

	Map<IEnergyNetworkMember, IElectricityPacket> getConsumers();

	Set<IElectricityConductor> getConductors();

	double getTotalResistance();

	double getMinimumContainedEnergy();

	void cleanup();

	void refresh();

	void merge(IElectricityNetwork other);

	void split(IEnergyNetworkMember point);
}
