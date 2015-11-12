/*
 * generated by Xtext
 */
package org.osate.reqspec;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.osate.reqspec.scoping.ReqSpecScopeProvider;
import org.osate.reqspec.serializer.ReqSpecCrossReferenceSerializer;

import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("restriction")
public class ReqSpecRuntimeModule extends org.osate.reqspec.AbstractReqSpecRuntimeModule {

	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.osate.alisa.common.naming.CommonQualifiedNameConverter.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return org.osate.alisa.common.services.CommonValueConverters.class;
	}

	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return org.osate.reqspec.scoping.ReqSpecScopeProvider.class;
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return ReqSpecCrossReferenceSerializer.class;
	}

}
