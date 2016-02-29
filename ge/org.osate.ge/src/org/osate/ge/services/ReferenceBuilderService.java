/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.services;

import org.eclipse.core.resources.IProject;

/**
 * Service for building string references to business objects
 */
public interface ReferenceBuilderService {
	String getReference(final Object bo);
	String getTitle(final Object bo);
	IProject getProject(final Object bo);
}
