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

	private static int CompareMoves(final Object elem1, final Object elem2) {
		// TODO To be done by ...

		return (0);
	}

	// Disallow copy finalructor/assignment operators
	private aiAgent(final aiAgent object) {
		// TODO To be done by ...
	}

	private boolean EstimateTricks(long p_hands, int trump, int eval) {
		// TODO To be done by ...

		return (false);
	}

	private boolean EstimatePoints(long hands, int trump, int trick_count,
			int eval) {
		// TODO To be done by ...

		return (false);
	}

	private boolean GenerateMoves(gmEngine node, aiMove moves, int count) {
		GenerateMoves(node, moves, count, aiGENMV_ALL);

		return (false);
	}

	private boolean GenerateMoves(gmEngine node, aiMove moves, int count,
			int type) {
		// TODO To be done by ...

		return (false);
	}

	private boolean OrderMoves(gmEngine node, aiMove moves, int count) {
		// TODO To be done by ...

		return (false);
	}

	private boolean RankMove(gmEngineData data, aiMove move) {
		// TODO To be done by ...

		return (false);
	}

	private int Evaluate(gmEngine node, int alpha, int beta, int depth,
			boolean ret_val) {
		// TODO To be done by ...

		return (0);
	}

	private int EstimateHeuristic(gmEngine state) {
		// TODO To be done by ...

		return (0);
	}

	private boolean MakeMove(gmEngine node, aiMove move) {
		// TODO To be done by ...

		return (false);
	}

	private boolean MakeMoveAndEval(gmEngine node, aiMove move, int depth,
			int eval) {
		// TODO To be done by ...

		return (false);
	}

	protected void finalize() {
		// TODO To be done by ...
	}

	public aiAgent() {
		// TODO To be done by P___65 Todor Balabanov
	}

	/**
	 * Set location.
	 * 
	 * @param loc
	 */
	public void SetLocation(int loc) {
		// TODO To be done by P___65 Todor Balabanov
	}

	public int GetLocation() {
		// TODO To be done by P___65 Todor Balabanov

		return (0);
	}

	public boolean GetBid(long cards, int bid, int trump, int min,
			boolean force_bid) {
		// TODO To be done by ...

		return (false);
	}

	public boolean GetBid(int bid, int trump, int min, boolean force_bid) {
		// TODO To be done by ...

		return (false);
	}

	public boolean SetRuleEngineData(gmEngineData data) {
		// TODO To be done by ...

		return (false);
	}

	public int GetTrump() {
		// TODO To be done by P___65 Todor Balabanov

		return (0);
	}

	public static int GetTrump(long hand, int suit) {
		// TODO To be done by ...

		return (0);
	}

	public int GetPlay(long mask) {
		// TODO To be done by ...

		return (0);
	}

	public boolean GenerateSLProblem(gmEngineData data, slProblem problem,
			int played[][], int trump, boolean add_trump) {
		// TODO To be done by ...

		return (false);
	}

	public boolean GenerateDeals(gmEngineData data, long deals, int count) {
		GenerateDeals(data, deals, count, gmUtil.gmSUIT_INVALID);

		return (false);
	}

	public boolean GenerateDeals(gmEngineData data, long deals, int count,
			int trump) {
		// TODO To be done by ...

		return (false);
	}

	public static String PrintMoves(aiMove moves, int move_count) {
		// TODO To be done by P___65 Todor Balabanov

		return ("");
	}

	public boolean PostPlayUpdate(gmEngineData data) {
		PostPlayUpdate(data, gmUtil.gmCARD_INVALID);

		return (false);
	}

	public boolean PostPlayUpdate(gmEngineData data, int card) {
		// TODO To be done by ...

		return (false);
	}

	public boolean CheckAssumptions(gmEngineData data) {
		// TODO To be done by P___65 Todor Balabanov

		return (false);
	}

	public boolean Reset() {
		// TODO To be done by P___65 Todor Balabanov

		return (false);
	}

	public void SetRules() {
		SetRules(null);
	}

	public void SetRules(gmRules rules) {
		// TODO To be done by P___65 Todor Balabanov
	}

	public boolean SetClockwise(boolean flag) {
		// TODO To be done by ...

		return (false);
	}

	public boolean GetClockwise() {
		// TODO To be done by ...

		return (false);
	}

	public boolean AbandonGame(boolean flag) {
		// TODO To be done by ...

		return (false);
	}
}
