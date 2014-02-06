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

<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.tool.datamanipulator.entry.EntryTypeKeys" %>
<%@ page import="com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ include file="/html/init.jsp" %>

<h3><liferay-ui:message key="summary" /></h3>

<%
List<?> classNames = DataManipulatorLocalServiceUtil.getDataManipulatorClassNames();

List<KeyValuePair> generatedClassEntryCount = new ArrayList<KeyValuePair>(classNames.size());

for (Object className : classNames) {
	int count = 0;
	if (entryTypeNavigation.contains(EntryTypeKeys.ENTRY_TYPE_CUSTOM)) {
		count = DataManipulatorLocalServiceUtil.getDataManipulatorCountByClassName((String)className);
	}
	else if (entryTypeNavigation.contains(EntryTypeKeys.ENTRY_TYPE_PORTAL)) {
		count = DataManipulatorLocalServiceUtil.getDataManipulatorCountByG_C(themeDisplay.getCompanyId(), (String)className);
	}
	else {
		count = DataManipulatorLocalServiceUtil.getDataManipulatorCountByG_C(themeDisplay.getScopeGroupId(), (String)className);
	}

	if (count > 0) {
		generatedClassEntryCount.add(new KeyValuePair((String)className, String.valueOf(count)));
	}
}
%>

<liferay-ui:search-container emptyResultsMessage="generated-entry-empty-results-message">
	<liferay-ui:search-container-results results="<%= generatedClassEntryCount %>" total="<%= generatedClassEntryCount.size() %>" />

	<liferay-ui:search-container-row className="com.liferay.portal.kernel.util.KeyValuePair" escapedModel="<%= true %>" modelVar="kvp">
		<liferay-ui:search-container-column-text name="generated-entry-class"
			value="<%= kvp.getKey() %>" />

		<liferay-ui:search-container-column-text name="generated-entry-count"
			value="<%= kvp.getValue() %>" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
