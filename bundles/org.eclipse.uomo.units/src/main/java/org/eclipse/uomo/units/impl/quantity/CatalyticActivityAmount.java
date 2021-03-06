/**
 * Copyright (c) 2005, 2013, Werner Keil, Ikayzo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil, Ikayzo and others - initial API and implementation
 */
package org.eclipse.uomo.units.impl.quantity;

import org.eclipse.uomo.units.impl.BaseAmount;
import org.unitsofmeasurement.quantity.CatalyticActivity;
import org.unitsofmeasurement.unit.Unit;

/**
 * Represents a catalytic activity.
 * The metric system unit for this quantity is "kat" (katal).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @version 1.3, $Date: 2013-04-28 $
 */
public final class CatalyticActivityAmount extends BaseAmount<CatalyticActivity> {

	public CatalyticActivityAmount(Number number, Unit<CatalyticActivity> unit) {
		super(number, unit);
	}
}
