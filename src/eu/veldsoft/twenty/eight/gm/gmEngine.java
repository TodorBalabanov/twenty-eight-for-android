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

public class gmEngine {

	// Initialization of the gmEngineData structure used by each gmEngine
	// instance (m_data) is a costly affair
	// because 1) the structure is huge 2) there are multiple loops to be run to
	// initiate certian data elements.
	// At one point of time, approx 30% of the entire run time was taken by
	// gmEntine.Reset. To speed things up,
	// a static m_init of type gmEngineData is created and is initiated manually
	// when the first instance of gmEngine is
	// called. Once this is done, all further initializations of this struct is
	// done be a memcpy from m_init.
	public static gmEngineData m_init;

	public static boolean m_init_ok;

	private gmEngineData m_data;

	private void SetOutput(int output_type) {
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}

	private void SetInput(int input_type) {
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___48 Georgi Ivanov ...
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
	}

	private long GenerateMask() {
		return (GenerateMask(0));
	}

	private long GenerateMask(long rules) {
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...

		return (0);
	}

	private boolean SetDealEndOutput() {
		//TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...

		return (false);
	}

	// Disallow copy finalructor/assignment operators
	private gmEngine(final gmEngine object) {
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}

	private gmEngine assign(final gmEngine object) {
		//TODO To be done by INFM042 F___88 Ivan Dankinov ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...

		return (this);
	}

	public static void InitCache() {
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...
		//TODO To be done by INFM032 F___81 Marina Rangelova ...
	}

	public gmEngine() {
		//TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM032 F___52 Mihail Stankov ...
	}

	protected void finalize() {
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM032 F___94 Aleksandar Milev ...
	}

	public boolean IsOk() {
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		//TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___88 Ivan Dankinov ...

		return (false);
	}

	public int GetStatus() {
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...

		return (0);
	}

	public static boolean Reset(gmEngineData data) {
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return (false);
	}

	public boolean Reset() {
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
		//TODO To be done by INFM032 F___05 Iliya Grozev ...

		return (false);
	}

	public boolean Shuffle() {
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___52 Mihail Stankov ...

		return (false);
	}

	public boolean Continue() {
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...

		return (false);
	}

	public boolean GetOutput(int output_type, Object output) {
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return (false);
	}

	public boolean IsOutputPending() {
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM042 F___52 Mihail Stankov ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (false);
	}

	public int GetPendingOutputType() {
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...

		return (0);
	}

	public boolean IsInputPending() {
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___81 Marina Rangelova ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (false);
	}

	public int GetPendingInputType() {
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...

		return (0);
	}

	public boolean GetPendingInputCriteria(int input_type, Object input) {
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...

		return (false);
	}

	public int PostInputMessage(int input_type, Object input) {
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (0);
	}

	public boolean GetFeedback() {
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...

		return (false);
	}

	public void SetFeedback(boolean feedback) {
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
	}

	public void GetRules(gmRules rules) {
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___39 Shterion Yanev ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
	}

	public void SetRules(gmRules rules) {
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
	}

	public void GetHands(long hands) {
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
	}

	public void GetCardsPlayed(long cards) {
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
	}

	// TODO : Try to implement one method with trick_round as default variable
	public void GetTrick(int trick_round, gmTrick trick) {
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___52 Mihail Stankov ...
		//TODO To be done by INFM042 F___39 Shterion Yanev ...
	}

	public void GetTrick(gmTrick trick) {
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___39 Shterion Yanev ...
	}

	public int GetTrickRound() {
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM042 F___52 Mihail Stankov ...

		return (0);
	}

	public int GetPoints(int team) {
		//TODO To be done by INFM032 F___48 Georgi Ivanov ...
		//TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (0);
	}

	public void GetPoints(int pts[]) {
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___48 Georgi Ivanov ...
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
	}

	public int GetTrump() {
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM032 F___48 Georgi Ivanov ...

		return (0);
	}

	public int GetTrumpCard() {
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
		//TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (0);
	}

	public int GetDealer() {
		//TODO To be done by INFM042 F___52 Mihail Stankov ...
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...

		return (0);
	}

	public void SetDealer(int dealer) {
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
	}

	public static void ResetTrick(gmTrick trick) {
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
	}

	public boolean GetData(gmEngineData data) {
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
		//TODO To be done by INFM032 F___52 Mihail Stankov ...

		return (false);
	}

	public boolean SetData(gmEngineData data) {
		return (SetData(data, true));
	}

	public boolean SetData(gmEngineData data, boolean check) {
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...

		return (false);
	}

	public boolean GetMaxBid(int bid, int loc) {
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...

		return (false);
	}

	public String GetLoggable() {
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...

		return ("");
	}

	public static String PrintRuleEngineData(gmEngineData data) {
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return ("");
	}

	public boolean IsTrumpShown() {
		//TODO To be done by INFM032 F___52 Mihail Stankov ...
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...

		return (false);
	}

	public int GetTrickNextToPlay() {
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...

		return (0);
	}

	public void SetMinBid(int round, int bid) {
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM032 F___48 Georgi Ivanov ...
	}

	public void SetWaiveRuleFour(boolean flag) {
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
	}

	public void SetSluffJacks(boolean flag) {
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...
	}
}
