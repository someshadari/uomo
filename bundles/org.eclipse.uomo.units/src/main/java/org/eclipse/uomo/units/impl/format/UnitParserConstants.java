/**
 * Copyright (c) 2005, 2010, Werner Keil, Ikayzo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil, Ikayzo and others - initial API and implementation
 */
/* Generated By:JavaCC: Do not edit this line. UnitParserConstants.java */
package org.eclipse.uomo.units.impl.format;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
interface UnitParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int DIGIT = 1;
  /** RegularExpression Id. */
  int SUPERSCRIPT_DIGIT = 2;
  /** RegularExpression Id. */
  int INITIAL_CHAR = 3;
  /** RegularExpression Id. */
  int EXTENDED_CHAR = 4;
  /** RegularExpression Id. */
  int PLUS = 5;
  /** RegularExpression Id. */
  int MINUS = 6;
  /** RegularExpression Id. */
  int ASTERISK = 7;
  /** RegularExpression Id. */
  int MIDDLE_DOT = 8;
  /** RegularExpression Id. */
  int SOLIDUS = 9;
  /** RegularExpression Id. */
  int CARET = 10;
  /** RegularExpression Id. */
  int COLON = 11;
  /** RegularExpression Id. */
  int OPEN_PAREN = 12;
  /** RegularExpression Id. */
  int CLOSE_PAREN = 13;
  /** RegularExpression Id. */
  int INTEGER = 14;
  /** RegularExpression Id. */
  int SUPERSCRIPT_INTEGER = 15;
  /** RegularExpression Id. */
  int FLOATING_POINT = 16;
  /** RegularExpression Id. */
  int LOG = 17;
  /** RegularExpression Id. */
  int NAT_LOG = 18;
  /** RegularExpression Id. */
  int E = 19;
  /** RegularExpression Id. */
  int UNIT_IDENTIFIER = 20;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<DIGIT>",
    "<SUPERSCRIPT_DIGIT>",
    "<INITIAL_CHAR>",
    "<EXTENDED_CHAR>",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"\\u00b7\"",
    "\"/\"",
    "\"^\"",
    "\":\"",
    "\"(\"",
    "\")\"",
    "<INTEGER>",
    "<SUPERSCRIPT_INTEGER>",
    "<FLOATING_POINT>",
    "<LOG>",
    "<NAT_LOG>",
    "\"e\"",
    "<UNIT_IDENTIFIER>",
  };

}
