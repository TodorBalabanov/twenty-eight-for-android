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

import eu.veldsoft.twenty.eight.dummy.Globals;

public class aiSuitLengthSolver {
	public static final int slLENGTH_MAX = 8;

	public static final int slTOTAL_HANDS = 4;

	public static final int slTOTAL_SUITS = 4;

	public static final int slVACANT = -1;

	private slProblem m_problem;

	private slData m_saved, m_working;

	private int[][] m_played;

	private int m_suit_sum_of_min[] = new int[slTOTAL_SUITS];

	private int m_hand_sum_of_min[] = new int[slTOTAL_HANDS];

	/**
	 * Disallow copy finalructor/assignment operators
	 * 
	 * @param object
	 * 
	 * @author INFM042 F___84 Mariya Kostadinova
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM032 F___45 Valentin Popov
	 */
	private aiSuitLengthSolver(final aiSuitLengthSolver object) {
		/*
		 * Empty body constructor.
		 */
	}

	private aiSuitLengthSolver assign(final aiSuitLengthSolver object) {
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...

		return (this);
	}

	private void InitializeWorkingData(slData data) {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
	}

	private boolean RecalcCellMax(slData data, int hand, int suit) {
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...

		return (false);
	}

	/**
	 * 
	 * @param data
	 * @param hand
	 * @param suit
	 * @param suit_length
	 * @return
	 * 
	 * @autor INFM042 F___45 Valentin Popov
	 * @autor INFM032 F___67 Nevena Sirakova
	 * @autor INFM042 F___39 Shterion Yanev
	 */
	private boolean SetCell(slData data, int hand, int suit, int suit_length) {

		if (Globals.slLOG_DEBUG_SETCELL == true) {
			// wxLogDebug(wxString::Format(wxT("Entering aiSuitLengthSolver::SetCell (%d, %d) = %d"),
			// hand, suit, val));
		}

		assert (data != null);
		assert (hand < Globals.slTOTAL_HANDS);
		assert (suit < Globals.slTOTAL_SUITS);

		assert ((suit_length >= 0) || (suit_length <= Globals.slLENGTH_MAX));

		/*
		 * SetCell should be recalculated only for vacant slots
		 */

		assert (data.cells[hand][suit].suit_length == Globals.slVACANT);

		/*
		 * Fix the suit length for the cell
		 */

		data.cells[hand][suit].suit_length = suit_length;

		/*
		 * As the max value for the cell is changing, correct the sum of maxes
		 * beforehand
		 */

		data.hand_sum_of_maxs[hand] -= (data.cells[hand][suit].max - suit_length);
		data.suit_sum_of_maxs[suit] -= (data.cells[hand][suit].max - suit_length);

		/*
		 * As the min value for the cell is changing, correct the sum of mins
		 * beforehand
		 */

		if (data.cells[hand][suit].min > 0) {
			data.hand_sum_of_vacant_mins[hand] -= data.cells[hand][suit].min;
			data.suit_sum_of_vacant_mins[suit] -= data.cells[hand][suit].min;
		}

		/*
		 * Fix the max and min as the same as the suit length
		 */

		data.cells[hand][suit].max = suit_length;
		data.cells[hand][suit].min = suit_length;

		/*
		 * val number of cards have been allocated from the hand and from the
		 * suit
		 */

		data.hand_allocated[hand] += suit_length;
		data.suit_allocated[suit] += suit_length;
		assert (data.hand_allocated[hand] <= data.hand_total_length[hand]);
		assert (data.suit_allocated[suit] <= data.suit_total_length[suit]);

		/*
		 * Recalculate the max for all the affected cells
		 */

		RecalcMaxForImpactedCells(data, hand, suit);
		RecalcMinForImpactedCells(data, hand, suit);

		return true;
	}

