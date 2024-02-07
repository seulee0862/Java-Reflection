package com.reflectionjava.basic.ex2;

import java.util.HashSet;
import java.util.Set;

public class Exercise {

	public static Set<Class<?>> findAllImplementedInerfaces(Class<?> input) {
		Set<Class<?>> allImplementedInterfaces = new HashSet<>();

		Class<?>[] inputInterfaces = input.getInterfaces();
		for (Class<?> currentInterface : inputInterfaces) {
			allImplementedInterfaces.add(currentInterface);
			allImplementedInterfaces.addAll(findAllImplementedInerfaces(currentInterface));
		}

		return allImplementedInterfaces;
	}
}
