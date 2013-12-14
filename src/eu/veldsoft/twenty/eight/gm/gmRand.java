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

public class gmRand {
	private static int[] psfmt32;

	private static int idxof(int i) {

		return 0;
	}

	public static String PrintState() {
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...

		return ("");
	}

	public static void GetState(gmRandState state) {
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
	}

	/**
	 * 
	 * @param state
	 * 
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM032 F___52 Mihail Stankov
	 */
	public static void SetState(gmRandState state) {

		int i = 0;
		for (i = 0; i < 32; i++) {
			psfmt32[idxof(i)] = state.state_array[i];
			int idx = state.idx;
		}
	}

}
