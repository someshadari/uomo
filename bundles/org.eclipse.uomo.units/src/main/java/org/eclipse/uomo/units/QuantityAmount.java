/**
 * Copyright (c) 2005, 2011, Werner Keil, Ikayzo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil, Ikayzo and others - initial API and implementation
 */
package org.eclipse.uomo.units;

import java.math.BigDecimal;
import java.math.MathContext;

import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

import com.ibm.icu.util.Measure;
import com.ibm.icu.util.MeasureUnit;

/**
 * An amount of quantity, consisting of a Number and a Unit.
 * QuantityAmount objects are immutable.
 *
 * @see java.lang.Number
 * @see MeasureUnit
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @param <Q> The type of the quantity.
 * @version 1.3 ($Revision: 212 $), $Date: 2011-09-12 01:20:44 +0200 (Mo, 12 Sep 2011) $
 * XXX rename to Amount or MeasureAmount?
 * FIXME  Bug 338334 overwrite equals()
 */
public abstract class QuantityAmount<Q extends Quantity<Q>> extends Measure implements IMeasure<Q> {
	@Override
	public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
		if (this.getClass() == obj.getClass()) {
			return super.equals(obj);
		} else {
			if (obj instanceof Measure) {
				Measure m = (Measure)obj;
				if (m.getNumber().getClass() == this.getNumber().getClass() && 
						m.getUnit().getClass() == this.unit().getClass()) {
					return super.equals(obj);
				} else {
//					if (this.getQuantityUnit() instanceof AbstractUnit<?>) {
//						if 
//					}
					return super.equals(obj);
				}
			}
			return false;
		}
	}

	/**
     * Indicates if this measure is exact.
     */
    private boolean isExact;

    /**
     * Holds the exact value (when exact) stated in this measure unit.
     */
//    private long _exactValue;

    /**
     * Holds the minimum value stated in this measure unit.
     * For inexact measures: _minimum < _maximum 
     */
//    private double _minimum;

    /**
     * Holds the maximum value stated in this measure unit.
     * For inexact measures: _maximum > _minimum 
     */
//    private double _maximum;
    
	protected QuantityAmount(Number number, MeasureUnit unit) {
		super(number, unit);
	}

    /**
     * Returns the value of this quantity as <code>double</code> stated
     * in the specified unit. This method is recommended over <code>
     * q.getUnit().getConverterTo(unit).convert(q.getNumber()).doubleValue()</code>
     *
     * @param unit the unit in which the returned value is stated.
     * @return the value of this quantity when stated in the specified unit.
     */
    public double doubleValue(Unit<Q> unit) {
    	Unit<Q> myUnit = unit();
    	try {
			UnitConverter converter = unit.getConverterTo(myUnit);
			return converter.convert(getNumber().doubleValue());
		} catch (UnconvertibleException e) {
			throw e;
		} //catch (IncommensurableException e) {
//			throw new IllegalArgumentException(e.getMessage());
//		}
    }
    
    /**
     * Returns the value of this quantity as <code>long</code> stated
     * in the specified unit. This method is recommended over <code>
     * q.getUnit().getConverterTo(unit).convert(q.getNumber()).longValue()</code>
     *
     * @param unit the unit in which the returned value is stated.
     * @return the value of this quantity when stated in the specified unit.
     */
    public long longValue(Unit<Q> unit) {
    	Unit<Q> myUnit = unit();
    	try {
			UnitConverter converter = unit.getConverterToAny(myUnit);
			return (converter.convert(BigDecimal.valueOf(getNumber().longValue()), MathContext.DECIMAL128)).longValue();
		} catch (UnconvertibleException e) {
			throw e;
		} catch (IncommensurableException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
    }
    
    /**
     * Get the unit (convenience to avoid cast).
     * @draft UOMo 0.6
     * @provisional This API might change or be removed in a future release.
     */
    public Unit<Q> unit() {
    	return internalUnit();
    }
    
    /**
     * Indicates if this measure amount is exact. An exact amount is 
     * guarantee exact only when stated in this measure unit
     * (e.g. <code>this.longValue()</code>); stating the amount
     * in any other unit may introduce conversion errors. 
     *
     * @return <code>true</code> if this measure is exact;
     *         <code>false</code> otherwise.
     */
    public boolean isExact() {
        return isExact;
    }
    
    /**
     * Get the unit (convenience to avoid cast).
     * @provisional This API might change or be removed in a future release.
     */
    @SuppressWarnings("unchecked")
	private final AbstractUnit<Q> internalUnit() {
    	return (AbstractUnit<Q>) super.getUnit();
    }
}
