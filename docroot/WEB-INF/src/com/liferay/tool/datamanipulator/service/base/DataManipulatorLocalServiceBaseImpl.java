/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.tool.datamanipulator.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.ClassNameLocalService;
import com.liferay.portal.service.ClassNameService;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.tool.datamanipulator.model.DataManipulator;
import com.liferay.tool.datamanipulator.service.DataManipulatorLocalService;
import com.liferay.tool.datamanipulator.service.persistence.DataManipulatorPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the data manipulator local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.tool.datamanipulator.service.impl.DataManipulatorLocalServiceImpl}.
 * </p>
 *
 * @author Tibor KovĂˇcs
 * @see com.liferay.tool.datamanipulator.service.impl.DataManipulatorLocalServiceImpl
 * @see com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil
 * @generated
 */
public abstract class DataManipulatorLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DataManipulatorLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.tool.datamanipulator.service.DataManipulatorLocalServiceUtil} to access the data manipulator local service.
	 */

	/**
	 * Adds the data manipulator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataManipulator the data manipulator
	 * @return the data manipulator that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataManipulator addDataManipulator(DataManipulator dataManipulator)
		throws SystemException {
		dataManipulator.setNew(true);

		return dataManipulatorPersistence.update(dataManipulator, false);
	}

	/**
	 * Creates a new data manipulator with the primary key. Does not add the data manipulator to the database.
	 *
	 * @param id the primary key for the new data manipulator
	 * @return the new data manipulator
	 */
	public DataManipulator createDataManipulator(long id) {
		return dataManipulatorPersistence.create(id);
	}

	/**
	 * Deletes the data manipulator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the data manipulator
	 * @return the data manipulator that was removed
	 * @throws PortalException if a data manipulator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataManipulator deleteDataManipulator(long id)
		throws PortalException, SystemException {
		return dataManipulatorPersistence.remove(id);
	}

	/**
	 * Deletes the data manipulator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataManipulator the data manipulator
	 * @return the data manipulator that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataManipulator deleteDataManipulator(
		DataManipulator dataManipulator) throws SystemException {
		return dataManipulatorPersistence.remove(dataManipulator);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(DataManipulator.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dataManipulatorPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return dataManipulatorPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return dataManipulatorPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return dataManipulatorPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public DataManipulator fetchDataManipulator(long id)
		throws SystemException {
		return dataManipulatorPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the data manipulator with the primary key.
	 *
	 * @param id the primary key of the data manipulator
	 * @return the data manipulator
	 * @throws PortalException if a data manipulator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DataManipulator getDataManipulator(long id)
		throws PortalException, SystemException {
		return dataManipulatorPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return dataManipulatorPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the data manipulators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of data manipulators
	 * @param end the upper bound of the range of data manipulators (not inclusive)
	 * @return the range of data manipulators
	 * @throws SystemException if a system exception occurred
	 */
	public List<DataManipulator> getDataManipulators(int start, int end)
		throws SystemException {
		return dataManipulatorPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of data manipulators.
	 *
	 * @return the number of data manipulators
	 * @throws SystemException if a system exception occurred
	 */
	public int getDataManipulatorsCount() throws SystemException {
		return dataManipulatorPersistence.countAll();
	}

	/**
	 * Updates the data manipulator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataManipulator the data manipulator
	 * @return the data manipulator that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataManipulator updateDataManipulator(
		DataManipulator dataManipulator) throws SystemException {
		return updateDataManipulator(dataManipulator, true);
	}

	/**
	 * Updates the data manipulator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataManipulator the data manipulator
	 * @param merge whether to merge the data manipulator with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the data manipulator that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataManipulator updateDataManipulator(
		DataManipulator dataManipulator, boolean merge)
		throws SystemException {
		dataManipulator.setNew(false);

		return dataManipulatorPersistence.update(dataManipulator, merge);
	}

	/**
	 * Returns the data manipulator local service.
	 *
	 * @return the data manipulator local service
	 */
	public DataManipulatorLocalService getDataManipulatorLocalService() {
		return dataManipulatorLocalService;
	}

	/**
	 * Sets the data manipulator local service.
	 *
	 * @param dataManipulatorLocalService the data manipulator local service
	 */
	public void setDataManipulatorLocalService(
		DataManipulatorLocalService dataManipulatorLocalService) {
		this.dataManipulatorLocalService = dataManipulatorLocalService;
	}

	/**
	 * Returns the data manipulator persistence.
	 *
	 * @return the data manipulator persistence
	 */
	public DataManipulatorPersistence getDataManipulatorPersistence() {
		return dataManipulatorPersistence;
	}

	/**
	 * Sets the data manipulator persistence.
	 *
	 * @param dataManipulatorPersistence the data manipulator persistence
	 */
	public void setDataManipulatorPersistence(
		DataManipulatorPersistence dataManipulatorPersistence) {
		this.dataManipulatorPersistence = dataManipulatorPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.tool.datamanipulator.model.DataManipulator",
			dataManipulatorLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.tool.datamanipulator.model.DataManipulator");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return DataManipulator.class;
	}

	protected String getModelClassName() {
		return DataManipulator.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dataManipulatorPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DataManipulatorLocalService.class)
	protected DataManipulatorLocalService dataManipulatorLocalService;
	@BeanReference(type = DataManipulatorPersistence.class)
	protected DataManipulatorPersistence dataManipulatorPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ClassNameLocalService.class)
	protected ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNameService.class)
	protected ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private DataManipulatorLocalServiceClpInvoker _clpInvoker = new DataManipulatorLocalServiceClpInvoker();
}