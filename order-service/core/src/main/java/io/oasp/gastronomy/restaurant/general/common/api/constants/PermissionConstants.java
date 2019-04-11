
package io.oasp.gastronomy.restaurant.general.common.api.constants;

import com.devonfw.module.security.common.api.accesscontrol.AccessControlPermission;

/**
 * Contains constants for the keys of all {@link AccessControlPermission
 * Permission}s.
 */
public abstract class PermissionConstants {

	/** {@link AccessControlPermission Permission} to find customer. */
	public static final String FIND_CUSTOMER = "findCustomer";

	/** {@link AccessControlPermission Permission} to find item. */
	public static final String FIND_ITEM = "findItem";

	/** {@link AccessControlPermission Permission} to find order. */
	public static final String FIND_ORDER = "findOrder";

	/** {@link AccessControlPermission Permission} to save order. */
	public static final String SAVE_ORDER = "saveOrder";

}