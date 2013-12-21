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

import eu.veldsoft.twenty.eight.dummy.wxCloseEvent;
import eu.veldsoft.twenty.eight.dummy.wxCommandEvent;
import eu.veldsoft.twenty.eight.dummy.wxSizeEvent;
import eu.veldsoft.twenty.eight.dummy.wxSplitterWindow;

public class raFrame {
	private wxSplitterWindow m_split_main;

	private raGamePanel m_game;

	private raInfo m_info;

	private boolean ShowPreferences() {
		// TODO To be done by ...

		return (false);
	}

	private boolean ShowRules() {
		// TODO To be done by ...

		return (false);
	}

	// Disallow copy finalructor/assignment operators
	private raFrame(final raFrame object) {
		// TODO To be done by ...
	}

	raFrame assign(final raFrame object) {
		// TODO To be done by ...

		return (this);
	}

	// Constructor
	public raFrame(final String title) {
		// TODO To be done by ...
	}

	// Event handlers
	public void OnQuit(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnAbout(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnGameNew(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnClose(wxCloseEvent event) {
		// TODO To be done by ...
	}

	public void OnPreferences(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnRules(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnAuction(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnLastTrick(wxCommandEvent event) {
		// TODO To be done by ...
	}

	public void OnSize(wxSizeEvent event) {
		// TODO To be done by ...
	}

	public void OnUpdate(raUpdateEvent event) {
		// TODO To be done by ...
	}
}
