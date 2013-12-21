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
import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.dummy.wxLog;
import eu.veldsoft.twenty.eight.dummy.wxLogStderr;

public class  raApp {
	private FILE m_logfile;

	private wxLogStderr m_logger;

	private wxLog m_old_logger;

	private raUpdate m_update;

	private raFrame m_frame;

	// Disallow copy finalructor/assignment operators

	/**
	 * 
	 * @param object
	 * @return
	 * @author INFM042 F___52 Mihail Stankov
	 * @author INFM042 F___39 Shterion Yanev
	 * @author INFM032 F___56 Daniel Nikolov
	 */
	private raApp assign(final raApp object) {
		return (this);
	}

	public static String GenerateLogFileName() {
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...

		return ("");
	}

	/**
	 * 
	 * @author INFM032 F___14 Petya Atanasova
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM042 F___06 Rosen Kaplanov
	 */
	public static void LogDetailsForDebug() {
		String out = "";
		Globals.wxLogMessage("Program              : "
				+ Globals.RA_APP_FULL_NAME);
		Globals.wxLogMessage("Date of compilation  : " + Globals.__DATE__
				+ Globals.__TIME__);

		if (Globals.__GNUC__ != null) {
			out = "";
			out += "Compiler             : GNU C/C++ ";
			out += "" + Globals.__GNUC__ + "." + Globals.__GNUC_MINOR__ + "";
			Globals.wxLogMessage(out);
		}

		out = "";
		out += "Operating System     : ";
		out += Globals.wxGetOsDescription();
		if (Globals.wxIsPlatform64Bit() == true) {
			out += "(64 bit)";
		}
		Globals.wxLogMessage(out);

		out = "";
		out += "Endianness           : ";
		if (Globals.wxIsPlatform64Bit() == true) {
			out += "Little Endian";
		} else {
			out += "Big Endian";
		}
		Globals.wxLogMessage(out);
		Globals.wxLogMessage("");
	}

	// Called on application startup
	public boolean OnInit() {
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...

		return (false);
	}

	public int OnRun() {
		// TODO To be done by INFM042 F___39 Shterion Yanev ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...

		return (0);
	}

	public int OnExit() {
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (0);
	}
}
