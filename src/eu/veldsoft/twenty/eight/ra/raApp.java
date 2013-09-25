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

import eu.veldsoft.twenty.eight.dummy.FILE;
import eu.veldsoft.twenty.eight.dummy.wxLog;
import eu.veldsoft.twenty.eight.dummy.wxLogStderr;

public class raApp {
	private FILE m_logfile;

	private wxLogStderr m_logger;

	private wxLog m_old_logger;

	private raUpdate m_update;

	private raFrame m_frame;

	// Disallow copy finalructor/assignment operators
	private raApp assign(final raApp object) {
		// TODO To be done by ...

		return (this);
	}

	public static String GenerateLogFileName() {
		// TODO To be done by ...

		return ("");
	}

	public static void LogDetailsForDebug() {
		// TODO To be done by ...
	}

	// Called on application startup
	public boolean OnInit() {
		// TODO To be done by ...

		return (false);
	}

	public int OnRun() {
		// TODO To be done by ...

		return (0);
	}

	public int OnExit() {
		// TODO To be done by ...

		return (0);
	}
}
