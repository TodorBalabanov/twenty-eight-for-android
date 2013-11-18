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

package eu.veldsoft.twenty.eight.ai;

public class slData {
	public slCell cells[][] = new slCell[aiSuitLengthSolver.slTOTAL_HANDS][aiSuitLengthSolver.slTOTAL_SUITS];

	public int suit_total_length[] = new int[aiSuitLengthSolver.slTOTAL_SUITS];

	public int hand_total_length[] = new int[aiSuitLengthSolver.slTOTAL_HANDS];

	public int suit_allocated[] = new int[aiSuitLengthSolver.slTOTAL_SUITS];

	public int hand_allocated[] = new int[aiSuitLengthSolver.slTOTAL_HANDS];

	public int suit_sum_of_maxs[] = new int[aiSuitLengthSolver.slTOTAL_SUITS];

	public int hand_sum_of_maxs[] = new int[aiSuitLengthSolver.slTOTAL_HANDS];

	// This is not really the sum of min values.
	// It is the sum of min values of vacant cells
	public int suit_sum_of_vacant_mins[] = new int[aiSuitLengthSolver.slTOTAL_SUITS];

	public int hand_sum_of_vacant_mins[] = new int[aiSuitLengthSolver.slTOTAL_HANDS];
}
