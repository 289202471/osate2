package org.osate.workspace;

import java.io.File;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class WorkspacePlugin extends AbstractUIPlugin {
	/**
	 * ID of the AADL core plugin (value
	 * <code>"org.osate.workspace"</code>)
	 */
	public static final String PLUGIN_ID = "org.osate.workspace";

	/**
	 * File extension of AADL source text files
	 */
	public static final String SOURCE_FILE_EXT = "aadl";
	public static final String SOURCE_FILE_EXT2 = "aadl2";

	/**
	 * File extension of AADL model files
	 */
	public static final String MODEL_FILE_EXT = "aaxl2";

//	 Instance model extensions and naming
	// new naming convention is "aail2" and no need for name ending with "_instance"
	// Code for handling new convention is in place
	// Have not enabled until people depending on it are made aware of the change

	/**
	 * File extension of AADL instance model files
	 */
	public static final String INSTANCE_FILE_EXT = "aaxl2";

	/**
	 * Default Aadl instances directory.
	 */
	public static final String AADL_INSTANCES_DIR = "instances";

	/**
	 * Default Aadl instances directory.
	 */
	public static final String AADL_REPORTS_DIR = "reports";

	/**
	 * instance model name postfix
	 */
	public static final String INSTANCE_MODEL_POSTFIX = "_Instance";

	/**
	 * Package separator in AADL source files.
	 */
	public static final String AADL_PACKAGE_SEPARATOR = "::";

	/**
	 * Package separator in package file names.
	 */
	public static final String FILE_PACKAGE_SEPARATOR = "-";

	/**
	 * Name of preference for standard AADL property set file
	 */
	public static final String AADL_PROPERTIES_FILE = "aadlPropertiesFilePreference";

	/**
	 * Name of preference for standard AADL property set file
	 */
	public static final String AADL_PROJECT_FILE = "aadlProjectFilePreference";

	/**
	 * Aadl packages directory.
	 */
	public static final String AADL_PACKAGES_DIR = "packages";

	/**
	 * Default model directory.
	 */
	public static final String PROPERTY_SETS_DIR = "propertysets";

	/**
	 * Name of preference for standard AADL property set file
	 */
	public static final String EXPAND_DEFAULT_FLAG = "expandXMLDefaults";

	/**
	 * Name of preference for the maximum number of system operation modes to generate.
	 */
	public static final String MAX_SOM = "maxSOM";
	public static final int MAX_SOM_DEFAULT = 1000;

	public static final String AUTO_REINSTANTIATE = "autoReinstantiate";
	public static final String AUTO_INDENT = "AUTO_INDENT";
	public static final String AUTO_COMPLETE = "AUTO_COMPLETE";
	public static final String CAPITALIZE = "CAPITALIZE";
	public static final String INDENT_SECTIONS = "INDENT_SECTIONS";

	// The shared instance.
	private static WorkspacePlugin plugin;

	// Resource bundle.
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public WorkspacePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.osate.workspace.WorkspacePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static WorkspacePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not
	 * found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = WorkspacePlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public static URL getInstallURL() {
		return plugin.getBundle().getEntry("/");
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(Throwable t) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, "WorkspacePlugin internal error", t));
	}

	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, message, null));
	}

	public static String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

//	Creates directory if it doesn't exist.
	public static void ensureDirectoryExistance(File toCheck) {
		if (!toCheck.exists()) {
			ensureDirectoryExistance(toCheck.getParentFile());
			toCheck.mkdir();
		}
	}

	public final int getSOMLimit() {
		final IPreferenceStore store = getPreferenceStore();
		return store.getInt(MAX_SOM);
	}
}