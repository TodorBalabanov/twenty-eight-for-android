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

package eu.veldsoft.twenty.eight.ra;

import eu.veldsoft.twenty.eight.dummy.wxEvent;

public class raBidEvent extends wxEvent {
	private int m_bid;

	// Disallow copy assignment operator
	private raBidEvent assign(final raBidEvent object) {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (this);
	}

	// Default finalructor.
	public raBidEvent() {
		//TODO To be done by INFM032 F___94 Aleksandar Milev ...
		//TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
	}

	public raBidEvent(final raBidEvent evt) {
		//TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM042 F___88 Ivan Dankinov ...
		//TODO To be done by INFM042 F___39 Shterion Yanev ...
	}

	public wxEvent Clone() {
		return new raBidEvent(this);
	}

	/**
	 * Setter.
	 * 
	 * @param bid
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 18 Oct 2013
	 */
	public void SetBid(int bid) {
		m_bid = bid;
	}

	/**
	 * Constructor.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 18 Oct 2013
	 */
	public int GetBid() {
		return (m_bid);
	}
}
