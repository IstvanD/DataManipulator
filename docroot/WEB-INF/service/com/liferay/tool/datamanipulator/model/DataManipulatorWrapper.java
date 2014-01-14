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

package com.liferay.tool.datamanipulator.model;

/**
 * <p>
 * This class is a wrapper for {@link DataManipulator}.
 * </p>
 *
 * @author    Tibor KovĂˇcs
 * @see       DataManipulator
 * @generated
 */
public class DataManipulatorWrapper implements DataManipulator {
	public DataManipulatorWrapper(DataManipulator dataManipulator) {
		_dataManipulator = dataManipulator;
	}

	/**
	* Gets the primary key of this data manipulator.
	*
	* @return the primary key of this data manipulator
	*/
	public long getPrimaryKey() {
		return _dataManipulator.getPrimaryKey();
	}

	/**
	* Sets the primary key of this data manipulator
	*
	* @param pk the primary key of this data manipulator
	*/
	public void setPrimaryKey(long pk) {
		_dataManipulator.setPrimaryKey(pk);
	}

	/**
	* Gets the id of this data manipulator.
	*
	* @return the id of this data manipulator
	*/
	public long getId() {
		return _dataManipulator.getId();
	}

	/**
	* Sets the id of this data manipulator.
	*
	* @param id the id of this data manipulator
	*/
	public void setId(long id) {
		_dataManipulator.setId(id);
	}

	/**
	* Gets the group id of this data manipulator.
	*
	* @return the group id of this data manipulator
	*/
	public long getGroupId() {
		return _dataManipulator.getGroupId();
	}

	/**
	* Sets the group id of this data manipulator.
	*
	* @param groupId the group id of this data manipulator
	*/
	public void setGroupId(long groupId) {
		_dataManipulator.setGroupId(groupId);
	}

	/**
	* Gets the class name of this data manipulator.
	*
	* @return the class name of this data manipulator
	*/
	public java.lang.String getClassName() {
		return _dataManipulator.getClassName();
	}

	/**
	* Sets the class name of this data manipulator.
	*
	* @param className the class name of this data manipulator
	*/
	public void setClassName(java.lang.String className) {
		_dataManipulator.setClassName(className);
	}

	/**
	* Gets the class p k of this data manipulator.
	*
	* @return the class p k of this data manipulator
	*/
	public long getClassPK() {
		return _dataManipulator.getClassPK();
	}

	/**
	* Sets the class p k of this data manipulator.
	*
	* @param classPK the class p k of this data manipulator
	*/
	public void setClassPK(long classPK) {
		_dataManipulator.setClassPK(classPK);
	}

	public boolean isNew() {
		return _dataManipulator.isNew();
	}

	public void setNew(boolean n) {
		_dataManipulator.setNew(n);
	}

	public boolean isCachedModel() {
		return _dataManipulator.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dataManipulator.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dataManipulator.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_dataManipulator.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dataManipulator.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dataManipulator.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dataManipulator.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _dataManipulator.clone();
	}

	public int compareTo(
		com.liferay.tool.datamanipulator.model.DataManipulator dataManipulator) {
		return _dataManipulator.compareTo(dataManipulator);
	}

	public int hashCode() {
		return _dataManipulator.hashCode();
	}

	public com.liferay.tool.datamanipulator.model.DataManipulator toEscapedModel() {
		return _dataManipulator.toEscapedModel();
	}

	public java.lang.String toString() {
		return _dataManipulator.toString();
	}

	public java.lang.String toXmlString() {
		return _dataManipulator.toXmlString();
	}

	public DataManipulator getWrappedDataManipulator() {
		return _dataManipulator;
	}

	private DataManipulator _dataManipulator;
}