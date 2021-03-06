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

package eu.veldsoft.twenty.eight.dummy;

public class wxMemoryDC {

	public void SelectObject(wxBitmap m_face) {
	} 

	public boolean Ok() {
		return false;
	} 

	public boolean Blit(int x, int y, int getWidth, int getHeight,
			wxMemoryDC bdc, int x2, int y2) {
		return false;
	} 

	public boolean Blit(wxCoord xdest, wxCoord ydest, wxCoord width,
			wxCoord height, wxMemoryDC bdc, wxCoord xdest2, wxCoord ydest2) {
		return false;
	} 

	public boolean Blit(wxCoord xdest, wxCoord ydest, wxCoord width,
			wxCoord height, wxDC source, wxCoord xsrc, wxCoord ysrc,
			int logicalFunc, boolean useMask, wxCoord xsrcMask, wxCoord ysrcMask) {
		return false;
	} 

} 
