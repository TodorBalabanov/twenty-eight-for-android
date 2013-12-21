/*******************************************************************************
 *                                                                             *
 * Twenty-Eight for Android is port of popular Asian card game called Rosanne: *
 * Twenty-eight (28) <http://sourceforge.net/projects/rosanne/>. Project       *
 * development is done as NBU Java training course held in Sofia, Bulgaria.    *
 *                                                                             *
 * Copyright (C) 2013-2014 by Todor Balabanov  ( tdb@tbsoft.eu )               *
 *                                                                             *
 * This program is free software: you can redistribute it and/or modify        *
 * it under the terms of the GNU General Public License as published by        *
 * the Free Software Foundation, either version 3 of the License, or           *
 * (at your option) any later version.                                         *
 *                                                                             *
 * This program is distributed in the hope that it will be useful,             *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of              *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the               *
 * GNU General Public License for more details.                                *
 *                                                                             *
 * You should have received a copy of the GNU General Public License           *
 * along with this program. If not, see <http://www.gnu.org/licenses/>.        *
 *                                                                             *
 ******************************************************************************/

package eu.veldsoft.twenty.eight.gm;

/**
 * 
 * @author Vencislav Medarov
 * @email venci932@gmail.com
 * @date 13 Dec 2013
 */
public class  gmRules implements Cloneable {
	/**
	 * 
	 */
	public int rot_addn;

	/**
	 * 
	 */
	public int min_bid_1;

	/**
	 * 
	 */
	public int min_bid_2;

	/**
	 * 
	 */
	public int min_bid_3;

	/**
	 * 
	 */
	public boolean waive_rule_4;

	/**
	 * 
	 */
	public boolean sluff_jacks;

	/**
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 13 Dec 2013
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 13 Dec 2013
	 */
	public void setToZeros() {
		rot_addn = 0;
		min_bid_1 = 0;
		min_bid_2 = 0;
		min_bid_3 = 0;
		waive_rule_4 = false;
		sluff_jacks = false;
	}
}
