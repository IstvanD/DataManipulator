/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.tool.datamanipulator.entry;

import java.util.ArrayList;

/**
 * @author Tibor Kov�cs
 *
 */
public class EntryTypeKeys {
	//Lists and base names

	public static final String ENTRY_TYPE_GENERAL = "general-entry-type";

	public static final ArrayList<String> ENTRY_TYPE_GENERAL_LIST =
		_generalEntryTypes();

	public static final String ENTRY_TYPE_PLUGIN = "plugin-entry-type";

	public static final ArrayList<String> ENTRY_TYPE_PLUGIN_LIST =
		_pluginEntryTypes();

	public static final String ENTRY_TYPE_PORTAL = "portal-entry-type";

	public static final ArrayList<String> ENTRY_TYPE_PORTAL_LIST =
		_portalEntryTypes();

	// General Entry types

	public static final String GENERAL_ASSET_CATEGORIES = "categories";

	public static final String GENERAL_ASSET_CATEGORY = "category";

	public static final String GENERAL_ASSET_VOCABULARY = "vocabulary";

	public static final String GENERAL_BLOGS = "blogs";

	public static final String GENERAL_BLOGS_ENTRY = "blogs-entry";

	public static final String GENERAL_BOOKMARKS = "bookmarks";

	public static final String GENERAL_BOOKMARKS_ENTRY = "bookmarks-entry";

	public static final String GENERAL_BOOKMARKS_FOLDER = "bookmarks-folder";

	public static final String GENERAL_CALENDAR = "calendar";

	public static final String GENERAL_CALENDAR_EVENT = "calendar-event";

	//Plugin Entry types

	//Poral Entry types

	//Private methods for declare the DataTypes location

	private static ArrayList<String> _generalEntryTypes() {
		ArrayList<String> types = new ArrayList<String>();

		types.add(GENERAL_BLOGS);
		types.add(GENERAL_BOOKMARKS);
		types.add(GENERAL_CALENDAR);
		types.add(GENERAL_ASSET_CATEGORIES);

		return types;
	}

	private static ArrayList<String> _pluginEntryTypes() {
		ArrayList<String> types = new ArrayList<String>();

		return types;
	}

	private static ArrayList<String> _portalEntryTypes() {
		ArrayList<String> types = new ArrayList<String>();

		return types;
	}

}