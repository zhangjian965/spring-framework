/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.aop.framework.adapter;

/**
 * Singleton to publish a shared DefaultAdvisorAdapterRegistry instance.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Phillip Webb
 * @see DefaultAdvisorAdapterRegistry
 * 抽象类，不能被实例化，保证instance对象的唯一性
 */
public abstract class GlobalAdvisorAdapterRegistry {

	/**
	 * Keep track of a single instance so we can return it to classes that request it.
	 * 配置一个静态的final变量instance，使得对象在加载类的时候就生成了
	 */
	private static AdvisorAdapterRegistry instance = new DefaultAdvisorAdapterRegistry();

	/**
	 * Return the singleton {@link DefaultAdvisorAdapterRegistry} instance.
	 * 使用instance对象时，通过静态方法getInstance方法完成，保证instance唯一对象的获取
	 */
	public static AdvisorAdapterRegistry getInstance() {
		return instance;
	}

	/**
	 * Reset the singleton {@link DefaultAdvisorAdapterRegistry}, removing any
	 * {@link AdvisorAdapterRegistry#registerAdvisorAdapter(AdvisorAdapter) registered}
	 * adapters.
	 */
	static void reset() {
		instance = new DefaultAdvisorAdapterRegistry();
	}

}
