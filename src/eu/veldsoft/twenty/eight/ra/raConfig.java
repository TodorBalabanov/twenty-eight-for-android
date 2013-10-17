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

import eu.veldsoft.twenty.eight.dummy.wxConfig;
import eu.veldsoft.twenty.eight.dummy.wxMutex;

public class raConfig {

	private static raConfig s_instance;

	private static wxMutex s_mutex;

	private wxConfig m_config;

	private raConfData m_data;

	private static void Create() {
		// TODO To be done by Venci
	}

	private static void SetDefaultValues(raConfData data) {
		// TODO To be done by Venci
	}

	// Disallow copy finalructor/assignment operators
	private raConfig(final raConfig object) {
		// TODO To be done by ...
	}

	private raConfig assign(final raConfig object) {
		// TODO To be done by ...

		return (this);
	}

	private raConfig() {
		// TODO To be done by ...
	}

	private boolean Load() {
		// TODO To be done by ...

		return (false);
	}

	public static raConfig GetInstance() {
		// TODO To be done by ...

		return (null);
	}

	public boolean Save() {
		// TODO To be done by ...

		return (false);
	}

	public void GetData(raConfData data) {
		// TODO To be done by Venci
		
	}

	public boolean SetData(raConfData data) {
		// TODO To be done by ...

		return (false);
	}

	protected void finalize() {
		// TODO To be done by ...
	}
}