	private boolean RecalcMaxForImpactedCells(slData data, int hand, int suit) {
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...

		assert (data != null);
		assert (hand < Globals.slTOTAL_HANDS);
		assert (suit < Globals.slTOTAL_SUITS);

		if (Globals.slLOG_DEBUG_SETIMPCELLS == true) {
			// wxLogDebug("Entering aiSuitLengthSolver::RecalcMaxForImpactedCells for (%d, %d)",
			// hand, suit);
			// wxLogDebug("Data : %s", PrintData(data).c_str());
		}

		/*
		 * Recalculate the max for all the affected cells Recalculate the max
		 * for all cell in hand
		 */
		for (int i = 0; i < Globals.slTOTAL_SUITS; i++) {
			/*
			 * Avoid recalculating for the cell for which data is being set and
			 * for non-vacant cells.
			 */
			if (data.cells[hand][i].suit_length == Globals.slVACANT) {
				if (RecalcCellMax(data, hand, i) == true) {
					RecalcMinForImpactedCells(data, hand, i);
				}
			}
		}

		/*
		 * Recalculate the max for all cell in suit
		 */
		for (int i = 0; i < Globals.slTOTAL_HANDS; i++) {
			/*
			 * Avoid recalculating for the cell for which data is being set and
			 * for non-vacant cells.
			 */
			if (data.cells[i][suit].suit_length == Globals.slVACANT) {
				if (RecalcCellMax(data, i, suit) == true) {
					RecalcMinForImpactedCells(data, i, suit);
				}
			}
		}

		return true;
	}

	private boolean RecalcMinForImpactedCells(slData data, int hand, int suit) {
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...

		return (false);
	}

	/**
	 * 
	 * @param data
	 * @param hand
	 * @param suit
	 * 
	 * @return
	 * 
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM032 F___90 Svetoslav Slavkov
	 * @author INFM032 F___39 Shterion Yanev
	 */
	private boolean RecalcCellMin(slData data, int hand, int suit) {
		assert (data != null);
		assert (hand < slTOTAL_HANDS);
		assert (suit < slTOTAL_SUITS);
		assert (data.cells[hand][suit].suit_length == slVACANT);

		int i = data.hand_total_length[hand] - data.hand_sum_of_maxs[hand]
				+ data.cells[hand][suit].max;
		if (i < 0) {
			i = 0;
		}

		int j = data.suit_total_length[suit] - data.suit_sum_of_maxs[suit]
				+ data.cells[hand][suit].max;
		if (j < 0) {
			j = 0;
		}

		int old_min = data.cells[hand][suit].min;
		int new_min = Math.max(i, j);

		/*
		 * The new minimum should be equal to or more than the old minimum
		 */
		assert (new_min >= old_min);
		data.cells[hand][suit].min = new_min;

		/*
		 * If the new min is different from the old min, correct the sum of
		 * vacant mins
		 */
		if (new_min != old_min) {
			data.hand_sum_of_vacant_mins[hand] += (new_min - old_min);
			data.suit_sum_of_vacant_mins[suit] += (new_min - old_min);
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	private boolean RecalcMinForAllCells(slData data) {
		RecalcMinForAllCells(data, false);

		return (false);
	}

	private boolean RecalcMinForAllCells(slData data, boolean changed) {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...
		// TODO To be done by INFM042 F___06 Rosen Kaplanov ...

		return (false);
	}

	private boolean RecalcMaxForAllCells(slData data) {
		// TODO To be done by INFM032 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...

		return (false);
	}

	private int GenerateRandomFill(int min, int max) {
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (0);
	}

	public static String PrintData(slData data) {
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...

		return ("");
	}

	public static String PrintMatrix(int[][] matrix) {
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___39 Shterion Yanev ...

		return ("");
	}

	public static void InitializeProblem(slProblem problem) {
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
	}

	public static void InitializePlayed(int[][] played) {
		// TODO To be done by INFM042 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...
		// TODO To be done by INFM032 F___67 Nevena Sirakova ...
	}

	public aiSuitLengthSolver() {
		// TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
	}

	protected void finalize() {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
	}

	public boolean SetProblem(slProblem problem, int[][] played) {
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___39 Shterion Yanev ...
		// TODO To be done by INFM032 F___67 Nevena Sirakova ...

		return (false);
	}

	public boolean GenerateRandomSolution(int[][] solution) {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...

		return (false);
	}

	public String PrintSavedData() {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...

		return ("");
	}

	public String PrintWorkingData() {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...

		return ("");
	}
}
