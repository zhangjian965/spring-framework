/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.support;

import java.io.Serializable;

import org.springframework.aop.ClassFilter;

/**
 * Simple ClassFilter implementation that passes classes (and optionally subclasses).
 *
 * @author Rod Johnson
 */
@SuppressWarnings("serial")
public class RootClassFilter implements ClassFilter, Serializable {

	private Class<?> clazz;


	public RootClassFilter(Class<?> clazz) {
		this.clazz = clazz;
	}


	@Override
	public boolean matches(Class<?> candidate) {
		//通过判断目标类是否是指定类型（或其子类型），决定是否匹配
		return this.clazz.isAssignableFrom(candidate);
	}

}
