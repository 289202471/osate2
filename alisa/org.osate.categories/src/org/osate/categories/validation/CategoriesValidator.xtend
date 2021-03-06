/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

/*
 * generated by Xtext
 */
package org.osate.categories.validation

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.osate.categories.categories.CategoriesDefinitions

//import org.eclipse.xtext.validation.Check
/**
 * Custom validation rules. 
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class CategoriesValidator extends AbstractCategoriesValidator {

	public static val CAT_FILE_EXT = "cat"
  	public static val FILTER_FILE_EXT = "filter"
	public static val DUPLICATE_CATEGORY = 'org.osate.categories.validation.duplicate.category'

	
	@Check (CheckType.FAST)
	def void checkFileTypeContents(CategoriesDefinitions categoriesDefinitions) {
		val categoriesDefinitionURI = EcoreUtil.getURI(categoriesDefinitions)
		val fileExt = categoriesDefinitionURI.fileExtension.toLowerCase
		switch fileExt{
			case CAT_FILE_EXT : {
				categoriesDefinitions.categoryFilters.forEach[part |
					fileTypeWarning(fileExt, "filter", part)	
				]
			} 
			case FILTER_FILE_EXT : {
				categoriesDefinitions.categories.forEach[part |
					fileTypeWarning(fileExt, "category", part)	
				]
			} 
			default : {}
		}
	}	
		
	def void fileTypeWarning(String fileType, String partName, EObject part){
		warning( partName +" not allowed in '"+ fileType + "' file.", part, null)
	}
	
	
}
