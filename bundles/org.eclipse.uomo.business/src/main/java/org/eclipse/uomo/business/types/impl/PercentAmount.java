package org.eclipse.uomo.business.types.impl;

import static org.eclipse.uomo.business.types.BDTHelper.Operation.*;
import org.eclipse.uomo.business.types.BDTHelper;
import org.eclipse.uomo.business.types.IBDType;
import org.eclipse.uomo.business.types.Percent;
import org.eclipse.uomo.units.impl.BaseAmount;
import org.unitsofmeasurement.unit.Unit;

import com.ibm.icu.math.BigDecimal;

/**
 * This class describes Percent amounts
 * 
 * @author paul.morrison
 */
public class PercentAmount extends BaseAmount<Percent> implements IBDType {
	final static long serialVersionUID = 362498820763181265L;

	int m_precision = 15; // will be held, but not set

	PercentAmount(char[] c, Unit<Percent> unit) {
		super(new BigDecimal(c), unit);
	}

	public PercentAmount(BigDecimal bd, Unit<Percent> unit) {
		super(bd, unit);
	}

	public PercentAmount(String s, Unit<Percent> unit) {
		this((CalcPercent(s)), unit);
	}

	/**
	 * Calculate a BigDecimal value for a Percent e.g. "3" (3 percent) will
	 * generate an array containing .03
	 * 
	 * @return java.math.BigDecimal
	 * @param s
	 *            java.lang.String
	 */
	static BigDecimal CalcPercent(String s) {

		BigDecimal temp = new BigDecimal("100"); //$NON-NLS-1$
		BigDecimal temp2 = new BigDecimal(s);
		return temp2.divide(temp, BDTHelper.MATH_CONTEXT); // we now have .03

	}

	/**
	 * Check if quantity is positive (>0)
	 * 
	 * @return boolean
	 */
	public boolean isPositive() {
		return +1 == ((BigDecimal)getNumber()).compareTo(BigDecimal.ZERO);
	}

	/**
	 * Compare to see if <code> this </code> Percent amount is equal to
	 * parameter
	 * 
	 * @return boolean
	 * @param y
	 *            com.jpmorrsn.jbdtypes.Percent - second Percent
	 */
	public boolean eq(PercentAmount y) {
		return BDTHelper.comp(this, y, EQ);
	}

	/**
	 * Compare to see if <code> this </code> Percent amount is greater than or
	 * equal to parameter
	 * 
	 * @return boolean
	 * @param y
	 *            com.jpmorrsn.jbdtypes.Percent - second Percent
	 */
	public boolean ge(PercentAmount y) {
		return BDTHelper.comp(this, y, GE);
	}

	/**
	 * Compare to see if <code> this </code> Percent amount is greater than
	 * parameter
	 * 
	 * @return boolean
	 * @param y
	 *            com.jpmorrsn.jbdtypes.Percent - second Percent
	 */
	public boolean gt(PercentAmount y) {
		return BDTHelper.comp(this, y, GT);
	}

	/**
	 * Compare to see if <code> this </code> Percent amount is less or equal to
	 * parameter
	 * 
	 * @return boolean
	 * @param y
	 *            com.jpmorrsn.jbdtypes.Percent - second Percent
	 */
	public boolean le(PercentAmount y) {
		return BDTHelper.comp(this, y, LE);
	}

	/**
	 * Compare to see if <code> this </code> Percent amount is less than
	 * parameter
	 * 
	 * @return boolean
	 * @param y
	 *            com.jpmorrsn.jbdtypes.Percent - second Percent
	 */
	public boolean lt(PercentAmount y) {
		return BDTHelper.comp(this, y, LT);
	}

	/**
	 * Compare to see if <code> this </code> Percent amount is not equal to
	 * parameter
	 * 
	 * @return boolean
	 * @param y
	 *            com.jpmorrsn.jbdtypes.Percent - second Percent
	 */
	public boolean ne(PercentAmount y) {
		return BDTHelper.comp(this, y, NE);
	}

	/**
	 * Generate a 'preference neutral' string from Percent value.
	 * 
	 * @return java.lang.String
	 */
	public String serialize() {
		BigDecimal temp = (BigDecimal) getNumber();
		temp = temp.multiply(BigDecimal.TEN, BDTHelper.MATH_CONTEXT);
		temp = temp.multiply(BigDecimal.TEN, BDTHelper.MATH_CONTEXT);
		temp = temp.divide(BigDecimal.ONE, BDTHelper.MATH_CONTEXT);
		return temp.toString();

	}

	/**
	 * Create a String from this object
	 * 
	 * @return java.lang.String
	 */
	public String toString() {
		return serialize();
	}
}