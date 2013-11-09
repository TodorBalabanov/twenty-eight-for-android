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

import eu.veldsoft.twenty.eight.gm.gmEngine;
import eu.veldsoft.twenty.eight.gm.gmEngineData;
import eu.veldsoft.twenty.eight.gm.gmRules;
import eu.veldsoft.twenty.eight.gm.gmUtil;

public class aiAgent {
	public static final int aiBID_SAMPLE = 100;

	public static final int aiPLAY_SAMPLES = 30;

	public static final int aiMAX_MOVES = 20;

	public static final int aiGENMV_NOTRUMP = 1;

	public static final int aiGENMV_TRUMP = 2;

	public static final int aiGENMV_ALL = 3;

	public static final int aiPOS_INFTY = +10000;

	public static final int aiNEG_INFTY = -10000;

	private final static int s_depths[] = { 2, 3, 4, 6, 7, 8, 8, 8 };;

	private gmEngine m_engine;

	private int m_loc;

	private long m_trump_cards;

	private long m_notrump_suspects;

	private long m_nulls[] = new long[gmUtil.gmTOTAL_PLAYERS];

	private long m_mb_null_susp;

	/**
	 * 
	 * @param elem1
	 * @param elem2
	 * @return
	 * 
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM042 F___48 Georgi Ivanov
	 */
	private static int CompareMoves(final Object elem1, final Object elem2) {
		aiMove move1, move2;
		move1 = (aiMove) elem1;
		move2 = (aiMove) elem2;
		if (move1.rank > move2.rank) {
			return -1;
		} else if (move1.rank == move2.rank) {
			return 0;
		} else {
			return 1;
		}
	}

	// Disallow copy finalructor/assignment operators
	private aiAgent(final aiAgent object) {
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...
		// TODO To be done by INFM042 F___81 Marina Rangelova ...
	}

	private boolean EstimateTricks(long p_hands, int trump, int eval) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (false);
	}

	private boolean EstimatePoints(long hands, int trump, int trick_count,
			int eval) {
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...

		return (false);
	}

	private boolean GenerateMoves(gmEngine node, aiMove moves, int count) {
		GenerateMoves(node, moves, count, aiGENMV_ALL);

		return (false);
	}

	private boolean GenerateMoves(gmEngine node, aiMove moves, int count,
			int type) {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM032 F___52 Mihail Stankov ...

		return (false);
	}

	private boolean OrderMoves(gmEngine node, aiMove moves, int count) {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...

		return (false);
	}

	private boolean RankMove(gmEngineData data, aiMove move) {
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...

		return (false);
	}

	private int Evaluate(gmEngine node, int alpha, int beta, int depth,
			boolean ret_val) {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...

		return (0);
	}

	private int EstimateHeuristic(gmEngine state) {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...

		return (0);
	}

	private boolean MakeMove(gmEngine node, aiMove move) {
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...

		return (false);
	}

	private boolean MakeMoveAndEval(gmEngine node, aiMove move, int depth,
			int eval) {
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...

		return (false);
	}

	protected void finalize() {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
	}

	/**
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM042 F___46 Nadya Nedyalkova
	 * @author INFM042 F___68 Georgi Srebrov
	 */
	public aiAgent() {
		// TODO : Remove hardcoding
		m_loc = 0;
		Reset();
	}

	/**
	 * Set location.
	 * 
	 * @param loc
	 * 
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___90 Svetoslav Slavkov
	 */
	public void SetLocation(int loc) {
		m_loc = loc;
	}

	public int GetLocation() {
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...

		return (0);
	}

	public boolean GetBid(long cards, int bid, int trump, int min,
			boolean force_bid) {
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (false);
	}

	public boolean GetBid(int bid, int trump, int min, boolean force_bid) {
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (false);
	}

	public boolean SetRuleEngineData(gmEngineData data) {
		// TODO To be done by INFM042 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...

		return (false);
	}

	public int GetTrump() {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...

		return (0);
	}

	public static int GetTrump(long hand, int suit) {
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...

		return (0);
	}

	public int GetPlay(long mask) {
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return (0);
	}

	public boolean GenerateSLProblem(gmEngineData data, slProblem problem,
			int played[][], int trump, boolean add_trump) {
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM042 F___45 Valentin Popov ...

		return (false);
	}

	public boolean GenerateDeals(gmEngineData data, long deals, int count) {
		GenerateDeals(data, deals, count, gmUtil.gmSUIT_INVALID);

		return (false);
	}

	public boolean GenerateDeals(gmEngineData data, long deals, int count,
			int trump) {
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___52 Mihail Stankov ...

		return (false);
	}

	public static String PrintMoves(aiMove moves, int move_count) {
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...

		return ("");
	}

	public boolean PostPlayUpdate(gmEngineData data) {
		PostPlayUpdate(data, gmUtil.gmCARD_INVALID);

		return (false);
	}

	public boolean PostPlayUpdate(gmEngineData data, int card) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___39 Shterion Yanev ...

		return (false);
	}

	public boolean CheckAssumptions(gmEngineData data) {
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...

		return (false);
	}

	public boolean Reset() {
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...

		return (false);
	}

	public void SetRules() {
		SetRules(null);
	}

	public void SetRules(gmRules rules) {
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
	}

	public boolean SetClockwise(boolean flag) {
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...

		return (false);
	}

	public boolean GetClockwise() {
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...

		return (false);
	}

	public boolean AbandonGame(boolean flag) {
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (false);
	}
}
