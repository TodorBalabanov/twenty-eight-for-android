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

	private String __FILE__;

	private int __LINE__;

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

	/**
	 * 
	 * @param object
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM032 F___90 Svetoslav Slavkov
	 */
	private aiSuitLengthSolver assign(final aiSuitLengthSolver object) {

		return (this);
	}

	/**
	 * 
	 * @param data
	 * 
	 * @author INFM042 F___94 Aleksandar Milev ...
	 * @author INFM032 F___46 Nadya Nedyalkova ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 */
	private void InitializeWorkingData(slData data) {
		/*
		 * Problem is initialized by setting suit lengths for all spots as
		 * vacant and setting the total length for all hands and suits as zero.
		 */
		data.setToZero();

		for (int i = 0; i < slTOTAL_HANDS; i++) {
			for (int j = 0; j < slTOTAL_SUITS; j++) {
				data.cells[i][j].suit_length = slVACANT;
			}
		}

		return;
	}

	/**
	 * 
	 * @param data
	 * @param hand
	 * @param suit
	 * 
	 * @return
	 * 
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM042 F___46 Nadya Nedyalkova ...
	 * @author INFM042 F___68 Georgi Srebrov ...
	 */
	private boolean RecalcCellMax(slData data, int hand, int suit) {
		assert (data != null);
		assert (hand < slTOTAL_HANDS);
		assert (suit < slTOTAL_SUITS);
		assert (data.cells[hand][suit].suit_length == slVACANT);

		int h = (data.hand_total_length[hand] - data.hand_allocated[hand]
				- data.hand_sum_of_vacant_mins[hand] + data.cells[hand][suit].min);
		assert (h >= 0);
		int s = (data.suit_total_length[suit] - data.suit_allocated[suit]
				- data.suit_sum_of_vacant_mins[suit] + data.cells[hand][suit].min);
		assert (s >= 0);

		/*
		 * Store the old max value.
		 */
		int old_max = data.cells[hand][suit].max;

		/*
		 * Compute the new max value.
		 */
		int new_max = Math.min(h, s);
		assert ((new_max <= old_max) || (old_max == 0));

		data.cells[hand][suit].max = new_max;

		/*
		 * If the new max value is different from the older one, then the sum of
		 * max values for the hand and the suit has to be corrected
		 */
		if (new_max != old_max) {
			data.hand_sum_of_maxs[hand] -= (old_max - new_max);
			data.suit_sum_of_maxs[suit] -= (old_max - new_max);
			return true;
		}

		return false;
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
			Globals.wxLogDebug(
					"Entering aiSuitLengthSolver::SetCell (%d, %d) = %d", hand,
					suit, suit_length);
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

	/**
	 * 
	 * @param data
	 * @param hand
	 * @param suit
	 * 
	 * @return
	 * 
	 * @author INFM032 F___94 Aleksandar Milev
	 * @author INFM042 F___90 Svetoslav Slavkov
	 * @author INFM042 F___68 Nikola Vushkov
	 */
	private boolean RecalcMaxForImpactedCells(slData data, int hand, int suit) {
		assert (data != null);
		assert (hand < Globals.slTOTAL_HANDS);
		assert (suit < Globals.slTOTAL_SUITS);

		if (Globals.slLOG_DEBUG_SETIMPCELLS == true) {
			Globals.wxLogDebug(
					"Entering aiSuitLengthSolver::RecalcMaxForImpactedCells for (%d, %d)",
					hand, suit);
			Globals.wxLogDebug("Data : %s", (String) PrintData(data));
		}

		/*
		 * Recalculate the max for all the affected cells Recalculate the max
		 * for all cell in hand.
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
		 * Recalculate the max for all cell in suit.
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

	/**
	 * 
	 * @param data
	 * @param hand
	 * @param suit
	 * 
	 * @return
	 * 
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM032 F___52 Mihail Stankov
	 * @author INFM032 F___46 Nadya Nedyalkova
	 */
	private boolean RecalcMinForImpactedCells(slData data, int hand, int suit) {
		assert (data != null);
		assert (hand < slTOTAL_HANDS);
		assert (suit < slTOTAL_SUITS);

		if (Globals.slLOG_DEBUG_SETIMPCELLS == true) {
			Globals.wxLogDebug(
					"Entering aiSuitLengthSolver::RecalcMinForImpactedCells for (%d, %d)",
					hand, suit);
			Globals.wxLogDebug("Data : %s", PrintData(data));
		}

		/*
		 * Recalculate the min for all the affected cells Recalculate the min
		 * for all cell in hand
		 */
		for (int i = 0; i < Globals.slTOTAL_SUITS; i++) {
			/*
			 * Avoid recalculating for the cell for which data is being set and
			 * for non-vacant cells.
			 */
			if (data.cells[hand][i].suit_length == Globals.slVACANT) {
				if (RecalcCellMin(data, hand, i) == true) {
					RecalcMaxForImpactedCells(data, hand, i);
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
				if (RecalcCellMin(data, i, suit) == true) {
					RecalcMaxForImpactedCells(data, i, suit);
				}
			}
		}

		return (true);
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

	/**
	 * 
	 * @param data
	 * @param changed
	 * @return
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM042 F___14 Petya Atanasova
	 * @author INFM042 F___06 Rosen Kaplanov
	 */
	private boolean RecalcMinForAllCells(slData data, boolean changed) {
		assert (data != null);

		/*
		 * Reset the sum of min values for all hands and suits Calculate min for
		 * all cells At the same time, calculate the sum of mins for the hand
		 */
		for (int i = 0; i < Globals.slTOTAL_HANDS; i++) {
			for (int j = 0; j < Globals.slTOTAL_SUITS; j++) {

				/*
				 * If the suit length for a cell is fixed, then min has already
				 * been calculated.
				 */
				if (data.cells[i][j].suit_length == Globals.slVACANT) {
					RecalcCellMin(data, i, j);
					assert ((data.cells[i][j].min >= 0) && (data.cells[i][j].min <= Globals.slLENGTH_MAX));
					/*
					 * If the min for a vacant cell is not zero, add that to the
					 * sum of mins for vacant cells
					 */
				}
			}
		}

		return (true);
	}

	/**
	 * 
	 * @param data
	 * 
	 * @return
	 * 
	 * @author INFM032 F___67 Nevena Sirakova
	 * @author INFM032 F___05 Iliya Grozev
	 * @author INFM032 F___93 Krasimir Chariyski
	 */
	private boolean RecalcMaxForAllCells(slData data) {
		int i = 0;
		int j = 0;

		assert (data != null);

		/*
		 * Calculate max for each cell This also calculates the sum of maxes for
		 * all hands and suits internally
		 */
		for (i = 0; i < slTOTAL_HANDS; i++) {
			for (j = 0; j < slTOTAL_SUITS; j++) {
				/*
				 * If the suit length for a cell is fixed, then max has already
				 * been calculated.
				 */

				if (data.cells[i][j].suit_length == slVACANT) {
					RecalcCellMax(data, i, j);
				}
			}
		}

		return true;
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

	/**
	 * 
	 * @param problem
	 * @author INFM042 F___67 Nevena Sirakova ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM042 F___84 Mariya Kostadinova ...
	 */
	public static void InitializeProblem(slProblem problem) {
		/*
		 * Problem is initialized by setting suit lengths for all spots as
		 * vacant and setting the total length for all hands and suits as zero.
		 */
		problem.setToZero();

		for (int i = 0; i < slTOTAL_HANDS; i++) {
			for (int j = 0; j < slTOTAL_SUITS; j++) {
				problem.suit_length[i][j] = slVACANT;
			}
		}
	}

	/**
	 * 
	 * @param played
	 * 
	 * @author INFM042 F___81 Marina Rangelova ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM032 F___67 Nevena Sirakova ...
	 */
	public static void InitializePlayed(int[][] played) {
		/*
		 * Played is initialized by setting suit lengths for all spots as zero
		 * and setting the total length for all hands and suits also as zero.
		 */
		for (int i = 0; i < played.length; i++) {
			for (int j = 0; j < played[i].length; j++) {
				played[i][j] = 0;
			}
		}
	}

	/**
	 * 
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM032 F___88 Ivan Dankinov
	 * @author INFM042 F___46 Nadya Nedyalkova
	 */
	public aiSuitLengthSolver() {
	}
	
/**
 * 
 * @author INFM042 F___94 Aleksandar Milev
 * @author INFM032 F___46 Nadya Nedyalkova
 * @author INFM042 F___68 Nikola Vushkov
 */
	protected void finalize() {
	}

	/**
	 * 
	 * @author INFM032 F___90 Svetoslav Slavkov
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM032 F___67 Nevena Sirakova
	 */
	public boolean SetProblem(slProblem problem, int[][] played) {

		int i = 0;
		int j = 0;
		int[] hand_total_played = { 0, 0, 0, 0 };
		int[] suit_total_played = { 0, 0, 0, 0 };

		if (problem == null) {
			Globals.wxLogError(String
					.format("Input variable problem for aiSuitLengthSolver::SetProblem is NULL. %s:%d",
							__FILE__, __LINE__));
			return false;
		}
		if (played == null) {
			Globals.wxLogError(String
					.format("Input variable played for aiSuitLengthSolver::SetProblem is NULL. %s:%d",
							__FILE__, __LINE__));
			return false;
		}

		InitializeWorkingData(m_saved);

		// Create a copy of the problem
		System.arraycopy(problem, 0, m_problem, 0,
				problem.suit_total_length.length);
		System.arraycopy(m_problem, 0, problem, 0,
				m_problem.suit_total_length.length);

		// Check the sanity of data.
		// The array played contains the list of played cards.
		// The hand_total_length and suit_total_length arrays in problem contain
		// the list of cards to be allocatd.
		// Both added together for should be 8

		for (i = 0; i < slTOTAL_HANDS; i++) {
			for (j = 0; j < slTOTAL_SUITS; j++) {
				hand_total_played[i] += m_played[i][j];
				suit_total_played[j] += m_played[i][j];
			}
		}

		for (i = 0; i < slTOTAL_HANDS; i++) {
			if ((hand_total_played[i] + m_problem.hand_total_length[i]) != slLENGTH_MAX) {
				Globals.wxLogError(String
						.format("No of played cards and the cards to be set does not add up to slLENGTH_MAX for hand %d. %s:%d",
								i, __FILE__, __LINE__));
				Globals.wxLogError(String.format("hand_total_played[%d] = %d",
						i, hand_total_played[i]));
				Globals.wxLogError(String.format(
						"m_problem.hand_total_length[%d] = %d", i,
						m_problem.hand_total_length[i]));
				assert (false);
				return false;
			}
		}

		for (i = 0; i < slTOTAL_SUITS; i++) {
			if ((suit_total_played[i] + m_problem.suit_total_length[i]) != slLENGTH_MAX) {
				Globals.wxLogError(String
						.format("No of played cards and the cards to be set does not add up to slLENGTH_MAX for suit %d. %s:%d",
								i, __FILE__, __LINE__));
				Globals.wxLogError(String.format("suit_total_played[%d] = %d",
						i, suit_total_played[i]));
				Globals.wxLogError(String.format(
						"m_problem.suit_total_length[%d] = %d", i,
						m_problem.suit_total_length[i]));
				assert (false);
				return false;
			}
		}

		// Copy the status of each cell (which must be zero to slLENGTH_MAX or
		// slVACANT)

		for (i = 0; i < slTOTAL_HANDS; i++) {
			for (j = 0; j < slTOTAL_SUITS; j++) {
				assert ((m_problem.suit_length[i][j] == slVACANT) || ((m_problem.suit_length[i][j] >= 0) && (m_problem.suit_length[i][j] <= slLENGTH_MAX)));

				// SetCell(&m_saved, i, j, m_problem.suit_length[i][j]);
				m_saved.cells[i][j].suit_length = m_problem.suit_length[i][j];

				// If the suit length for the cell is fixed already
				// set max and min as the fixed value.

				if (m_problem.suit_length[i][j] != slVACANT) {
					m_saved.cells[i][j].max = m_problem.suit_length[i][j];
					m_saved.cells[i][j].min = m_problem.suit_length[i][j];

					// Adjust the sum of maxes
					m_saved.hand_sum_of_maxs[i] += m_saved.cells[i][j].max;
					m_saved.suit_sum_of_maxs[j] += m_saved.cells[i][j].max;

					// Adjust allocated cards
					m_saved.hand_allocated[i] += m_problem.suit_length[i][j];
					m_saved.suit_allocated[j] += m_problem.suit_length[i][j];
				}

			}
		}

		// Calc max for each cell
		// Zero or -1 will not affect alloc
		// Calculate sum of maxes
		// Calculate min
		System.arraycopy(m_problem.hand_total_length, 0,
				m_saved.hand_total_length, 0, m_saved.hand_total_length.length);
		System.arraycopy(m_problem.suit_total_length, 0,
				m_saved.suit_total_length, 0, m_saved.suit_total_length.length);

		// Calculate max for all cells
		// This also calculates the sum of maxes for all hands and suits
		// internally

		RecalcMaxForAllCells(m_saved);

		for (i = 0; i < slTOTAL_HANDS; i++) {
			for (j = 0; j < slTOTAL_SUITS; j++) {
				RecalcMinForImpactedCells(m_saved, i, j);
			}

		}
		return true;
	}

	/**
	 * 
	 * @param solution
	 * 
	 * @return
	 * 
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM032 F___84 Mariya Kostadinova
	 * @author INFM042 F___68 Georgi Srebrov
	 */

	public boolean GenerateRandomSolution(int[][] solution) {
		int i = 0;
		int j = 0;
		int fill = 0;

		if (solution == null) {
			return false;
		}
		System.arraycopy(m_saved, 0, m_working, 0, m_saved.cells.length);

		// /#if slLOG_DEBUG_GETRANDSOLN
		Globals.wxLogDebug("Problem :");
		Globals.wxLogDebug(PrintData(m_working));
		// /#endif

		for (i = 0; i < slTOTAL_HANDS; i++) {
			for (j = 0; j < slTOTAL_SUITS; j++) {
				// Fill only if the cell is vacant

				if (m_working.cells[i][j].suit_length == slVACANT) {
					// In a vacant cell, if max and min are the same, then that
					// is the only option.
					// No need to try to get a random number.

					if (m_working.cells[i][j].max == m_working.cells[i][j].min) {
						fill = m_working.cells[i][j].max;
					} else {
						fill = GenerateRandomFill(m_working.cells[i][j].min,
								m_working.cells[i][j].max);
					}
					// /#if slLOG_DEBUG_GETRANDSOLN
					Globals.wxLogDebug("Attempting to fill (%d, %d) with %d",
							i, j, fill);
					// /#endif
					SetCell(m_working, i, j, fill);
					// /#if slLOG_DEBUG_GETRANDSOLN
					Globals.wxLogDebug(PrintData(m_working));
					// /#endif
				}
			}
		}

		// Set the solution

		for (i = 0; i < slTOTAL_HANDS; i++) {
			for (j = 0; j < slTOTAL_SUITS; j++) {
				solution[i][j] = m_working.cells[i][j].suit_length;
			}
		}
		// /#if slLOG_DEBUG_GETRANDSOLN
		Globals.wxLogDebug(PrintMatrix(solution));
		// /#endif
		return true;

	}

	public String PrintSavedData() {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...

		return ("");
	}

	/**
	 * 
	 * @return
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___48 Georgi Ivanov
	 * @author INFM032 F___81 Marina Rangelova
	 */
	public String PrintWorkingData() {
		return aiSuitLengthSolver.PrintData(m_working);
	}
}
