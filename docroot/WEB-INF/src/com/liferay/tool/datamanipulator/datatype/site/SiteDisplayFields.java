/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.tool.datamanipulator.datatype.site;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.model.GroupConstants;
import com.liferay.tool.datamanipulator.displayfield.DisplayFields;
import com.liferay.tool.datamanipulator.displayfield.Field;
import com.liferay.tool.datamanipulator.entry.EntryTypeKeys;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tibor Kov�cs
 *
 */
public class SiteDisplayFields {

	public static List<Field> getDisplayFields() throws SystemException {
		List<KeyValuePair> siteGroupTypes = new ArrayList<KeyValuePair>(4);
		siteGroupTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_COMMUNITY_OPEN_LABEL,
				String.valueOf(GroupConstants.TYPE_COMMUNITY_OPEN)));

		siteGroupTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_COMMUNITY_PRIVATE_LABEL,
				String.valueOf(GroupConstants.TYPE_COMMUNITY_PRIVATE)));

		siteGroupTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_COMMUNITY_RESTRICTED_LABEL,
				String.valueOf(GroupConstants.TYPE_COMMUNITY_RESTRICTED)));

		siteGroupTypes.add(
			new KeyValuePair(
				GroupConstants.TYPE_COMMUNITY_SYSTEM_LABEL,
				String.valueOf(GroupConstants.TYPE_COMMUNITY_SYSTEM)));

		DisplayFields fields = new DisplayFields();

		fields.addUserMultiSelect();
		fields.addSeparator();

		fields.addSelectList("site-type", siteGroupTypes);
		fields.addCheckbox("active-site", true);
		fields.addSeparator();

		fields.addCount(EntryTypeKeys.PORTAL_SITE);
		fields.addUpdateLevel(EntryTypeKeys.PORTAL_SITE);
		fields.addDepth(EntryTypeKeys.PORTAL_SITE);
		fields.addSubCount(EntryTypeKeys.PORTAL_SITE);
		fields.addSeparator();

		return fields.getDisplayFields();
	}

}