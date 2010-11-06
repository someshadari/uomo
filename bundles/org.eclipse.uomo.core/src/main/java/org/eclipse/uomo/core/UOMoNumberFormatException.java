/*******************************************************************************
 * Copyright (c) 2010, Copyright (c) 2010 Creative Arts & Technologies.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Werner Keil, Creative Arts & Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.uomo.core;

/**
 * @author Werner Keil
 * @version 1.2, $Date: 2010-08-22 23:13:45 +0200 (So, 22 Aug 2010) $
 */
public class UOMoNumberFormatException extends NumberFormatException {

	private static final long serialVersionUID = 5056915330109108078L;

	public enum Kind {
		TEXT_FORMAT, NaN, PINF, NINF, SIZE, RULE, INTERNAL
		// shouldn't ever happen
	}

	private final Kind kind;

	/**
	 * @param arg0
	 */
	public UOMoNumberFormatException(Kind kind, String msg) {
		super(msg);
		this.kind = kind;
	}

	public String getMessageForKind() {
		return getMessageForKind(kind);
	}

	public static String getMessageForKind(Kind kind) {
		return Messages.getString("UOMoNumberFormatException." + kind.name()); //$NON-NLS-1$		}
	}

	/**
	 * @return the kind
	 */
	public Kind getKind() {
		return kind;
	}

}
