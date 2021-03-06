/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.jpa.event.internal.core;

import java.util.IdentityHashMap;

import org.hibernate.engine.spi.CascadingAction;
import org.hibernate.engine.spi.CascadingActions;
import org.hibernate.event.internal.DefaultFlushEventListener;
import org.hibernate.event.spi.FlushEventListener;

/**
 * In JPA, it is the create operation that is cascaded to unmanaged entities at flush time (instead of the
 * save-update operation in Hibernate).
 *
 * @author Gavin King
 */
public class JpaFlushEventListener extends DefaultFlushEventListener implements HibernateEntityManagerEventListener {
	public static final FlushEventListener INSTANCE = new JpaFlushEventListener();

	@Override
	protected CascadingAction getCascadingAction() {
		return CascadingActions.PERSIST_ON_FLUSH;
	}

	@Override
	protected Object getAnything() {
		return new IdentityHashMap( 10 );
	}

}
