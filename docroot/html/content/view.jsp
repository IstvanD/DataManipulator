<%--
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
--%>

<%@ page import="com.liferay.portal.kernel.util.ObjectValuePair" %>
<%@ page import="com.liferay.tool.datamanipulator.entry.EntryTypeKeys" %>

<%@ include file="/html/init.jsp" %>

<%
List<ObjectValuePair<String, List<String>>> entryTypeNavigation = new ArrayList<ObjectValuePair<String, List<String>>>();

entryTypeNavigation.add(new ObjectValuePair(EntryTypeKeys.ENTRY_TYPE_GENERAL, EntryTypeKeys.ENTRY_TYPE_GENERAL_LIST));
entryTypeNavigation.add(new ObjectValuePair(EntryTypeKeys.ENTRY_TYPE_PLUGIN, EntryTypeKeys.ENTRY_TYPE_PLUGIN_LIST));

List<String> entryTypeNavigationKeys = new ArrayList<String>(1);

entryTypeNavigationKeys.add(EntryTypeKeys.ENTRY_TYPE_GENERAL);
entryTypeNavigationKeys.add(EntryTypeKeys.ENTRY_TYPE_PLUGIN);
%>

<%@ include file="/html/view_base.jsp" %>
