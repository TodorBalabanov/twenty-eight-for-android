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
import eu.veldsoft.twenty.eight.dummy.Globals;

public class raInfoEvent extends wxEvent {
	private int m_cmd;

	// Disallow copy assignment operator
	private raInfoEvent assign(final raInfoEvent object) {
		// TODO To be done by ...

		return (this);
	}

	// Default finalructor.
	public raInfoEvent() {
		// TODO To be done by ...
	}

	/**
	 * Constructor.
	 * 
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 11.11.2013
	 */
	public raInfoEvent(final raInfoEvent evt) {
		SetEventType(Globals.raINFO_EVT);
		m_cmd = evt.m_cmd;
	}

	public wxEvent Clone() {
		// TODO To be done by ...

		return new raInfoEvent(this);
	}

	/**
	 * Set command.
	 * 
	 * @param cmd
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 02.11.2013
	 */
	public void SetCommand(int cmd) {
		m_cmd = cmd;
	}

	/**
	 * Get chosen command.
	 * 
	 * @param cmd
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 02.11.2013
	 */
	public int GetCommand() {
		return (m_cmd);
	}
}
