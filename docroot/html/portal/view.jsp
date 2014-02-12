<%--
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
List<ObjectValuePair<String, List<String>>> entryTypeNavigation = new ArrayList<ObjectValuePair<String, List<String>>>(1);

entryTypeNavigation.add(new ObjectValuePair(EntryTypeKeys.ENTRY_TYPE_PORTAL, EntryTypeKeys.ENTRY_TYPE_PORTAL_LIST));

List<String> entryTypeNavigationKeys = new ArrayList<String>(1);

entryTypeNavigationKeys.add(EntryTypeKeys.ENTRY_TYPE_PORTAL);
%>

<%@ include file="/html/view_base.jsp" %>
