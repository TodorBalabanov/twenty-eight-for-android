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

	/**
	 * Disallow copy finalructor/assignment operators.
	 * 
	 * @param elem1
	 * @param elem2
	 * 
	 * @return
	 * 
	 * @author To be done by INFM032 F___90 Svetoslav Slavkov ...
	 * @author To be done by INFM042 F___88 Ivan Dankinov ...
	 * @author To be done by INFM042 F___81 Marina Rangelova ...
	 */
	private aiAgent(final aiAgent object) {
		/*
		 * Empty body of private constructor.
		 */
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

	/**
	 * 
	 * @param moves
	 * @param move_count
	 * 
	 * @return
	 * 
	 * @author INFM042 F___47 Kostadin Bulakiev ...
	 * @author INFM042 F___90 Svetoslav Slavkov ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 */
	public static String PrintMoves(aiMove moves[], int move_count) {
		assert (move_count >= 0);

		StringBuffer out = new StringBuffer();
		out.append("" + move_count + " moves - ");
		for (int i = 0; i < move_count; i++) {
			if (moves[i].ask_trump) {
				out.append("?"
						+ gmUtil.m_suits[Globals.gmGetSuit(moves[i].card)]
						+ gmUtil.m_values[Globals.gmGetValue(moves[i].card)]
						+ "(" + moves[i].rank + "),");
			} else {
				out.append(""
						+ gmUtil.m_suits[Globals.gmGetSuit(moves[i].card)]
						+ gmUtil.m_values[Globals.gmGetValue(moves[i].card)]
						+ "(" + moves[i].rank + "),");
			}
		}

		return out.toString();
	}

	public boolean PostPlayUpdate(gmEngineData data) {
		PostPlayUpdate(data, gmUtil.gmCARD_INVALID);

		return (false);
	}

	/**
	 * 
	 * @param data
	 * @param card
	 * 
	 * @return
	 * 
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM032 F___39 Shterion Yanev
	 */
	public boolean PostPlayUpdate(gmEngineData data, int card) {
		assert (card != Globals.gmCARD_INVALID);
		assert (data.status == Globals.gmSTATUS_TRICKS);

		/*
		 * If the input card is valid
		 */
		if (card != Globals.gmCARD_INVALID) {
			int suit = Globals.gmGetSuit(card);

			/*
			 * If trump is not shown and if the player is the max bidder and if
			 * it is the first card in the trick then the suit is not trump,
			 * provided the max bidder has a choice of another suit
			 */
			if (!data.trump_shown
					&& (data.in_trick_info.player == data.curr_max_bidder)) {
				if (data.tricks[data.trick_round].count == 0) {

					/*
					 * Get the count of cards belonging to the suit already
					 * played
					 */
					int cards_left = 0;
					for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
						cards_left += gmUtil.CountBitsSet(data.played_cards[i]
								& gmUtil.m_suit_mask[suit]);
					}

					/*
					 * Add to that the number of cards held by the AI player
					 * belonging to the suit
					 */
					cards_left += gmUtil.CountBitsSet(data.hands[m_loc]
							& gmUtil.m_suit_mask[suit]);

					/*
					 * Consider the card being played
					 */
					cards_left++;

					/*
					 * Check whether the number of cards left in the suit is
					 * less than the number of cards left in max bidders hand
					 * after the play (8 - data->trick_round) > (8 - cards_left)
					 */
					if (data.trick_round < cards_left) {

						/*
						 * wxLogDebug(wxString::Format("%s is not the trump",
						 * gmUtil::m_suits[suit].c_str()));
						 */
						m_trump_cards &= ~(1 << suit);
					} else {
						m_notrump_suspects |= (1 << suit);
					}
				}

				/*
				 * Check each of the suspects, if the max bidder has played a
				 * card which is not any of the suspects, the suspicion is valid
				 */
				if (m_notrump_suspects != 0) {
					for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
						/*
						 * if((m_notrump_suspects & (1 << suit)) && (i != suit))
						 */
						if ((m_notrump_suspects & (1 << i)) != 0 && (i != suit)) {
							/*
							 * Remove the suit from the list of possible trump
							 * suits
							 */
							m_trump_cards &= ~(1 << i);
							/*
							 * Remove the suit from the list of suspects
							 */
							m_notrump_suspects &= ~(1 << i);
						}
					}
				}
			}

			assert (m_trump_cards != 0);

			/*
			 * Check the cases where a player is unable to follow suit
			 */
			if ((data.tricks[data.trick_round].count > 0)
					&& (data.tricks[data.trick_round].lead_suit != suit)) {
				/*
				 * If the current player is the max bidder we can safely assume
				 * that either the suit is the trump and the max bidder has only
				 * one card of the suit left and that is kept as the trump.
				 * Otherwise the suit length is zero. This can be confirmed only
				 * after the trump is shown
				 */
				if ((data.in_trick_info.player == data.curr_max_bidder)
						&& (!data.trump_shown)) {
					m_mb_null_susp |= (1 << data.tricks[data.trick_round].lead_suit);
				}
				/*
				 * If the player playing the card is not the max bidder we can
				 * safely assume that the suit length for the player
				 */
				else {
					m_nulls[data.in_trick_info.player] |= (1 << data.tricks[data.trick_round].lead_suit);
				}
			}
		}

		/*
		 * If trump is shown and if any of the null suspects is not the trump
		 * set the suit length in max bidders hand to zero for those
		 */
		if (data.trump_shown && (m_mb_null_susp != 0)) {
			for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
				if ((m_mb_null_susp & (1 << i)) != 0 && (i != data.trump_suit)) {
					m_nulls[data.curr_max_bidder] |= (1 << i);
					/*
					 * Remove from the suspect list
					 */
					m_mb_null_susp &= ~(1 << i);
				}
			}
		}

		/*
		 * If self is not the max bidder and trump is not shown, For any suit if
		 * the sum of the cards played(including the the cards played in the
		 * current trick) and cards held by self is 8, then the suit is not the
		 * trump. This is because max bidder cannot have any card of the suit.
		 */
		if ((m_loc != data.curr_max_bidder) && (!data.trump_shown)) {
			long cards_played = 0;

			/*
			 * Add the card that is being played first
			 */
			if (card != Globals.gmCARD_INVALID) {
				cards_played |= (1 << card);
			}

			/*
			 * Add the cards played so far (previous tricks and the current one)
			 */
			for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
				cards_played |= data.played_cards[i];
				if (data.tricks[data.trick_round].cards[i] != Globals.gmCARD_INVALID)
					cards_played |= (1 << data.tricks[data.trick_round].cards[i]);
			}

			for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
				if (gmUtil.CountBitsSet((cards_played | data.hands[m_loc])
						& gmUtil.m_suit_mask[i]) >= Globals.gmTOTAL_VALUES) {
					m_trump_cards &= ~(1 << i);
				}
			}
		}

		return true;
	}

	public boolean CheckAssumptions(gmEngineData data) {
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...

		return (false);
	}

	/**
	 * @param moves
	 * @param move_count
	 * 
	 * @return
	 * 
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM032 F___46 Nadya Nedyalkova ...
	 * @author INFM042 F___68 Nikola Vushkov ...
	 */
	public boolean Reset() {
		m_engine.Reset();
		m_trump_cards = 0x0000000F;

		for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_nulls[i] = 0;
		}

		m_notrump_suspects = 0;
		m_mb_null_susp = 0;

		return true;
	}

	public void SetRules() {
		SetRules(null);
	}

	public void SetRules(gmRules rules) {
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
	}

	/**
	 * 
	 * @param flag
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM042 F___88 Ivan Dankinov
	 */
	public boolean SetClockwise(boolean flag) {
		gmEngineData data = new gmEngineData();
		m_engine.GetData(data);
		if (flag) {
			data.rules.rot_addn = 1;
		} else {
			data.rules.rot_addn = 3;
		}
		m_engine.SetData(data, false);

		return true;
	}

	public boolean GetClockwise() {
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...

		return (false);
	}

	/**
	 * 
	 * @param flag
	 * 
	 * @return
	 * 
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM032 F___84 Mariya Kostadinova ...
	 * @author INFM042 F___90 Svetoslav Slavkov ...
	 */
	public boolean AbandonGame(boolean flag) {
		assert (flag);
		flag = true;
		return true;
	}
}
