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

package com.liferay.tool.datamanipulator.entry.util;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Tibor Kov�cs
 *
 */
public class EntryUtil {

	public static String getEditString(String text, String post) {
		text = text.replaceAll(" Edit.*", StringPool.BLANK);
		text += " Edit-" + post;

		return text;
	}

	public static ServiceContext getNewServiceContext(
		long groupId, long userId) {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(false);
		serviceContext.setAddGuestPermissions(false);
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);

		return serviceContext;
	}

	public static Calendar getRandomCalendar(Calendar cal1, Calendar cal2) {
		if (Validator.isNull(cal1) || Validator.isNull(cal2)) {
			throw new IllegalArgumentException("The calendars must be valid!");
		}

		long fromMilisec = cal1.getTimeInMillis();

		long toMilisec = cal2.getTimeInMillis();

		if (fromMilisec == toMilisec) {
			return (Calendar)cal1.clone();
		}

		if (fromMilisec > toMilisec) {
			long tmp = fromMilisec;

			fromMilisec = toMilisec;

			toMilisec = tmp;
		}

		Calendar randomCalendar = Calendar.getInstance();

		randomCalendar.setTimeInMillis(
			nextLong((toMilisec - fromMilisec)) + fromMilisec);

		return randomCalendar;
	}

	public static boolean nextBoolean() {
		if (_rnd == null) {
			_rnd = new Random();
		}

		return _rnd.nextBoolean();
	}

	public static int nextInt() {
		if (Validator.isNull(_rnd)) {
			_rnd = new Random();
		}

		return _rnd.nextInt();
	}

	public static int nextInt(int max) {
		if (Validator.isNull(_rnd)) {
			_rnd = new Random();
		}

		if (max <= 0) {
			return 0;
		}

		return _rnd.nextInt(max);
	}

	public static int nextInt(int min, int max) {
		if (Validator.isNull(_rnd)) {
			_rnd = new Random();
		}

		return _rnd.nextInt(max - min) + min;
	}

	public static long nextLong(long n) {
		if (Validator.isNull(_rnd)) {
			_rnd = new Random();
		}

		if (n <= 0) {
			throw new IllegalArgumentException("n must be positive");
		}

		long bits, val;

		do {
			bits = _rnd.nextInt();
			val = bits % n;
		} while (bits - val + (n-1) < 0);

		return val;
	}

	public static String nextString() {
		return nextString(8);
	}

	public static String nextString(int maxCharacter) {
		StringBundler sb = new StringBundler(maxCharacter);

		for (int i = 0; i < maxCharacter; i++) {
			int index = nextInt(_ALLOWED_DIGITS.length);

			sb.append(_ALLOWED_DIGITS[index]);
		}

		return sb.toString();
	}

	private static final char[] _ALLOWED_DIGITS = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
		'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
		'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};

	private static Random _rnd;

}