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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.tool.datamanipulator.entry.BaseEntry;
import com.liferay.tool.datamanipulator.entry.EntryArgs;
import com.liferay.tool.datamanipulator.entry.util.EntryUtil;
import com.liferay.tool.datamanipulator.handler.entryhandler.AbstractEntryHandler;
import com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel;
import com.liferay.tool.datamanipulator.model.DataManipulator;
import com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor;
import com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil;

/**
 * @author Tibor Kov�cs
 *
 */
public class SiteEntryHandler extends AbstractEntryHandler
	implements EntryHandlerModel {

	/**
	 * @param count
	 * @param update
	 * @param depth
	 * @param subCount
	 * @param baseEntry
	 * @param subEntryHandler
	 * @param requestProcessor
	 */
	public SiteEntryHandler(
		int count, int update, int depth, int subCount, BaseEntry baseEntry,
		EntryHandlerModel subEntryHandler, RequestProcessor requestProcessor) {

		super(
			count, update, depth, subCount, baseEntry, subEntryHandler,
			requestProcessor);

		_activeSite = requestProcessor.getBoolean("active-site");

		_siteType = requestProcessor.getInteger("site-type");

		_userIds = requestProcessor.getUserIds();
	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel#getCreateEntryArgs(long, java.lang.String, com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor)
	 */

	@Override
	public EntryArgs getCreateEntryArgs(
			long parentId, String postString, RequestProcessor requestProcessor)
		throws PortalException, SystemException {

		EntryArgs args = new EntryArgs(requestProcessor);

		args.setParameter("className", null);
		args.setParameter("classPK", 0);
		args.setParameter("liveGroupId", GroupConstants.DEFAULT_LIVE_GROUP_ID);
		args.setParameter("name", "Test Site" + postString + " Name");
		args.setParameter(
			"description", "Test Site" + postString + " Description");

		args.setParameter("type", _siteType);
		args.setParameter("site", true);
		args.setParameter("active", _activeSite);

		return args;
	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel#getDataManipulatorFromObject(java.lang.Object)
	 */

	@Override
	public DataManipulator getDataManipulatorFromObject(Object createdEntry)
		throws PortalException, SystemException {

		Group site = (Group)createdEntry;

		UserLocalServiceUtil.addGroupUsers(site.getGroupId(), _userIds);

		return DataManipulatorLocalServiceUtil.addDataManipulator(
			site.getCompanyId(), Group.class.getName(), site.getGroupId());
	}

	/* (non-Javadoc)
	 * @see com.liferay.tool.datamanipulator.handler.entryhandler.model.EntryHandlerModel#getUpdateEntryArgs(long, java.lang.String, com.liferay.tool.datamanipulator.requestprocessor.RequestProcessor)
	 */

	@Override
	public EntryArgs getUpdateEntryArgs(
			long entryId, String postString, RequestProcessor requestProcessor)
		throws PortalException, SystemException {

		Group site = GroupLocalServiceUtil.getGroup(entryId);

		EntryArgs args = new EntryArgs(requestProcessor);

		args.setParameter("groupId", entryId);
		args.setParameter(
			"name", EntryUtil.getEditString(site.getName(), postString));

		args.setParameter(
			"description",
			EntryUtil.getEditString(site.getDescription(), postString));

		args.setParameter("type", _siteType);
		args.setParameter("friendlyURL", site.getFriendlyURL());
		args.setParameter("active", _activeSite);

		return args;
	}

	private boolean _activeSite;
	private int _siteType;
	private long[] _userIds;

}