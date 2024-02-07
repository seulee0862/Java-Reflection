package com.reflectionjava.basic.ex1;

import java.util.Arrays;
import java.util.List;

public class Exercise {
	private static final List<String> JDK_PACKAGE_PREFIXES =
		Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");

	public static void main(String[] args) {
		PopupTypeInfo popupTypeInfoFromClass = createPopupTypeInfoFromClass(Comparable.class);
		System.out.println("popupTypeInfoFromClass = " + popupTypeInfoFromClass);
	}


	public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
		PopupTypeInfo popupTypeInfo = new PopupTypeInfo();

		popupTypeInfo.setPrimitive(inputClass.isPrimitive())
			.setInterface(inputClass.isInterface())
			.setEnum(inputClass.isEnum())
			.setName(inputClass.getSimpleName())
			.setJdk(isJdkClass(inputClass))
			.addAllInheritedClassNames(getAllInheritedClassNames(inputClass));

		return popupTypeInfo;
	}

	public static boolean isJdkClass(Class<?> inputClass) {
		return JDK_PACKAGE_PREFIXES.stream()
			.anyMatch(packagePrefix -> inputClass.getPackage() == null
				|| inputClass.getPackage().getName().startsWith(packagePrefix));
	}

	public static String[] getAllInheritedClassNames(Class<?> inputClass) {
		String[] inheritedClasses;
		if (inputClass.isInterface()) {
			inheritedClasses = Arrays.stream(inputClass.getInterfaces())
				.map(Class::getSimpleName)
				.toArray(String[]::new);
		} else {
			Class<?> inheritedClass = inputClass.getSuperclass();
			inheritedClasses = inheritedClass != null ?
				new String[]{inputClass.getSuperclass().getSimpleName()}
				: null;
		}
		return inheritedClasses;
	}
}


