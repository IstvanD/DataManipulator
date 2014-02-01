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

package com.liferay.tool.datamanipulator.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.tool.datamanipulator.model.DataManipulator;
import com.liferay.tool.datamanipulator.model.impl.DataManipulatorImpl;
import com.liferay.tool.datamanipulator.service.base.DataManipulatorLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the data manipulator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.tool.datamanipulator.service.DataManipulatorLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil} to access the data manipulator local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Tibor KovĂˇcs
 * @see com.liferay.tool.datamanipulator.service.base.DataManipulatorLocalServiceBaseImpl
 * @see com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil
 */
public class DataManipulatorLocalServiceImpl
	extends DataManipulatorLocalServiceBaseImpl {
	public DataManipulator addDataManipulator(
			long groupId, String className, long classPK)
		throws SystemException {

		long dataManipulatorId = counterLocalService.increment(
			DataManipulator.class.getName());

		DataManipulator dataManipulator = dataManipulatorPersistence.create(
			dataManipulatorId);

		dataManipulator.setGroupId(groupId);
		dataManipulator.setClassName(className);
		dataManipulator.setClassPK(classPK);

		dataManipulatorPersistence.update(dataManipulator, false);

		return dataManipulator;
	}

	public List<?> getDataManipulatorClassNames() throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataManipulator.class, DataManipulatorImpl.TABLE_NAME,
			PortalClassLoaderUtil.getClassLoader());

		dynamicQuery.setProjection(
			ProjectionFactoryUtil. groupProperty("className"));

		return dataManipulatorPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public int getDataManipulatorCountByClassName(String className)
		throws SystemException {

		return dataManipulatorPersistence.countByClassName(className);
	}

	public int getDataManipulatorCountByG_C(long groupId, String className)
		throws SystemException {

		return dataManipulatorPersistence.countByG_C(groupId, className);
	}

	public int getDataManipulatorCountByGroupId(long groupId)
		throws SystemException {

		return dataManipulatorPersistence.countByGroupId(groupId);
	}

	public List<DataManipulator> getDataManipulatorsByClassName(
			String className)
		throws SystemException {

		return dataManipulatorPersistence.findByClassName(className);
	}

	public List<DataManipulator> getDataManipulatorsByG_C(
			long groupId, String className)
		throws SystemException {

		return dataManipulatorPersistence.findByG_C(groupId, className);
	}

	public List<DataManipulator> getDataManipulatorsByGroupId(long groupId)
		throws SystemException {

		return dataManipulatorPersistence.findByGroupId(groupId);
	}

}