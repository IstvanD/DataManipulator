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

package com.liferay.tool.datamanipulator.requestprocessor;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.tool.datamanipulator.displayfield.FieldKeys;
import com.liferay.tool.datamanipulator.displayfield.FieldTypeKeys;

import java.io.File;

import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

/**
 * @author Tibor Kov�cs
 *
 */
public class RequestProcessor {
	public RequestProcessor(UploadPortletRequest uploadRequest) {
		_uploadRequest = uploadRequest;

		_themeDisplay =
			(ThemeDisplay)_uploadRequest.getAttribute(WebKeys.THEME_DISPLAY);

		_parameters = new HashMap<String, Object>();
	}

	public Object get(String key) {
		return _parameters.get(key);
	}

	public String getAddToParent(String key) {
		return getString(key + StringPool.DASH + FieldKeys.ADD_TO_PARENT);
	}

	public boolean getBoolean(String key) {
		if (_parameters.containsKey(key)) {
			return (Boolean)_parameters.get(key);
		}

		return ParamUtil.getBoolean(_uploadRequest, key, false);
	}

	public Calendar getCalendar(String key) {
		Calendar cal = Calendar.getInstance();

		cal.set(
			Calendar.YEAR, ParamUtil.getInteger(_uploadRequest, key + "Year"));

		cal.set(
			Calendar.MONTH,
			ParamUtil.getInteger(_uploadRequest, key + "Month"));

		cal.set(
			Calendar.DATE, ParamUtil.getInteger(_uploadRequest, key + "Day"));

		cal.set(
			Calendar.HOUR, ParamUtil.getInteger(_uploadRequest, key + "Hour"));

		cal.set(
			Calendar.MINUTE,
			ParamUtil.getInteger(_uploadRequest, key + "Minute"));

		cal.set(
			Calendar.AM_PM, ParamUtil.getInteger(_uploadRequest, key + "AmPm"));

		return cal;
	}

	public long getCompanyId() {
		return _themeDisplay.getCompanyId();
	}

	public int getCount(String key) {
		return getInteger(key + StringPool.DASH + FieldKeys.COUNT);
	}

	public int getDepth(String key) {
		return getInteger(key + StringPool.DASH + FieldKeys.DEPTH);
	}

	public File getFile(String key) {
		return _uploadRequest.getFile(key);
	}

	public long getGroupId() {
		return (Long) _parameters.get(Field.GROUP_ID);
	}

	public long[] getGroupIds() {
		return getLongValues(FieldTypeKeys.MULTI_SELECT_SITE_LIST);
	}

	public int getInteger(String key) {
		return ParamUtil.getInteger(_uploadRequest, key, 0);
	}

	public String getLanguageId() {
		return _themeDisplay.getLanguageId();
	}

	public long getLong(String key) {
		return ParamUtil.getLong(_uploadRequest, key, 0);
	}

	public long[] getLongValues(String key) {
		return ParamUtil.getLongValues(_uploadRequest, key, new long[0]);
	}

	public int getMinutes(String key) {
		int h = ParamUtil.getInteger(_uploadRequest, key + "-hour", 0);
		int m = ParamUtil.getInteger(_uploadRequest, key + "-minute", 0);

		if ((h <= 0) && (m <= 0)) {
			m = 5;
		}

		return h * 60 + m;
	}

	public long[] getOrganizationIds() {
		return getLongValues(FieldTypeKeys.MULTI_SELECT_ORGANIZATION_LIST);
	}

	public PermissionChecker getPermissionChecker() {
		return _themeDisplay.getPermissionChecker();
	}

	public long[] getRoleIds() {
		return getLongValues(FieldTypeKeys.MULTI_SELECT_ROLE_LIST);
	}

	public HttpSession getSession() {
		return _uploadRequest.getSession(true);
	}

	public String getString(String key) {
		return ParamUtil.getString(_uploadRequest, key, StringPool.BLANK);
	}

	public String[] getStringValues(String key) {
		long[] values = getLongValues(key);

		String[] returnValues = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			returnValues[i] = String.valueOf(values[i]);
		}
		return returnValues;
	}

	public int getSubCount(String key) {
		return getInteger(key + StringPool.DASH + FieldKeys.SUB_COUNT);
	}

	public int getUpdateLevel(String key) {
		return getInteger(key + StringPool.DASH + FieldKeys.UPDATE_LEVEL);
	}

	public long[] getUserGroupIds() {
		return getLongValues(FieldTypeKeys.MULTI_SELECT_USERGROUP_LIST);
	}

	public long getUserId() {
		return (Long)_parameters.get(Field.USER_ID);
	}

	public long[] getUserIds() {
		return getLongValues(FieldTypeKeys.MULTI_SELECT_USER_LIST);
	}

	public void set(String key, Object value) {
		_parameters.put(key, value);
	}

	public void setGroupId(long groupId) {
		_parameters.put(Field.GROUP_ID, groupId);
	}

	public void setUserId(long userId) {
		_parameters.put(Field.USER_ID, userId);
	}

	private HashMap<String, Object> _parameters;
	private ThemeDisplay _themeDisplay;
	private UploadPortletRequest _uploadRequest;

}