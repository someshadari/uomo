/*
 * Backport, stub for JavaMoney 
 */
package org.eclipse.uomo.business.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * This class models the type of a given exchange rate as immutable value type.
 * Basically the types possible are determined by the concrete use cases and
 * implementations. Typical use cases is that exchange rates for different
 * credit card systems or debit/credit may differ. This class allows to
 * distinguish these rates.
 * 
 * @author Werner Keil
 * @deprecated stub
 */
public final class ExchangeRateType implements Serializable,
Comparable<ExchangeRateType> {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -7505497771490888058L;
	/** The id of this type. */
	private final String id;
	/** The cache of types. */
	private static final Map<String, ExchangeRateType> CACHED_INSTANCES = new ConcurrentHashMap<String, ExchangeRateType>();

	/**
	 * Creates a new instance.
	 * 
	 * @param id
	 *            The rate identifier.
	 * @return The new rate type.
	 */
	public static ExchangeRateType of(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id required.");
		}
		ExchangeRateType instance = CACHED_INSTANCES.get(id);
		if (instance == null) {
			instance = new ExchangeRateType(id);
			CACHED_INSTANCES.put(id, instance);
		}
		return instance;
	}

	/**
	 * Get all cached rate types.
	 * 
	 * @return all cached rate types.
	 */
	public static Collection<ExchangeRateType> getTypes() {
		return CACHED_INSTANCES.values();
	}

	/**
	 * Constructs a new instance of an ExchangeRateType..
	 * 
	 * @param id
	 *            The id of this type instance, never null.
	 */
	public ExchangeRateType(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Id must not be null.");
		}
		this.id = id;
	}

	/**
	 * Get the identifier of this instance.
	 * 
	 * @return The identifier, never null.
	 */
	public String getId() {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExchangeRateType other = (ExchangeRateType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExchangeRateType [id=" + id + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ExchangeRateType o) {
		if (o == null) {
			return -1;
		}
		int compare = id.compareTo(o.id);
		return compare;
	}

}
